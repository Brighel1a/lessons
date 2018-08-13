package my.summer.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{


  @Test
  public void testContactDeletion() {

    app.getNavigationHelper().gotoContact();
    app.getContactHelper().gotoEdidContact();

  }


}
