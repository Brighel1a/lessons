package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Rexs", "Recs", "Reechard", "Meeay", "not", "Good", "1252", "dfff@12-1"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContact();
  }



}