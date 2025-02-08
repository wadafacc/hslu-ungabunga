package ch.hslu.oop.mep24hs;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GueterzugTest {
  @Test
  @Disabled
  void testLengthCount() {
    Gueterzug z = new Gueterzug(new BR186(00001, 0));
    z.addWagon(new Shimms(0001, 342));


  }
}
