import java.util.List;

/**
 * The class represents the Player Class.
 */
public class Player {
  private String name; // no exits in Player class in UML - need discussion
  private Integer score;
  private Integer health;
  private List<Item> inventory;
  private Integer capacity;
  private Room currentRoom;

  /**
   * Pick up the item.
   * @param pickedItem item
   * @return return a int -1 means capacity exceed limit,0 succeed
   */
  public boolean pickUpItem(Item pickedItem) {
    int sum = 0;

    // sum the weight of all items in the inventory
    for (int i = 0; i < inventory.size(); i++) {
      sum += inventory.get(i).getWeight();
    }

    // add the weight of the picked item
    sum += pickedItem.getWeight();

    // check if adding the new item exceeds the capacity
    if (sum > capacity) {
      // exit the method if capacity is exceeded
      return false;
    } else {
      inventory.add(pickedItem);
      return true;
    }
  }

  /**
   * Drop item to the room.
   * @param droppedItem drop item
   *@return return true means success ,false othersie
   */
  public boolean dropItem(Item droppedItem) {
    // Check if the inventory contains the dropped item
    if (inventory.contains(droppedItem)) {

      // add item to Room
      this.currentRoom.getItem().add(droppedItem);
      // Remove the item from the inventory
      inventory.remove(droppedItem);

      return true;
    } else {
      return false;
    }
  }

  /**
   * Getter function - get the name of the player.
   * @return name of the player
   */
  public String getName() {
    return name;
  }

  /**
   * Setter function - set the name of the player.
   * @param name name of the player
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter function - get the score of the player.
   * @return the score of the function
   */
  public Integer getScore() {
    return score;
  }

  /**
   * Setter function - set the score of the player
   * @param score score of the player
   */
  private void setScore(Integer score) {
    this.score = score;
  }

  /**
   * Getter function - get the health status of the player
   * @return the health of the player
   */
  public Integer getHealth() {
    return health;
  }

  /**
   * Set the health of the player.
   * @param health health should range from 0 to 100
   * @return boolean - status of the setting
   */
  public boolean setHealth(Integer health) {
    if (health >= 0 && health <= 100) {
      this.health = health;
      return true;
    } else {
      // If health of the player is out of range it's false
      return false;
    }
  }

  /**
   * Getter function - get the capacity
   * @return the items that the player can pick
   */
  public Integer getCapacity() {
    return capacity;
  }

  /**
   * Getter function - get the room player located
   * @return the room player currently at
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }

  /**
   * Getter function - get the inventory of the player.
   * @return the inventory of the player
   */
  public List<Item> getInventory() { return inventory;}

  /**
   * Solve the puzzle with item
   * @param item item tha player uses
   * @param puzzle puzzle that player facing
   * @return common status code
   */
  public Integer solvePuzzle(Item item, Puzzle puzzle) {
    if (puzzle == null || item == null) {
      return Challenge.SOLVE_ERROR;
    }

    if (item.getUses_remaining() < 1) {
      return Challenge.SOLVE_FAIL;
    }

    Integer result = puzzle.solve(item);

    if (result == Challenge.SOLVE_SUCCESS && !puzzle.isActive()) {
      this.score += puzzle.getValue();
      item.setUses_remaining(item.getUses_remaining() - 1);

      this.currentRoom.setRoomToPassable();

      if (item.getUses_remaining() < 1) {
        currentRoom.getItem().remove(item);
      }
    }

    return result;
  }

  /**
   * Solve the puzzle with item
   * @param magicWords magic words that player input
   * @param puzzle puzzle that player facing
   * @return common status code
   */
  public Integer solvePuzzle(String magicWords, Puzzle puzzle) {
    if (puzzle == null || magicWords == null || magicWords.equals("")) {
      // "not a vaild puzzle or magic words"
      return Challenge.SOLVE_ERROR;
    }

    Integer result = puzzle.solve(magicWords);

    if (result == Challenge.SOLVE_SUCCESS && !puzzle.isActive()) {
      this.score += puzzle.getValue();
      // set room to passable for all direction
      // once the puzzle or monster being solved
      this.currentRoom.setRoomToPassable();
    }

    return result;
  }

  /**
   * Fight with the monster using item.
   * @param item used to fight the monster
   * @param monster monster player facing right now
   * @return integer code shows that whether it works for the monster
   */
  public Integer solveMonster(Item item, Monster monster) {
    if (monster == null || item == null) {
      // return("not a vaild puzzle or item"
      return Challenge.SOLVE_ERROR;
    }

    int result = monster.solve(item);

    if (result == Challenge.SOLVE_SUCCESS && !monster.isActive()) {
      this.score += monster.getValue();
      item.setUses_remaining(item.getUses_remaining() - 1);
      // set room to passable for all direction
      // once the puzzle or monster being solved
      this.currentRoom.setRoomToPassable();

      // if getUsesRemaining <1, remove item
      if (item.getUses_remaining() < 1) {
        currentRoom.getItem().remove(item);
      }
    }

    return result;
  }

  /**
   * Fight with the monster using magic words.
   * @param magicWords used to fight the monster
   * @param monster monster player facing right now
   * @return integer code shows that whether it works for the monster
   */
  public Integer solveMonster(String magicWords, Monster monster) {
    if (monster == null || magicWords == null || magicWords.equals("")) {
      // "not a vaild puzzle or magic words"
      return Challenge.SOLVE_ERROR;
    }

    int result = monster.solve(magicWords);

    if (result == Challenge.SOLVE_SUCCESS && !monster.isActive()) {
      this.score += monster.getValue();
      // set room to passable for all direction
      // once the puzzle or monster being solved
      this.currentRoom.setRoomToPassable();
    }

    return result;
  }

  /**
   * Move method.
   * @param Direction direction player wants to move
   * @param map map
   * @return integer status code shows that whether the move is accepted
   *         1 : move successfully
   *         0: direction permanently blocked
   *        -1: blocked by puzzle or monster
   *        -2: invalid direction input
   */
  public Integer move(String Direction, Map map) {
    if (!(Direction.equals("N") || Direction.equals("E") || Direction.equals("S") || Direction.equals("W"))) {
      // "Input must be N, E, S, or W";
      return -2;
    }

    int nextRoomNumber = -1;

    // using switch case to try to catach direction
    switch (Direction) {
      case "N":
        nextRoomNumber = this.currentRoom.getN();
        // blockedMessage = "North is being permantly blocked ";
        break;
      case "E":
        nextRoomNumber = this.currentRoom.getE();
        // blockedMessage = "East is being permantly blocked ";
        break;
      case "S":
        nextRoomNumber = this.currentRoom.getS();
        // blockedMessage = "South is being permantly blocked ";
        break;
      case "W":
        nextRoomNumber = this.currentRoom.getW();
        // blockedMessage = "West is being permantly blocked ";
        break;
    }

    // check
    if (nextRoomNumber > 0) {
      // if nextRoom number is greater than >. it is a vaild way
      for (int i = 0; i < map.getRooms().size(); i++) {
        Room room = map.getRooms().get(i);
        if (nextRoomNumber == room.getRoom_number()) {
          this.currentRoom = room;
          //"move successfully"
          return 1; 
          // if map do have this room , then player move to this Room
        }
      }
      // Room number valid, but no room matched (unexpected error)
      return -1;
    } else if (nextRoomNumber == 0) {
      // if nextRoomNumber ==0, it is permantly blocked
      return 0;
    } else {
      // if it is negative, then there is puzzle or monster currently blocking the access
      return -1;
    }
  }
}