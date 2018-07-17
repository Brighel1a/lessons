package my.summer.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreator();
    fillGroupForm(new GroupData("gg2", "123", "134"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
