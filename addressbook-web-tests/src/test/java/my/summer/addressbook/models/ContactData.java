package my.summer.addressbook.models;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nick;
  private final String title;
  private final String company;
  private final String home;
  private final String fax;

  public ContactData(String firstname, String middlename, String lastname, String nick, String title, String company, String Home, String fax) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.title = title;
    this.company = company;
    home = Home;
    this.fax = fax;
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
}
