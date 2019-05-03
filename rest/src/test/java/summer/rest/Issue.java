package summer.rest;

import javax.swing.*;
import java.util.Objects;

public class Issue {
  private String subject;
  private String discription;
  private int id;

  public String getSubject() {
    return subject;
  }

  public Issue withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getDiscription() {
    return discription;
  }

  public Issue withtDiscription(String discription) {
    this.discription = discription;
    return this;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Issue issue = (Issue) o;
    return id == issue.id &&
            Objects.equals(subject, issue.subject) &&
            Objects.equals(discription, issue.discription);
  }

  @Override
  public int hashCode() {

    return Objects.hash(subject, discription, id);
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }
}
