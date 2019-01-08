package my.summer.addressbook.models;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nick;
  private final String title;
  private final String company;
  private final String home;
  private final String fax;
  private final String Address;
  private String group;
  private int id;



  public ContactData(String firstname, String middlename, String lastname, String nick, String title, String company, String Home, String fax, String Address, String group, int id) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.title = title;
    this.company = company;
    this.home = Home;
    this.fax = fax;
    this.Address = Address;
    this.group = group;
    this.id = id;
  }

  public ContactData(String firstname, String middlename, String lastname, String nick, String title, String company, String Home, String fax, String Address, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.title = title;
    this.company = company;
    this.home = Home;
    this.fax = fax;
    this.Address = Address;
    this.group = group;
    this.id = 0;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNick() {
    return nick;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getHome() {
    return home;
  }

  public String getFax() {
    return fax;
  }

  public String getAddress() {
    return Address;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", id=" + id +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstname, lastname, id);
  }


}
