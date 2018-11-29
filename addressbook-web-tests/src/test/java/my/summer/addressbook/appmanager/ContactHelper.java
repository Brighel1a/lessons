package my.summer.addressbook.appmanager;

import my.summer.addressbook.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData) {
    typeContact(By.name("firstname"), contactData.getFirstname());
    typeContact(By.name("middlename"), contactData.getMiddlename());
    typeContact(By.name("lastname"), contactData.getLastname());
    typeContact(By.name("nickname"), contactData.getNick());
    typeContact(By.name("title"), contactData.getTitle());
    typeContact(By.name("company"), contactData.getCompany());
    typeContact(By.name("home"), contactData.getHome());
    typeContact(By.name("fax"), contactData.getFax());
  }

  public void typeContact(By locator, String nameElement) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(nameElement);
  }

  public void submitContactCreation() {
    click(By.cssSelector("input[name='submit']"));
  }

  public void returnToContact() {
    click(By.linkText("home page"));
  }

  public void selectContact (){
    click(By.linkText("selected[]"));
  }

  public void deleteContact (){
    click(By.xpath("//input[@value='Delete']"));
  }

  public void gotoEditContact() {
    click(By.xpath("//img[@title='Edit']"));
  }
  public void updateContact(){
    click(By.xpath("//input[@value='Update']"));
  }

}
