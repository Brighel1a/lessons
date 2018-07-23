package my.summer.addressbook.appmanager;

import my.summer.addressbook.models.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupHelper extends HelperBase{

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type("group_name", groupData.getGroupname());
    type("group_header", groupData.getHeader());
    type("group_footer", groupData.getFooter());
  }

  public void initGroupCreator() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void SelectGroup() {
    click(By.name("selected[]"));
  }
}
