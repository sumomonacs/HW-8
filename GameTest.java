import java.util.List;

public class GameTest {
  public static void main(String[] args) {
    try {
      String path = "D:\\document-new semster\\CS-5004\\hw8\\align_quest_game_elements.json";
      GameController controller = new GameController(path);

      Map map = controller.getMap();
      List<Room> rooms = map.getRooms();

      for (int i = 0; i < rooms.size(); i++) {
        Room room = rooms.get(i);
        System.out.println("Room #" + room.getRoom_number() + ": " + room.getRoom_name());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}