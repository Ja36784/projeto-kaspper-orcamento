package com.projeto_final.Kaspper.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.projeto_final.Kaspper.model.Cliente;
import com.projeto_final.Kaspper.model.Projeto;
import com.projeto_final.Kaspper.model.TipoPessoa;

import jakarta.mail.internet.MimeMessage;

@Service
public class PDFGeneratorService {

    @Autowired
    private JavaMailSender mailSender;

    public byte[] generateOrcamentoPDFWithTemplate(Cliente cliente, Projeto projeto) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // Adicionando os novos parâmetros
            Double valorFuncionalidade = projeto.getValorFuncionalidade(); // Exemplo: método para calcular o valor
            Double valorIntegracao = projeto.getValorIntegracao(); // Método para calcular o valor de integração
            Double valorAutomacao = projeto.getValorAutomacao(); // Método para calcular o valor de automação
            Double custoTotal = projeto.getCustoTotal(); // Método para calcular o custo total

            String htmlContent = buildHtmlTemplate(
                    cliente.getNomeCliente(),
                    cliente.getTipoCliente(),
                    cliente.getCpfCnpj(),
                    cliente.getEmail(),
                    cliente.getTelefone(),
                    cliente.getCep(),
                    cliente.getEndereco(),
                    cliente.getBairro(),
                    cliente.getComplemento(),
                    projeto.getQuantidadeFuncionalidades(),
                    projeto.getComplexidadeProjeto(),
                    projeto.getPrazoProjeto(),
                    valorFuncionalidade,
                    valorIntegracao,
                    valorAutomacao,
                    custoTotal,
                    projeto.getQuantasIntegracao(),
                    projeto.getQuantasAutomacao()
            );

            // Inicializa o ITextRenderer para gerar o PDF
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();

            // Gera o PDF para o ByteArrayOutputStream
            renderer.createPDF(outputStream);

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar o PDF estilizado", e);
        }
    }

    private String buildHtmlTemplate(String nomeCliente, TipoPessoa tipoCliente, String cpfCnpj, String email,
            String telefone, String cep, String endereco, String bairro, String complemento,
            Integer quantidadeFuncionalidades,
            String complexidadeProjeto, String prazoProjeto, Double valorFuncionalidade, Double valorIntegracao,
            Double valorAutomacao, Double custoTotal, Integer quantasIntegracao, Integer quantasAutomacao) {

// Verificar se tipoCliente é null antes de acessar getName()
        String tipoClienteName = (tipoCliente != null && tipoCliente.getName() != null) ? tipoCliente.getName() : "Desconhecido";

// Formatação de valores monetários
        DecimalFormat df = new DecimalFormat("#,###,##0.00");

        String valorFuncionalidadeFormatado = df.format(valorFuncionalidade);
        String valorIntegracaoFormatado = df.format(valorIntegracao);
        String valorAutomacaoFormatado = df.format(valorAutomacao);
        String custoTotalFormatado = df.format(custoTotal);

        return String.format(
                """
<!DOCTYPE html>
<html>
<head>
<style>
    body { 
        font-family: Arial, sans-serif; 
        margin: 0; 
        padding: 0; 
        background-color: #f9f9f9; 
        color: #333;
    }
    h1 { 
        color: #2c3e50; 
        text-align: center; 
        font-size: 24px; 
        margin: 10px 0;
    }
    .header, .footer { 
        text-align: center; 
        background-color: #2c3e50; 
        color: white; 
        padding: 15px 10px; 
    }
    .content { 
        margin: 20px; 
        padding: 20px; 
        border: 1px solid #ddd; 
        border-radius: 10px; 
        background-color: white; 
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    .section { 
        margin-bottom: 20px; 
    }
    .section h2 { 
        font-size: 18px; 
        color: #2c3e50; 
        border-bottom: 2px solid #2c3e50; 
        margin-bottom: 10px; 
        padding-bottom: 5px; 
    }
    .field { 
        margin-bottom: 10px; 
        line-height: 1.6; 
    }
    .field span { 
        font-weight: bold; 
        color: #2c3e50; 
    }
    .footer p { 
        font-size: 14px; 
        margin: 0; 
    }
</style>
</head>
<body>
<div class="header">
    <h1>Pré-Orçamento</h1>
    <p>Proposta de Pré Orçamento </p>
</div>
<div class="content">
    <div class="section">
        <h2>Informações do Cliente</h2>
        <div class="field"><span>Nome Cliente:</span> %s</div>
        <div class="field"><span>Tipo de Cliente:</span> %s</div>
        <div class="field"><span>CPF/CNPJ:</span> %s</div>
        <div class="field"><span>Email:</span> %s</div>
        <div class="field"><span>Telefone:</span> %s</div>
        <div class="field"><span>CEP:</span> %s</div>
        <div class="field"><span>Endereço:</span> %s</div>
        <div class="field"><span>Bairro:</span> %s</div>
        <div class="field"><span>Complemento:</span> %s</div>
    </div>
    <div class="section">
        <h2>Detalhes do Orçamento</h2>
        <div class="field"><span>Quantidade de Funcionalidades:</span> %d</div>
        <div class="field"><span>Valor das Funcionalidades:</span> R$ %s</div>
        <div class="field"><span>Quantidade de Integrações:</span> %d</div>
        <div class="field"><span>Valor da Integração:</span> R$ %s</div>
        <div class="field"><span>Quantidade de Automação:</span> %d</div>
        <div class="field"><span>Valor da Automação:</span> R$ %s</div>
        <div class="field"><span>Complexidade do Projeto:</span> %s</div>
        <div class="field"><span>Prazo do Projeto:</span> %s</div>
        <div class="field"><span>Custo Total do Projeto:</span> R$ %s</div>
    </div>
</div>
<div class="footer">
    <p>Este é um valor aproximado, sujeito a alterações conforme o detalhamento do projeto.</p>
</div>
</body>
</html>
""",
                nomeCliente, tipoClienteName, cpfCnpj, email, telefone, cep, endereco, bairro, complemento,
                quantidadeFuncionalidades, valorFuncionalidadeFormatado, quantasIntegracao, valorIntegracaoFormatado,
                quantasAutomacao, valorAutomacaoFormatado, complexidadeProjeto, prazoProjeto, custoTotalFormatado);
    }

    // Método para enviar o e-mail com o PDF anexado
    public void sendEmailWithPDF(String to, String subject, String body, byte[] pdfData, String fileName) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Definindo destinatário, assunto e corpo do e-mail
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            // Adicionando o PDF como anexo
            helper.addAttachment(fileName, () -> new ByteArrayInputStream(pdfData));

            // Enviando o e-mail
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar e-mail com PDF", e);
        }
    }
}
