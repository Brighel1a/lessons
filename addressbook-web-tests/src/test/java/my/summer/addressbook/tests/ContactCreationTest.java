package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoContact();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Rexs", "Recs", "Reechard", "Meeay", "not", "Good", "1252", "dfff@12-1", "Проверка", "gg2"), true);
    ContactData contact = new ContactData("Rexs", "Recs", "Reechard", "Meeay", "not", "Good", "1252", "dfff@12-1", "Проверка", "gg2");
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<>(after), new HashSet<>(before));

  }



}