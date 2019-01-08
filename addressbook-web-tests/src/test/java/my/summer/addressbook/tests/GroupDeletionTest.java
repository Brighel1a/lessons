package my.summer.addressbook.tests;

import my.summer.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase{



    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("gg2", "123", "134"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().SelectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }


}
