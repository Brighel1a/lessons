package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test (enabled=false)
  public void testContactModification(){
    app.goTo().gotoContact();
    List<ContactData> before = app.contact().getContactList();
    //app.getContactHelper().selectContact(before.size()-1);
    app.contact().gotoEditContact(before.size()-1);
    app.contact().fillContactForm(new ContactData("Проверю3",null, "Есть", "ЕстьНик", "fgdgf", "gf", "gfrt","sdf", "Проверка1", null), false);
    ContactData contact = new ContactData("Проверю3",null, "Есть", "Есть", "fgdgf", "gf", "gfrt","sdf", "Проверка1", null, before.get(before.size() - 1).withId());
    app.contact().updateContact();
    app.goTo().gotoContact();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Assert.assertEquals(after, before);
  }


}
