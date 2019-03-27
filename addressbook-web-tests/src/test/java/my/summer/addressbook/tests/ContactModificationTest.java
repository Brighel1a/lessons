package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import my.summer.addressbook.models.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {


  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().gotoContact();
  }

  @Test (enabled=true)
  public void testContactModification(){
    Contacts before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData().withFirstname("New name")
            .withLastname("New Lst name").withMiddlename("New middle name").withAddress("new address").withId(modifyContact.getId());
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();


    assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
  }


}
