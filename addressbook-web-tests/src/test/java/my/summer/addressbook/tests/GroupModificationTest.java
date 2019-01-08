package my.summer.addressbook.tests;

import my.summer.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase{

     @Test
  public void testGroupModificationTests(){
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().SelectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();

    app.getGroupHelper().fillGroupForm(new GroupData("mew", "123", "новое"));
       GroupData group = new GroupData(before.get(before.size() - 1).getId(),"mew", "123", "новое");
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
       Assert.assertEquals(after.size(), before.size());

       before.remove(before.size() - 1);
       before.add(group);
       Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }
}
