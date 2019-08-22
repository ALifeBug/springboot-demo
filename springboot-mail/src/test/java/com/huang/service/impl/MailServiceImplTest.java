package com.huang.service.impl;

import com.huang.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("3293971399@qq.com","test simple mail","this is a simple mail");
    }

    @Test
    public void sendHtmlMail() {
        String content = "<html>\n" +
                "<body>\n" +
                "   <h3>这是一封html邮件</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("3293971399@qq.com","test html mail",content);
    }

    @Test
    public void sendAttachmentMail() {
        String filePath = "D:\\book\\Docker即学即用.pdf";
        mailService.sendAttachmentMail("3293971399@qq.com","带附件的邮件","有附件，请查收",filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "hqs001";
        String content = "<html>\n" +
                "<body>\n" +
                "这是有图片的邮件：<img src=\'cid:" + rscId + "\' >\n" +
                "</body>\n" +
                "</html>";
        String imgPath = "C:\\Users\\sccy\\图片\\1-150131153615.jpg";
        mailService.sendInlineResourceMail("3293971399@qq.com","这是有图片的邮件",content,imgPath,rscId);
    }

    @Test
    public void sendTemplateMail(){
        Context context = new Context();
        context.setVariable("id","005");
        String emailContent = templateEngine.process("emailTemplate",context);

        mailService.sendHtmlMail("3293971399@qq.com","这是模板邮件",emailContent);
    }
}