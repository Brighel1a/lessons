package my.summer.addressbook.tests;

import my.summer.addressbook.models.GroupData;
import my.summer.addressbook.models.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(app.db().groups().size()==0){
    app.goTo().groupPage();
    app.group().create(new GroupData().withGroupname("Test2"));
    }
  }

     @Test
  public void testGroupModificationTests(){
       Groups before = app.db().groups();
       GroupData modificationGroup = before.iterator().next();
       GroupData group = new GroupData()
               .withId(modificationGroup.getId()).withGroupname("smile").withFooter("new").withHeader("use");
       app.goTo().groupPage();
       app.group().modify(group);
       assertThat(app.group().count(), equalTo(before.size()));
       Groups after = app.db().groups();

       assertThat(after, equalTo(before.without(modificationGroup).withAdded(group)));
       verifyGroupListInUI();
  }




}
