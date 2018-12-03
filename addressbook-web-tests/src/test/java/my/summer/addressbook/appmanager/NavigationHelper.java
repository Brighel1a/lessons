package my.summer.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {super(wd);
  }

  public void gotoGroupPage() {
    if(isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.tagName("new"))){
      return;
    } else {
      click(By.linkText("groups"));
    }
  }
  public void gotoNewContact() {
    if (isElementPresent(By.tagName("h1"))
            && isElementPresent(By.name("submit"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
      return;
    } else {
      click(By.linkText("add new"));
    }
  }

  public void gotoContact(){
    if (isElementPresent(By.id("maintable"))) {
      return;
    } else {
      click(By.linkText("home"));
    }
    }

  }

