package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import my.summer.addressbook.models.Contacts;
import my.summer.addressbook.models.GroupData;
import my.summer.addressbook.models.Groups;
import org.testng.annotations.Test;

public class ContactDelGroupTest extends TestBase {

  @Test
  public void testContactDelGroup(){
    app.goTo().groupPage();
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    if (groups.size() == 0) {
      createGroup(groups);
    }
    if (contacts.size() == 0) {
      createContact(contacts);
    }




  }


  private void createContact(Contacts contacts) {
    ContactData contact = new ContactData().withFirstname("NameContact").withLastname("Lastname")
            .withAddress("Address №1").withEmailFrst("contact@mail.ru").withPhoneMobile("+123-54");
    app.goTo().gotoContact();
    app.contact().create(contact);
    contacts.add(contact);
  }

  private void createGroup(Groups groups) {
    GroupData group = new GroupData().withGroupname("addNameforTectGroup").withHeader("addForContact");
    app.goTo().groupPage();
    app.group().create(group);
    app.goTo().gotoContact();
    groups.add(group);
  }
}
