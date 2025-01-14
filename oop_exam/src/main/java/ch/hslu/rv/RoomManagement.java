package ch.hslu.rv;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class RoomManagement {
  private ArrayList<Room> rooms;
  PropertyChangeSupport pcs;

  public RoomManagement() {
    this.rooms = new ArrayList<Room>();
    pcs = new PropertyChangeSupport(this);
  }

  public void addToList(Room r) {
    this.rooms.add(r);
    this.rooms.sort(new RoomComparator());  
  }

  public void bookRoom(Room r) {
    // DO STUFF
    this.fireChangeEvent(String.valueOf(r.getRoomNum()), r, r);
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Listener darf nicht null sein.");
    }
    pcs.addPropertyChangeListener(listener);
  }

  public void fireChangeEvent(String propertyName, Object oldValue, Object newValue) {
    pcs.firePropertyChange(propertyName, oldValue, newValue);
  }

  /*
   * Implementieren Sie auf der Klasse RaumVerwaltung eine Methode, über welche
   * für eine
   * bestimmte Anzahl Personen automatisch ein passender Raum ausgewählt und
   * reserviert wird. Als
   * Rückgabetyp verwenden Sie die Klasse Raum. In einem ersten Schritt darf (zur
   * Vereinfachung!)
   * der erste genügend grosse (und natürlich freie) Raum gewählt werden.
   */
  public Room getFreeRoom(int peopleCount) {
    Room smallestPossible = null;
    for (Room room : this.rooms) {
      if (room.isFree() && room.getCapacity() >= peopleCount) {
        if (smallestPossible != null && room.getCapacity() < smallestPossible.getCapacity()) {
          smallestPossible = room;
        }
      }
    }

    return smallestPossible;
  }
}
