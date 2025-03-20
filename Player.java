/**
 * The class represents the Player Class.
 */
public class Player {
  public String name; // no exits in Player class in UML - need discussion
  public Integer score;
  public Integer health;
  public Integer capacity;
  public Room currentRoom;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
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


}
