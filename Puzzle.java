


public class Puzzle {
  private String name;
  private boolean active;
  private  boolean affects_target;
  private  boolean affects_player;
  private  String solution;
  private  int value;
  private  String description;
  private  String effects;
  private  String target;
  private  String picture;

  public String getName() {
    return name;
  }

  public boolean isActive() {
    return active;
  }

  public boolean isAffects_target() {
    return affects_target;
  }

  public boolean isAffects_player() {
    return affects_player;
  }

  public String getSolution() {
    return solution;
  }

  public int getValue() {
    return value;
  }

  public String getDescription() {
    return description;
  }

  public String getEffects() {
    return effects;
  }

  public String getTarget() {
    return target;
  }

  public String getPicture() {
    return picture;
  }

  // setter


  public void setName(String name) {
    this.name = name;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setAffects_target(boolean affects_target) {
    this.affects_target = affects_target;
  }

  public void setAffects_player(boolean affects_player) {
    this.affects_player = affects_player;
  }

  public void setSolution(String solution) {
    this.solution = solution;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setEffects(String effects) {
    this.effects = effects;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }


  public void solve(Item item){
    if(solution.startsWith("'")&&solution.endsWith("'")){
      System.out.println("solution is a text, not an item");
      return;
      // if solution is a text instead of a item ,then return
    }
    else if (solution.equalsIgnoreCase(item.getName())) {
      System.out.println("Puzzle solved using the correct item!");
      //check if solution equal to item name,if solution is a item
      this.active = false;
    }
    else {
      System.out.println("The item does not match the puzzle's solution.");
    }
  }

  public void solve(String magicWord){
    if(!(solution.startsWith("'")&&solution.endsWith("'"))){
      System.out.println("solution is a item not a text");
      return;
      // if solution is a item instead of a string
    }
    else if (solution.equalsIgnoreCase(magicWord)) {
      System.out.println("Puzzle solved using the correct magic word!");
      //check if solution equal to magic word
      this.active = false;
    }
    else {
      System.out.println("The magicword does not match the puzzle's solution.");
    }
  }

}