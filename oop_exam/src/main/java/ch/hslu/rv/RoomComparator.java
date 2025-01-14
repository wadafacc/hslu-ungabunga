package ch.hslu.rv;

import java.util.Comparator;

public class RoomComparator implements Comparator<Room> {
  @Override
  public int compare(Room r1, Room r2) {
    return r1.getRoomNum() - r2.getRoomNum();
  }
}
