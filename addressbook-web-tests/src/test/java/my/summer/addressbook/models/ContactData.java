package my.summer.addressbook.models;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;
@XStreamAlias("contact")
public class ContactData {
  @Expose
  private  String firstname;
  private  String middlename;
  @Expose
  private  String lastname;
  private  String nick;
  private  String title;
  private  String company;
  private  String fax;
  private  String address;
  private  String group;
  private  String phoneHome;
  private  String phoneMobile;
  @Expose
  private  String phoneWork;
  @XStreamOmitField
  private int id = 0;
  private  String allPhones;
  private  String emailFrst;
  private  String emailScnd;
  private  String emailThrd;
  private  String allEmail;
  private  String allInfo;
  private File photo;



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

  public String group() {
    return group;
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
    return photo;
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

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAllInfo(String allInfo) {
    this.allInfo = allInfo;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
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



}
