package my.summer.addressbook.models;

import java.util.Objects;

public class GroupData {
  private final String groupname;
  private final String header;
  private final String footer;

  public void setId(int id) {
    this.id = id;
  }

  private int id;

  public GroupData(String name, String header, String footer) {
    this.groupname = name;
    this.header = header;
    this.footer = footer;
    this.id = 0;
  }

  public GroupData(int id, String name, String header, String footer) {
    this.groupname = name;
    this.header = header;
    this.footer = footer;

    this.id = 0;
  }

  public String getGroupname() {
    return groupname;
  }

  public String getHeader() {
    return header;
  }


  public String getFooter() {
    return footer;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "groupname='" + groupname + '\'' +
            ", id=" + id +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(groupname, groupData.groupname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(groupname, id);
  }
}
