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


  private void pickUpItem(Item pickedItem) {
    int sum = 0;

    // sum the weight of all items in the inventory
    for (int i = 0; i < inventory.size(); i++) {
      sum += inventory.get(i).getWeight();
    }

    // add the weight of the picked item
    sum += pickedItem.getWeight();

    // check if adding the new item exceeds the capacity
    if (sum > capacity) {
      System.out.println("Weight exceeds capacity");
      return;
      // exit the method if capacity is exceeded
    } else {
      inventory.add(pickedItem);
      System.out.println("Item added successfully");
    }
  }

  private void dropItem(Item droppedItem) {
    // Check if the inventory contains the dropped item
    if (inventory.contains(droppedItem)) {

      // add item to Room
      this.currentRoom.getItem().add(droppedItem);
      // Remove the item from the inventory
      inventory.remove(droppedItem);

      System.out.println("Item dropped successfully");
    } else {
      System.out.println("Item not found in inventory");
    }
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getScore() {
    return score;
  }

  private void setScore(Integer score) {
    this.score = score;
  }

  public Integer getHealth() {
    return health;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }



  public void solvePuzzle(Item item, Puzzle puzzle) {
    if (puzzle == null ||puzzle == null) {
      return;
    }
    if(item.getUses_remaining()>1){
      puzzle.solve(item);
      if (!puzzle.isActive()) {
        this.score += puzzle.getValue();
        item.setUses_remaining(item.getUses_remaining()-1);
        //set use_remaining -=1
        if(item.getUses_remaining()< 1){
          currentRoom.getItem().remove(item);
          // if getUsesRemaining <1)
          // remove item
        }
      }
    }
  }

  public void solvePuzzle(String magicWords, Puzzle puzzle) {
    if (puzzle == null || magicWords == null || magicWords.equals("")) {
      return;
    }
    puzzle.solve(magicWords);
    if (!puzzle.isActive()) {
      this.score += puzzle.getValue();
    }
  }


  public void solveMonster(Item item, Monster monster) {
    if (monster == null || item == null) {
      return;
    }
    if (item.getUses_remaining() > 1) {
      monster.solve(item);
      if (!monster.isActive()) {
        this.score += monster.getValue();
        item.setUses_remaining(item.getUses_remaining() - 1);
        // set use_remaining -=1
        if (item.getUses_remaining() < 1) {
          currentRoom.getItem().remove(item);
          // if getUsesRemaining < 1, remove item
        }
      }
    }
  }

  public void solveMonster(String magicWords, Monster monster) {
    if (monster == null || magicWords == null || magicWords.equals("")) {
      return;
    }
    monster.solve(magicWords);
    if (!monster.isActive()) {
      this.score += monster.getValue();
    }
  }



}