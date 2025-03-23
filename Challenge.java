



public class Challenge {
  // Common attributes for Puzzle and Monster
  protected String name;
  protected boolean active;
  protected boolean affects_target;
  protected boolean affects_player;
  protected String solution;
  protected int value;
  protected String description;
  protected String effects;
  protected String target;
  protected String picture;

  // Getters
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

  // Setters
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


  public String solve(Item item){
    if(solution.startsWith("'")&&solution.endsWith("'")){
      return ("solution is a text, not an item");
      // if solution is a text instead of a item ,then return
    }
    else if (solution.equalsIgnoreCase(item.getName())) {

      //check if solution equal to item name,if solution is a item
      this.active = false;
      return ("Puzzle solved using the correct item!");
    }
    else {
      return ("The item does not match the puzzle's solution.");
    }
  }

  public String solve(String magicWord){
    if(!(solution.startsWith("'")&&solution.endsWith("'"))){
      return ("solution is a item not a text");

      // if solution is a item instead of a string
    }
    else if (solution.equalsIgnoreCase(magicWord)) {
      //check if solution equal to magic word
      this.active = false;
      return ("Puzzle solved using the correct magic word!");
    }
    else {
      return ("The magicword does not match the puzzle's solution.");
    }
  }
}