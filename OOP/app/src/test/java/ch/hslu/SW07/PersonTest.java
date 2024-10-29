package ch.hslu.SW07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import nl.jqno.equalsverifier.*;
import org.junit.jupiter.api.Test;

public class PersonTest {
  Person person1;
  Person person2;
  Person person3;

  @BeforeEach
  void setup() {
    this.person1 = new Person(1, "Timo", "Schlumpf");
    this.person2 = new Person(2, "Kevin", "Cattin");
    this.person3 = new Person(2, "Joachim", "Steiger");
  }

  @Test
  void testCtor() {
    assertEquals(this.person1.toString(), "1: Timo Schlumpf");
  }

  @Test
  void equalsContract() {
    EqualsVerifier.forClass(Person.class).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
  }

  @Test
  void hashTest() {
    assertEquals(person2.hashCode(), person3.hashCode());
  }

  @Test
  void equalsTest() {
    assertEquals(person2, person2);
  }

  @Test
  void notEqualsTest() {
    assertNotEquals(person1, person2);
  }
}
