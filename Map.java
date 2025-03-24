import java.util.List;


// a map class that contains a list of room
public class Map {
  private List<Room> rooms;


  public Map(List<Room> rooms) {
    this.rooms = rooms;
  }
  public List<Room> getRooms() {
    return rooms;
  }
  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

}
