package my.summer.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {super(wd);
  }

  public void gotoGroupPage() {

  click(By.linkText("groups"));
  }
  public void gotoNewContact() {
    click(By.linkText("add new"));
  }

  public void gotoContact(){
    click(By.linkText("home"));
  }
}
