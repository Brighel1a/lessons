package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){

    app.getNavigationHelper().gotoContact();
    app.getContactHelper().gotoEditContact();
    app.getContactHelper().fillContactForm(new ContactData("jgh","lh", "ygghg", "hgfd", "fgdgf", "gf", "gfrt","sdf"));
    app.getContactHelper().updateContact();


  }


}
