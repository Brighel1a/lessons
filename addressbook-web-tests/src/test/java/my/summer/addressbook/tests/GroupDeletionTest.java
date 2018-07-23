package my.summer.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{



    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().SelectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }


}
