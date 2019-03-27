package my.summer.addressbook.appmanager;

import my.summer.addressbook.models.ContactData;
import my.summer.addressbook.models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fill(ContactData contactData, boolean creation) {
    typeContact(By.name("firstname"), contactData.firstname());
    typeContact(By.name("middlename"), contactData.middlename());
    typeContact(By.name("lastname"), contactData.lastname());
    typeContact(By.name("nickname"), contactData.nick());
    typeContact(By.name("title"), contactData.title());
    typeContact(By.name("company"), contactData.company());
    typeContact(By.name("fax"), contactData.fax());
    typeContact(By.name("address2"), contactData.address());
    typeContact(By.name("home"), contactData.phoneHome());
    typeContact(By.name("mobile"), contactData.phoneMobile());
    typeContact(By.name("work"), contactData.phoneWork());
    typeFile(By.name("photo"), contactData.photo());
    if (creation) {
      if (isElementPresent(By.xpath("//select[@id='new_group']/option[2])"))) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.group());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void typeContact(By locator, String nameElement) {
    if (nameElement != null) {
      String existingText = wd.findElement(locator).getAttribute("Value");
      if (!nameElement.equals(existingText)) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(nameElement);
      }
    }
  }


  public void typeFile(By locator, File file) {
    if (file != null) {
      wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }

  public void submitContactCreation() {
    click(By.cssSelector("input[name='submit']"));
  }

  public void returnToContact() {
    click(By.linkText("home page"));
  }

  public void returnFromCreateToContact() {
    click(By.linkText("home"));
  }

  public void newContact() {
    click(By.xpath(".//li/a[text()='add new']"));
  }


  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void gotoEditContact(int index) {
    if (wd.findElements(By.xpath("//img[@title='Edit']")) != null) {
      wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
    }
  }


  public void gotoEditContactById(int id) {
    if (wd.findElements(By.xpath("//img[@title='Edit']")) != null) {
      wd.findElement(By.xpath(String.format("//input[@id='%s']/../../td[@class=\"center\"]/a/img[@title='Edit']", id)   )).click();
    }
  }

  private void gotoDetailContactById(int id) {
    click(By.xpath(String.format(".//input[@id='%s']/ancestor::*/td/a/img[@title='Details']", id)));
  }

  public void updateContact() {
    click(By.xpath("//input[@value='Update']"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void create(ContactData newContact) {
      newContact();
      fill(newContact, true);
      submitContactCreation();
      contactCache = null;
    returnFromCreateToContact();
  }

  public void modify(ContactData contact) {
    gotoEditContactById(contact.getId());
    fill(contact, false);
    updateContact();
    contactCache = null;
    returnFromCreateToContact();
  }

  public void delete(ContactData deletedContact) {
    gotoEditContactById(deletedContact.getId());
    deleteContact();
    contactCache = null;
    returnFromCreateToContact();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache!= null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    Set<Contacts> contacts = new HashSet<>();
    List<WebElement> rows = wd.findElements(By.xpath(".//tr[@name='entry']"));
    for (WebElement row: rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allPhones = cells.get(5).getText(); //.split("\n");
      String allEmail = cells.get(4).getText();
      String address = cells.get(3).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName)
              .withAllPhones(allPhones).withAllEmail(allEmail).withAddress(address));
      contacts.add(contactCache);
    }
    return new Contacts(contactCache);

  }

  public void selectContactById(int id) {
    wd.findElement(By.xpath("//input[@id='" + id + "']")).click();
  }


  public ContactData infoFromEditForm(ContactData contact) {
    gotoEditContactById(contact.getId());
    String firstName = wd.findElement(By.xpath(".//input[@name='firstname']")).getAttribute("value");
    String middlename = wd.findElement(By.xpath(".//input[@name='middlename']")).getAttribute("value");
    String lastName = wd.findElement(By.xpath(".//input[@name='lastname']")).getAttribute("value");
    String phoneHome = wd.findElement(By.xpath(".//input[@name='home']")).getAttribute("value");
    String phoneMobile = wd.findElement(By.xpath(".//input[@name='mobile']")).getAttribute("value");
    String phoneWork = wd.findElement(By.xpath(".//input[@name='work']")).getAttribute("value");
    String emailFrst = wd.findElement(By.xpath(".//input[@name='email']")).getAttribute("value");
    String emailScnd = wd.findElement(By.xpath(".//input[@name='email2']")).getAttribute("value");
    String emailThrd = wd.findElement(By.xpath(".//input[@name='email3']")).getAttribute("value");
    String address = wd.findElement(By.xpath(".//textarea[@name='address']")).getText();
    ContactData editContact = new ContactData().withFirstname(firstName).withMiddlename(middlename).withLastname(lastName).withAddress(address).withPhoneHome(phoneHome)
            .withPhoneMobile(phoneMobile).withPhoneWork(phoneWork).withEmailFrst(emailFrst).withEmailScnd(emailScnd).withEmailThrd(emailThrd);
    returnFromCreateToContact();
    return editContact;
    }

  public ContactData infoFromDetailsForm(ContactData fromHome) {
    gotoDetailContactById(fromHome.getId());
    String allInfo = wd.findElement(By.xpath(".//div[@id='content']")).getText();
    ContactData detailsContact = new ContactData().withAllInfo(allInfo);
    return detailsContact;
  }


}


