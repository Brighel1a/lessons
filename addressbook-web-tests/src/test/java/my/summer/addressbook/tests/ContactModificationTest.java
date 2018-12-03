package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){

    app.getNavigationHelper().gotoContact();
    app.getContactHelper().gotoEditContact();
    app.getContactHelper().fillContactForm(new ContactData("Проверю1",null, null, null, "fgdgf", "gf", "gfrt","sdf", "Проверка1", null), false);
    app.getContactHelper().updateContact();


  }


}
