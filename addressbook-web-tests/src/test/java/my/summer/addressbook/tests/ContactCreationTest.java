package my.summer.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import my.summer.addressbook.models.ContactData;
import my.summer.addressbook.models.Contacts;
import my.summer.addressbook.models.GroupData;
import my.summer.addressbook.models.Groups;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


  @DataProvider
  Iterator<Object[]> validContactsFromXml() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.xml")))) {
      String line = reader.readLine();
      String xml = "";
      while (line != null) {
        xml += line;
//      for csv
//      String[] split = line.split(";");
//      list.add(new Object[] {new ContactData().withFirstname(split[0]).withLastname(split[1]).withPhoneWork(split[2])});
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  Iterator<Object[]> validContactsFromJson() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.json")))) {
      String line = reader.readLine();
      String json = "";
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());  //List<ContactData>.class
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().gotoContact();
  }

  @Test (enabled=true, dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData newContact) {
    Groups groups = app.db().groups();
    if (groups.size()==0){
      createGroup(groups);
    }
    Contacts before = app.db().contacts();
    app.contact().create(newContact.inGroup(groups.iterator().next()));
    File photo = new File("src/test/resources/picture.png");
    assertThat(app.contact().count(), equalTo(before.size() + 1));
     Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.withAdded(
              newContact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    verifyGroupListInUI();
  }


  @Test (enabled = false)
  public void testCurrentDir() {
   File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/picture.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

  private void createGroup(Groups groups) {
    GroupData group = new GroupData().withGroupname("addNameforTectGroup").withHeader("addForContact");
    app.goTo().groupPage();
    app.group().create(group);
    app.goTo().gotoContact();
    groups.add(group);
  }

}