import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class GameController {
  private Map map;
  private Player player;


  public GameController(String pathname) throws IOException {

    // use jackson package to automatically read the data
    ObjectMapper objectMapper = new ObjectMapper();
    GameData gameData = objectMapper.readValue(new File(pathname), GameData.class);

    // manually read  using jsonnode the Room data and assign ,object such as monster,puzzle,
    // fixure and item to them
    String jsonContent = Files.readString(new File(pathname).toPath());
    JsonNode rootNode = objectMapper.readTree(jsonContent);
    JsonNode roomsNode = rootNode.get("rooms");

    List<Room> roomList = new ArrayList<>();

    for (int i = 0; i < roomsNode.size(); i++) {
      JsonNode roomNode = roomsNode.get(i);
      //get current node

      // add INT and String to Room
      String name = roomNode.get("room_name").asText();
      int number = Integer.parseInt(roomNode.get("room_number").asText());
      String description = roomNode.get("description").asText();
      int N = Integer.parseInt(roomNode.get("N").asText());
      int S = Integer.parseInt(roomNode.get("S").asText());
      int E = Integer.parseInt(roomNode.get("E").asText());
      int W = Integer.parseInt(roomNode.get("W").asText());

      // add puzzle object to ROOM
      Puzzle puzzle = null;
      String puzzleName = roomNode.get("puzzle").asText(null);
      if (puzzleName != null) {
        for (int j = 0; j < gameData.puzzles.size(); j++) {
          Puzzle p = gameData.puzzles.get(j);
          if (p.getName().equalsIgnoreCase(puzzleName)) {
            puzzle = p;
            break;
          }
        }
      }

      // add monster object to the room
      Monster monster = null;
      String monsterName = roomNode.get("monster").asText(null);
      if (monsterName != null) {
        for (int j = 0; j < gameData.monsters.size(); j++) {
          Monster m = gameData.monsters.get(j);
          if (m.getName().equalsIgnoreCase(monsterName)) {
            monster = m;
            break;
          }
        }
      }

      // add a list f item to
      List<Item> roomItems = new ArrayList<>();
      String itemNames = roomNode.get("items").asText(null);
      if (itemNames != null) {
        String[] itemSplit = itemNames.split(",");
        for (int j = 0; j < itemSplit.length; j++) {
          String itemName = itemSplit[j].trim();
          for (int k = 0; k < gameData.items.size(); k++) {
            Item item = gameData.items.get(k);
            if (item.getName().equalsIgnoreCase(itemName)) {
              roomItems.add(item);
              break;
            }
          }
        }
      }

      // add a list of fixure project
      List<Fixture> roomFixtures = new ArrayList<>();
      String fixtureNames = roomNode.get("fixtures").asText(null);
      if (fixtureNames != null) {
        String[] fixtureSplit = fixtureNames.split(",");
        for (int j = 0; j < fixtureSplit.length; j++) {
          String fixtureName = fixtureSplit[j].trim();
          for (int k = 0; k < gameData.fixtures.size(); k++) {
            Fixture fixture = gameData.fixtures.get(k);
            if (fixture.getName().equalsIgnoreCase(fixtureName)) {
              roomFixtures.add(fixture);
              break;
            }
          }
        }
      }

      String picture = roomNode.get("picture").asText();

      //Create new ROOM
      Room room = new Room(name, number, description, N, S, E, W, puzzle, monster, roomItems, roomFixtures, picture);
      roomList.add(room);
    }

    this.map = new Map(roomList);
  }

  public Map getMap() {
    return this.map;
  }


  // view put inside controller

    //move method -- Yijie Li

    // look method and examine --Alexender

    //take and drop item --Amy
    public String takeItem(String itemName) {
      Room currentRoom = player.getCurrentRoom();
      List<Item> roomItems = currentRoom.getItem();

      for (Iterator<Item> it = roomItems.iterator(); it.hasNext();) {
        Item item = it.next();
        if (item.getName().equalsIgnoreCase(itemName)) {
          it.remove();
          player.pickUpItem(item);
          return itemName + " added to your inventory.";
        }
      }
      return "Item '" + itemName + "' not found in this room.";
    }

  public String dropItem(String itemName) {
    List<Item> inventory = player.getInventory();
    for (Iterator<Item> it = inventory.iterator(); it.hasNext();) {
      Item item = it.next();
      if (item.getName().equalsIgnoreCase(itemName)) {
        player.dropItem(item);
        return itemName + " dropped here in " + player.getCurrentRoom();
      }
    }
    return "You don't have item '" + itemName + "' in your inventory.";
  }

    // use item and anwser question to solve monster and puzzle-- David Liu,

    // save and load game -- Chen


    // Dostring- Abdullahi Abdirahman:

    // don't print anything inside player, fixure,room,etc class
    // return a string inside player, etc instead
    // print everything inside view Class

}