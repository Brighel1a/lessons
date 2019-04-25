package my.summer.mantis.tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import my.summer.mantis.appmanager.ApplicationManager;
import my.summer.mantis.appmanager.MailHelper;
import my.summer.mantis.model.MailMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends TestBase {

  //@BeforeMethod
  public  void startMailServer(){
    app.mail().start();
  }


  @Test
  public void testRegistration() throws IOException, MessagingException, javax.mail.MessagingException {
    long now = System.currentTimeMillis();
    String addr = String.format("user%s@localhost", now) ;
    String login = String.format("user%s", now);
    String password = "password";
    app.james().createUser(login, password);
    app.registration().start(login, addr);
    List<MailMessage> mailMessages = app.james().waitForMail(login, password, 80000);
    //List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, addr);

    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(login, password));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String addr) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(addr)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  //@AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }
}
