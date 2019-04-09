package my.summer.addressbook.models;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="addressbook")
@XStreamAlias("contact")
public class ContactData {
  @Expose
  @Column(name="firstname")
  private  String firstname;
  private  String middlename;
  @Expose
  @Column(name="lastname")
  private  String lastname;
  @Transient
  private  String nick;
  @Transient
  private  String title;
  @Transient
  private  String company;
  @Transient
  private  String fax;
  @Transient
  private  String address;
  @Column(name="home")
  @Type(type = "text")
  private  String phoneHome;
  @Column(name="mobile")
  @Type(type = "text")
  private  String phoneMobile;
  @Expose
  @Column(name="work")
  @Type(type = "text")
  private  String phoneWork;
  @XStreamOmitField
  @Id
  @Column(name="id")
  private int id = 0;
  @Transient
  private  String allPhones;
  @Transient
  private  String emailFrst;
  @Transient
  private  String emailScnd;
  @Transient
  private  String emailThrd;
  @Transient
  private  String allEmail;
  @Transient
  private  String allInfo;
  @Column(name="photo")
  @Type(type = "text")
  private String photo;
  @ManyToMany
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name ="id"),
          inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();


  public String firstname() {
    return firstname;
  }

  public String middlename() {
    return middlename;
  }

  public String lastname() {
    return lastname;
  }

  public String nick() {
    return nick;
  }

  public String title() {
    return title;
  }

  public String company() {
    return company;
  }

  public String fax() {
    return fax;
  }

  public String address() {
    return address;
  }

  public String emailFrst() {
    return emailFrst;
  }

  public String emailScnd() {
    return emailScnd;
  }

  public String emailThrd() {
    return emailThrd;
  }

  public int getId() {
    return id;
  }

  public String phoneHome() {
    return phoneHome;
  }

  public String phoneMobile() {
    return phoneMobile;
  }

  public String phoneWork() {
    return phoneWork;
  }


  public String allPhones() {
    return allPhones;
  }


  public String allInfo() {
    return allInfo;
  }

  public File photo() {
    if(photo!=null){
      return new File(photo);
    }
    return null;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }


  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNick(String nick) {
    this.nick = nick;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }


  public ContactData withEmailFrst(String emailFrst) {
    this.emailFrst = emailFrst;
    return this;
  }

  public ContactData withEmailScnd(String emailScnd) {
    this.emailScnd = emailScnd;
    return this;
  }

  public ContactData withEmailThrd(String emailThrd) {
    this.emailThrd = emailThrd;
    return this;
  }

  public ContactData withAllEmail(String allEmail) {
    this.allEmail = allEmail;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;

    return this;
  }

  public String allEmail() {
    return allEmail;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withPhoneHome(String phoneHome) {
    this.phoneHome = phoneHome;
    return this;
  }

  public ContactData withPhoneMobile(String phoneMobile) {
    this.phoneMobile = phoneMobile;
    return this;
  }

  public ContactData withPhoneWork(String phoneWork) {
    this.phoneWork = phoneWork;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllInfo(String allInfo) {
    this.allInfo = allInfo;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
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


  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}
