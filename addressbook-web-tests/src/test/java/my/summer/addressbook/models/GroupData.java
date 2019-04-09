package my.summer.addressbook.models;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name="group_list")
public class GroupData {
  @Expose
  @Column(name="group_name")
  private  String groupname = "";
  @Expose
  @Column(name="group_header")
  @Type(type = "text")
  private  String header = "";
  @Expose
  @Column(name="group_footer")
  @Type(type = "text")
  private  String footer = "";

  public Contacts getContacts() {
    return new Contacts(contacts);
  }

  @ManyToMany(mappedBy = "groups")
  private Set<ContactData> contacts = new HashSet<ContactData>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(groupname, groupData.groupname) &&
            Objects.equals(header, groupData.header) &&
            Objects.equals(footer, groupData.footer);
  }

  @Override
  public int hashCode() {

    return Objects.hash(groupname, header, footer, id);
  }

  @XStreamOmitField
  @Id
  @Column(name="group_id")
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
  public String toString() {
    return "GroupData{" +
            "groupname='" + groupname + '\'' +
            ", id=" + id +
            '}';
  }

}
