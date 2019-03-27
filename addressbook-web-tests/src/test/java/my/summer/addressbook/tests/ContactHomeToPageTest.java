package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactHomeToPageTest extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().gotoContact();
  }

  @Test (enabled=true)
  public void testContactAddress(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.address(), equalTo(contactInfoFormEditForm.address()));
  }

  @Test (enabled=false)
  public void testContactEmail(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.allEmail(), equalTo(mergeEmail(contactInfoFormEditForm)));
  }

  @Test (enabled=false)
  public void testContactPhone(){

    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.allPhones(), equalTo(mergePhones(contactInfoFormEditForm)));
  }



  private String mergeEmail(ContactData contact) {
    return Arrays.asList(contact.emailFrst(),contact.emailScnd(), contact.emailThrd())
            .stream().filter((s) ->! s.equals("")).collect(Collectors.joining("\n"));
  }

  private  String mergePhones(ContactData contact) {
    return Arrays.asList(contact.phoneHome(), contact.phoneMobile(), contact.phoneWork())
            .stream().filter((s)->! s.equals(""))
            .map(ContactHomeToPageTest::cleaned).collect((Collectors.joining("\n")));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

}
