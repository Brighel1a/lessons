package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

public class ContactDetailsTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().gotoContact();
  }

  @Test
  public void testFromDetailsToHome()  {

    ContactData fromHome = app.contact().all().iterator().next();
    ContactData contactInfoEdit = app.contact().infoFromEditForm(fromHome);
    ContactData contactInfoDetails = app.contact().infoFromDetailsForm(fromHome);

    MatcherAssert.assertThat(cleaned(mergeEdit(contactInfoEdit)), equalTo(cleaned(contactInfoDetails.allInfo())));


  }

//  private String mergeDetail(ContactData contactInfoDetails) {
//    Arrays.asList(contact.phoneHome(), contact.phoneMobile(), contact.phoneWork())
//            .stream().filter((s)->! s.equals(""))
//            .map(ContactHomeToPageTest::cleaned).collect((Collectors.joining("\n")));
//
//
//    return null;
//  }

  private String mergeEdit(ContactData contactInfoEdit) {
    return Arrays.asList(contactInfoEdit.firstname(), contactInfoEdit.middlename(), contactInfoEdit.lastname(),
            contactInfoEdit.address(), contactInfoEdit.phoneHome(), contactInfoEdit.phoneMobile(), contactInfoEdit.phoneWork(),
            contactInfoEdit.emailFrst(), contactInfoEdit.emailScnd(), contactInfoEdit.emailThrd())
            .stream().filter(s ->! s.equals(""))
            .collect(Collectors.joining(""));
  }


  public static String cleaned(String allInfo){
    return allInfo.replaceAll("\\s","").replaceAll("H:","").replaceAll("M:","").replaceAll("W:","").replaceAll(" ", "");
  }
}
