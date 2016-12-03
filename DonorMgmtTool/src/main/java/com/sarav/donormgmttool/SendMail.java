/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarav.donormgmttool;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementHandler;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.end.ElementHandlerPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
 import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import java.io.OutputStream;
import java.io.StringReader;
import java.lang.annotation.Annotation;
import java.util.Properties;
import org.simpleframework.xml.ElementList;

/**
 *
 * @author sarav
 */
public class SendMail {
   
      /*
	public void send(String name,String email,float amount,int did,String dmode,java.sql.Date ddate) {

            System.out.println ("Initializing Mail with"+name);
		final String username = "tedmeverest@gmail.com";
		final String password = "Everest12/365";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("invoice@teameverestindia.org"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Team Everest Thanks you for your Donation!"+did);
			message.setContent("Dear ,"+name
				+ "Thanks for donating Rs&nbsp;" + amount + " on&nbsp;" + ddate + " towards Team Everest. This mail is to confirm your donation.<br>\n<br>\nKeep making a difference. To know more about Team Everest, please check<a href=\"https://www.teameverestindia.org/\">www.teameverestindia.org</a>)","text/html");

			Transport.send(message);

			System.out.println(" Sent Message! Done!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

    */
    /*
    public void send(String name,String email,float amount,int did,String dmode,java.sql.Date ddate) {
        
     // Recipient's email ID needs to be mentioned.
      //String to = "destinationemail@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "tedmeverest@gmail.com";

      final String username = "tedmeverest@gmail.com";//change accordingly
      final String password = "Everest12/365";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      

      Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(email));

         // Set Subject: header field
         message.setSubject("Team Everest Thanks you for your Donation!"+did);

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         
	messageBodyPart.setContent("Dear ,"+name
				+ "Thanks for donating Rs&nbsp;" + amount + " on&nbsp;" + ddate + " towards Team Everest. This mail is to confirm your donation.<br>\n<br>\nKeep making a difference. To know more about Team Everest, please check<a href=\"https://www.teameverestindia.org/\">www.teameverestindia.org</a>)","text/html");
        

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         String filename = "D:/TeamEverest/Development/receipts/file.txt";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);
                 
         // Send the complete message parts
         message.setContent(multipart);

         
         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
  
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
    */
    public void send(String name,String email,float amount,int did,String dmode,java.sql.Date ddate) {
        
     // Recipient's email ID needs to be mentioned.
      //String to = "destinationemail@gmail.com";

      
      float Rec_Amount = amount;
      java.sql.Date Rec_date  = ddate;
      int Rec_Number = did;
      String Rec_name = name;
      String Rec_mode = dmode;
      
      // Sender's email ID needs to be mentioned
      String from = "tedmeverest@gmail.com";

      final String username = "tedmeverest@gmail.com";//change accordingly
      final String password = "Everest12/365";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      

      Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

                     ByteArrayOutputStream outputStream = null;
      
                     Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });
                     
        try {           
            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent("<div style=\"font-family: calibri; font-size: 14px\"><b>Dear "+name+"</b><br><br>"
				+ "Thanks for donating Rs&nbsp;" + amount + " on&nbsp;" + ddate + " towards Team Everest. This mail is to confirm your donation.<br>\n<br>\nKeep making a difference. To know more about Team Everest, please check<a href=\"https://www.teameverestindia.org/\">www.teameverestindia.org</a> <br><br> <b>Thanks, <br>TeamEverest</b></div>","text/html");
             
            //now write the PDF content to the output stream
            outputStream = new ByteArrayOutputStream();
            writePdf(outputStream,Rec_Amount,Rec_date,Rec_Number,Rec_name,Rec_mode);
            byte[] bytes = outputStream.toByteArray();
             
            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("DonationEReceipt"+did+"_"+name+".pdf");
                         
            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);
             
            String sender= "tedmeverest@gmail.com";
            //create the sender/recipient addresses
            InternetAddress iaSender = new InternetAddress(sender);
            InternetAddress iaRecipient = new InternetAddress(email);
             
            //construct the mime message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject("Thanks for Donating to TeamEverest!");
            mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
            mimeMessage.setContent(mimeMultipart);
             
            //send off the email
            Transport.send(mimeMessage);
             
            System.out.println("sent from " + sender + 
                    ", to " + email );         
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            //clean off
            if(null != outputStream) {
                try { outputStream.close(); outputStream = null; }
                catch(Exception ex) { }
            }
        }
    }
    
        public void writePdf(OutputStream outputStream,float ramount,java.sql.Date rdate,int rnum,String rname,String rmode) throws Exception {
            
            
        Document document = new Document();
        
        //step2 http://developers.itextpdf.com/examples/xml-worker-itext5/html-tables
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        
        String PDFContent = "<center>\n" +
"        <table style=\"text-align:center\">\n" +
"            <tr>\n" +
"                <td>\n" +
"                    <img src=\"Images/Small - Team Everest Logo.png\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
"                </td>\n" +
"                <td>\n" +
"                    <h1 style=\"font-family: Arial\"><b><u>Team Everest</u></b></h1><b>(Regd No: 2292/09)</b>\n" +
"                    <p style=\"font-family: Times\"> 5/1B, Magaveerar Street, Arnipalayam, Arni – 632301<br>\n" +
"                        Tiruvannamalai Dt, Tamilnadu, India Phone: +91 89399 12365<br>\n" +
"                        Email: info@teameverestindia.org   Website: www.teameverestindia.org</p>\n" +
"                </td>\n" +
"            </tr>\n" +
"            <tr><td><br><br><br><br></td></tr>\n" +
"            <tr>\n" +
"                <td>\n" +
"                    <b>Reciept No:</b>*********\n" +
"                </td>\n" +
"                <td>\n" +
"                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
"                </td>\n" +
"                <td>\n" +
"                    <b>Date:</b>********\n" +
"                </td>\n" +
"            </tr>\n" +
"            <tr><td><br><br><br><br></td></tr>\n" +
"            <tr>\n" +
"                <td></td>\n" +
"                <td>\n" +
"                    <p style=\"font-family: Times\">Received the sum of Rs. <b>*****/- (*******)</b>, with thanks from\n" +
"                        <b>*******</b>  as donation for Team Everest.</p>\n" +
"                </td>\n" +
"            </tr>\n" +
"            <tr><td><br><br><br><br></td></tr>\n" +
"            <tr>\n" +
"                <td></td>\n" +
"                <td>\n" +
"                    <p style=\"text-align:left\"><b>Amount:</b> Rs.********&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Mode of Donation:</b>********</p>\n" +
"                </td>\n" +
"            </tr>\n" +
"            <tr><td><br><br><br><br></td></tr>\n" +
"            <tr><td><br><br><br><br></td>\n" +
"                <td style=\"text-align:right\">\n" +
"                    <p>For Team Everest&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n" +
"                    <img src =\"Images/Signature.JPG\">\n" +
"                </td>\n" +
"            </tr>\n" +
"            <tr><td><br><br><br><br></td></tr>\n" +
"            <tr>\n" +
"                <td></td>\n" +
"                <td>\n" +
"                    <p>*Donations are exempted under 80G of Income Tax Act<br>\n" +
"                       1961 C, No. DIT (E) No. 2 (19) 1011. Pan No: AABTT6850G.</p>\n" +
"                </td>\n" +
"            </tr>\n" +
"        </table>\n" +
"        </center>";
        document.open();
         
        document.addTitle("EReceipt");
        document.addSubject("EreceiptPDF");
        document.addKeywords("iText, email");
        document.addAuthor("AKSarav");
        document.addCreator("AkSarav");
         
        //HTMLWorker htmlworker = new HTMLWorker(document);
        
        StringBuilder contentBuilder = new StringBuilder();
        Paragraph paragraph = new Paragraph();
        
        //System.out.println("PDFCONTENT"+PDFContent);
        contentBuilder.append(PDFContent);
        
        //HTML Processor
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
        // Pipelines
        PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
        HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);

        //XMLWorker
        XMLWorker worker = new XMLWorker(html, true);
        XMLParser p = new XMLParser(worker);
        p.parse(new ByteArrayInputStream(contentBuilder.toString().getBytes()));
        
        // Closing the document
         
        document.close();
    }

}


