public class Challenge {

  // Common attributes for Puzzle and Monster.
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

  // Getter methods.
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

  // Setter methods.
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
}
