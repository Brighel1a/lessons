package my.summer.addressbook.tests;

import my.summer.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

     @Test
  public void testGroupModificationTests(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().SelectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData(null, "123", "новое"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
