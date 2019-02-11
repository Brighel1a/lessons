package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.testng.annotations.Test;


public class ContactPhoneTest extends TestBase{

  @Test (enabled=false)
  public void testContactPhone(){
    app.goTo().gotoContact();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEdotForm = app.contact();
  }
}
