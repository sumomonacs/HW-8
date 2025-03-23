import java.util.List;


// a map class that contains a list of room
public class Map {
  private List<Room> rooms;
  private Player player;

  public Map(List<Room> rooms, Player player) {
    this.rooms = rooms;
    this.player = player;
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public Player getPlayer() {
    return player;
  }

  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }
}
