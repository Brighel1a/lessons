package my.summer.addressbook.tests;


import my.summer.addressbook.models.GroupData;
import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.getGroupHelper().initGroupCreator();
    app.getGroupHelper().fillGroupForm(new GroupData("gg2", "123", "134"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
