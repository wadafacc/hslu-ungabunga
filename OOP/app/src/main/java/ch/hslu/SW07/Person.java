package ch.hslu.SW07;

import java.util.Objects;

public class Person implements Comparable<Person>{
  private final long id;
  private String lastname;
  private String firstname;

  /**
   * Creates a Person Object. 
   * @param id
   * @param vn (Vorname)
   * @param nn (lastname)
   */
  public Person(long id, String vn, String nn) {
    this.id = id;
    this.firstname = vn;
    this.lastname = nn;
  }
 
  public long getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstname;
  }

  public String getLastName() {
    return this.lastname;
  }


  public void setFirstName(String n) {
    this.firstname = n;
  } 
  public void setLastName(String n) {
    this.lastname = n;
  }

  @Override
  public final boolean equals(Object obj) {
    if (this == obj) return true;
    return obj instanceof Person other && id == other.id;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return String.format("%s: %s %s", this.id, this.firstname, this.lastname);
  }

  @Override
  public int compareTo(Person o) {
    return Long.compare(this.id, o.id);
  }
}
