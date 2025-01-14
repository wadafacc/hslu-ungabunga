package ch.hslu.rv;

import java.util.ArrayList;

public class RoomManagement {
  private ArrayList<Room> rooms;

  public RoomManagement() {
    this.rooms = new ArrayList<Room>();
  }

  public void addToList(Room r) {
    this.rooms.add(r);
  }
}
