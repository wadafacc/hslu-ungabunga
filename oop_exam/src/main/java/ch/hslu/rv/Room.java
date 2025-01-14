package ch.hslu.rv;

public final class Room implements Comparable<Room> {
  private final int roomNumber;
  private final int capacity;
  private Status state; 

  public Room(final int roomNumber, final int capacity) throws Exception {
    if (roomNumber < 99 || roomNumber > 999) {
      throw new Exception("EEE");
    }
    if (capacity < 2) {
      throw new Exception("EEE");
    }

    this.roomNumber = roomNumber;
    this.capacity = capacity;
    this.state = Status.FREE;
  }

  public int getRoomNum() {
    return this.roomNumber;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public Status getRoomState() {
    return this.state;
  }

  @Override
  public int hashCode() {
    return this.roomNumber;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (this == other) return true;

    return this.hashCode() == other.hashCode();
  }

  @Override
  public int compareTo(Room o) {
    return Integer.compare(this.roomNumber, o.roomNumber);
  }
}
