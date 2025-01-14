/*
 * Copyright 2024 Roland Gisler, HSLU Informatik, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.rv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RoomTest {
  static Room r1;
  
    @BeforeAll
    static void setup() {
    try {
      r1 = new Room(99, 3);
    } 
    catch (Exception e) {
      System.err.println(e);
    }
  }

  @Test
  void testCtor() {
    try {
      Room r = new Room(123, 123);

      assertEquals(r.getRoomNum(), 123);
      assertEquals(r.getCapacity(), 123);
    }
    catch (Exception e) {
      fail();
    }
  }

  @Test
  void testLowerBound() {
    assertThrows(Exception.class,() -> new Room(3, 1));
  }

  @Test
  void testUpperBound() {
    assertThrows(Exception.class,() -> new Room(12345678, 1));
  }
  
  @Test
  void testLowerCapacity() {
    assertThrows(Exception.class,() -> new Room(454, 1));
  }
}
