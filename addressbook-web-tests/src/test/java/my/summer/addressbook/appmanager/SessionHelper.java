package my.summer.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper  extends HelperBase{



  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"),password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
}