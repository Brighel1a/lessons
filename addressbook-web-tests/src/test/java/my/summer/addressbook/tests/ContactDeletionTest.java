package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase{


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoContact();
    List<ContactData> before = app.getContactHelper().getContactList();
    //app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().gotoEditContact(before.size()-1);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }


}
