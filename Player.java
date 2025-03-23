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


  private void pickUpItem() {

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

  public void solve(Item item, Puzzle puzzle) {

  }

  public void solve(String magicWords, Puzzle puzzle) {
    if (puzzle == null || magicWords == null || magicWords.equals("")) {
      return;
    }
    puzzle.solve(magicWords);
    if (puzzle.getIsSolved()) {
      this.score += puzzle.getValue();
    }
  }


}
