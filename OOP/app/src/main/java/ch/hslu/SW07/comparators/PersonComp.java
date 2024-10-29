package ch.hslu.SW07.comparators;

import java.util.Comparator;

import ch.hslu.SW07.Person;

public class PersonComp implements Comparator<Person>{

  @Override
  public int compare(Person o1, Person o2) {
    int compare = o1.getLastName().compareTo(o2.getLastName());

    if (compare != 0) {
      return compare;
    }

    return o1.getFirstName().compareTo(o2.getFirstName());
  }
}
