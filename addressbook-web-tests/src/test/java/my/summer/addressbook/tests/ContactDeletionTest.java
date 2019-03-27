package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import my.summer.addressbook.models.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().gotoContact();
  }

  @Test (enabled=true)
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();


    assertThat(after, equalTo(((Contacts) before).without(deletedContact)));
  }

}
