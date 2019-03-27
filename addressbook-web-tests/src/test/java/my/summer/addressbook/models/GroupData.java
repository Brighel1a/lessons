package my.summer.addressbook.models;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class GroupData {
  @Expose
  private  String groupname = "";
  @Expose
  private  String header = "";
  @Expose
  private  String footer = "";
  @XStreamOmitField
  private int id = 0;

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }


  public GroupData withGroupname(String groupname) {
    this.groupname = groupname;
    return this;

  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
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

  @Override
  public String toString() {
    return "GroupData{" +
            "groupname='" + groupname + '\'' +
            ", id=" + id +
            '}';
  }

}
