package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase{


  @Test (enabled=false)
  public void testContactDeletion() {
    app.goTo().gotoContact();
    List<ContactData> before = app.contact().getContactList();
    //app.getContactHelper().selectContact(before.size()-1);
    app.contact().gotoEditContact(before.size()-1);
    app.contact().deleteContact();
    app.goTo().gotoContact();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }


}
