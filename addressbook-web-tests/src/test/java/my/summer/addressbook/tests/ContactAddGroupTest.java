package my.summer.addressbook.tests;

import my.summer.addressbook.models.ContactData;
import my.summer.addressbook.models.Contacts;
import my.summer.addressbook.models.GroupData;
import my.summer.addressbook.models.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ContactAddGroupTest extends TestBase {

  List<Integer> groupsIdFromDbAfter;

  @BeforeTest
  public void predictions() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    if (groups.size() == 0) {
      createGroup(groups);
    }
    if (contacts.size() == 0) {
      createContact(contacts);
    }
    app.goTo().gotoContact();
  }


  @Test
  public void testContactAddGroup() {
    Groups groupsFromDb = app.db().groups();
    Set<GroupData> setGroupsFromDb = new HashSet<>(app.db().groups());
    Contacts contacts = app.db().contacts();
    int contactId = contacts.iterator().next().getId();
    Set<GroupData> existingGroupsOfContact = new HashSet<>(app.db().linkToContactGroupId(contactId));
    int group_id = 0;
    if(groupsFromDb.size()==existingGroupsOfContact.size()&&setGroupsFromDb.equals(existingGroupsOfContact)){
      createGroupReturnId(groupsFromDb);
      Set<GroupData> symmetricDiff = new HashSet<>(groupsFromDb);
      symmetricDiff.removeAll(existingGroupsOfContact);
      group_id = symmetricDiff.iterator().next().getId();

    }else if(groupsFromDb.size()!=existingGroupsOfContact.size()&&setGroupsFromDb.removeAll(existingGroupsOfContact)){
      Set<GroupData> symmetricDiff = new HashSet<>(groupsFromDb);
      symmetricDiff.removeAll(existingGroupsOfContact);
      group_id = symmetricDiff.iterator().next().getId();

    } else{
      group_id = groupsFromDb.iterator().next().getId();
    }
    app.goTo().gotoContact();
    app.contact().selectContactById(contactId);
    app.contact().selectGroupById(group_id);
    app.contact().addGroupToContact();

    groupsIdFromDbAfter =  app.db().linkToContactGroupId(contactId)
            .stream()
            .map(g->g.getId())
            .collect(Collectors.toList());
    Assert.assertTrue(groupsIdFromDbAfter.contains(group_id));
  }

  private static void createContact(Contacts contacts) {
    ContactData contact = new ContactData().withFirstname("NameContact").withLastname("Lastname")
            .withAddress("Address №1").withEmailFrst("contact@mail.ru").withPhoneMobile("+123-54");
    app.goTo().gotoContact();
    app.contact().create(contact);
    contacts.add(contact);
  }

  private static void createGroup(Groups groups) {
    GroupData group = new GroupData().withGroupname("addNameforTectGroup").withHeader("addForContact");
    app.goTo().groupPage();
    app.group().create(group);
    app.goTo().gotoContact();
    groups.add(group);
  }

  private int createGroupReturnId(Groups groupsFromDb) {
    GroupData group = new GroupData().withGroupname("addNameforTectGroup").withHeader("addForContact");
    app.goTo().groupPage();
    app.group().create(group);
    app.goTo().gotoContact();
    groupsFromDb.add(group);
    return group.getId();
  }

}
