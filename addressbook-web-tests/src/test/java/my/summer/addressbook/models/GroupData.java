package my.summer.addressbook.models;

public class GroupData {
  private final String groupname;
  private final String header;
  private final String footer;

  public GroupData(String name, String header, String footer) {
    this.groupname = name;
    this.header = header;
    this.footer = footer;
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
}
