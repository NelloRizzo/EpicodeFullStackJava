package it.epicode.w2d4.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendGridMailService implements MailService {

	@Value("${sendgrid}")
	private String apiKey;

	@Override
	public ServiceResponse sendMail(String from, String to, String subject, String body) {
		Email sender = new Email(from);
		Email recipient = new Email(to);
		Content content = new Content("text/plain", body);
		Mail mail = new Mail(sender, subject, recipient, content);

		SendGrid sg = new SendGrid(apiKey);
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			return new MailService.ServiceResponse(response.getBody(), response.getStatusCode());
		} catch (Exception e) {
			log.error("Exception sending mail", e);
			throw new RuntimeException(e);
		}
	}

}
