package com.projeto_final.Kaspper.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

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
            String htmlContent = buildHtmlTemplate(cliente.getNomeCliente(), cliente.getTipoCliente(), cliente.getCpfCnpj(), cliente.getEmail(), cliente.getTelefone(), cliente.getCep(), cliente.getEndereco(), cliente.getBairro(), cliente.getComplemento(), projeto.getQuantidadeFuncionalidades(), projeto.getComplexidadeProjeto(), projeto.getPrazoProjeto());

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
            String telefone, String cep, String endereco, String bairro, String complemento, Integer quantidadeFuncionalidades, String complexidadeProjeto, String prazoProjeto) {
        return String.format("""
<!DOCTYPE html>
<html>
<head>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #2c3e50; text-align: center; }
        .header, .footer { text-align: center; background-color: #f4f4f4; padding: 10px; }
        .content { margin: 20px; padding: 20px; border: 1px solid #ddd; border-radius: 10px; }
        .field { margin-bottom: 10px; }
        .field span { font-weight: bold; color: #2c3e50; }
        .grid { display: grid; grid-template-columns: 1fr 1fr; gap: 10px; }
    </style>
</head>
<body>
    <div class="header">
        <h1>Pré-Orçamento</h1>
        <p>Documento gerado automaticamente</p>
    </div>
    <div class="content">
        <div class="field"><span>Nome Cliente:</span> %s</div>
        <div class="field"><span>Tipo de Cliente:</span> %s</div>
        <div class="field"><span>CPF/CNPJ:</span> %s</div>
        <div class="field"><span>Email:</span> %s</div>
        <div class="field"><span>Telefone:</span> %s</div>
        <div class="field"><span>CEP:</span> %s</div>
        <div class="field"><span>Endereço:</span> %s</div>
        <div class="field"><span>Bairro:</span> %s</div>
        <div class="field"><span>Complemento:</span> %s</div>
        <div class="field"><span>Quantidade de Funcionalidade:</span> %s</div>
        <div class="field"><span>Complexidade do Projeto:</span> %s</div>
        <div class="field"><span>Prazo do Projeto:</span> %s</div>
          
    </div>
    <div class="footer">
        <p>Obrigado por escolher nossos serviços!</p>
    </div>
</body>
</html>
""", nomeCliente, tipoCliente, cpfCnpj, email, telefone, cep, endereco, bairro, complemento, quantidadeFuncionalidades.toString(), complexidadeProjeto, prazoProjeto);
    }

    public void sendEmailWithPDF(String to, String subject, String body, byte[] pdfData, String fileName) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            helper.addAttachment(fileName, () -> new ByteArrayInputStream(pdfData));

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar e-mail com PDF", e);
        }
    }
}
