package my.summer.addressbook.appmanager;

import my.summer.addressbook.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    typeContact(By.name("firstname"), contactData.getFirstname());
    typeContact(By.name("middlename"), contactData.getMiddlename());
    typeContact(By.name("lastname"), contactData.getLastname());
    typeContact(By.name("nickname"), contactData.getNick());
    typeContact(By.name("title"), contactData.getTitle());
    typeContact(By.name("company"), contactData.getCompany());
    typeContact(By.name("home"), contactData.getHome());
    typeContact(By.name("fax"), contactData.getFax());
    typeContact(By.name("address2"), contactData.getAddress());
    if (creation) {
      if (isElementPresent(By.xpath("//select[@id='new_group']/option[2])"))) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }
    }
     else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void typeContact(By locator, String nameElement) {
    if (nameElement != null) {
      String existingText = wd.findElement(locator).getAttribute("Value");
      if (! nameElement.equals(existingText)) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(nameElement);
      }
    }
  }

  public void submitContactCreation() {
    click(By.cssSelector("input[name='submit']"));
  }

  public void returnToContact() {
    click(By.linkText("home page"));
  }

  public void deleteContact (){
    click(By.xpath("//input[@value='Delete']"));
  }

  public void gotoEditContact(int index) {
    if (wd.findElement(By.xpath("//img[@title='Edit']")) != null) {
      wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
    }
  }

  public void updateContact(){
    click(By.xpath("//input[@value='Update']"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elementsLastName = wd.findElements(By.xpath(".//tbody/*/td[2]"));
    List<WebElement> elementsFirstName = wd.findElements(By.xpath(".//tbody/*/td[3]"));
    for (int i=0;i<elementsLastName.size();i++){
      int id = Integer.parseInt(elementsLastName.get(i).findElement(By.xpath("preceding-sibling::td/input")).getAttribute("id"));
        ContactData contact = new ContactData(elementsFirstName.get(i).getText(), null, elementsLastName.get(i).getText(), null, null, null, null, null, null, null, id);
        contacts.add(contact);
    }
    return contacts;
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }


}
