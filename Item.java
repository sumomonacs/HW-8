/**
 * Represents an item in the game.
 *
 * Attributes:
 * name: name of the item.
 * weight: How much the item weighs. A player's avatar can carry a MAXIMUM of 13 weight unit* worth of items
 * max_uses: how many times the item can be used, if it was "full".
 * uses_remaining: how many uses are currently left for the item.
 * value: how much the item is worth
 * when_used: the text presented to the player when they successfully use the item in context.
 * description: A brief description of the item.
 * picture:  a picture representing the item (not relevant for HW8; might be used for the graphical version in HW9)
 */
public class Item {
  private String name;
  private int weight;
  private int max_uses;
  private int uses_remaining;
  private int value;
  private String when_used;
  private String description;
  private String picture;

  /**
   * Default constructor.
   *
   * Initializes default values:
   * name: "Unknown Item"
   * weight: 1
   * max_uses: 1
   * uses_remaining: 1
   * value: 0
   * when_used: an empty string
   * description: "No description provided."
   * picture: an empty string
   */
  public Item() {
    this.name = "Unknown Item";
    this.weight = 1;
    this.max_uses = 1;
    this.uses_remaining = 1;
    this.value = 0;
    this.when_used = "";
    this.description = "No description provided.";
    this.picture = "";
  }

  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }

  public int getMax_uses() {
    return max_uses;
  }

  public int getUses_remaining() {
    return uses_remaining;
  }

  public int getValue() {
    return value;
  }

  public String getWhen_used() {
    return when_used;
  }

  public String getDescription() {
    return description;
  }

  public String getPicture() {
    return picture;
  }

  // setter method


  public void setName(String name) {
    this.name = name;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setMax_uses(int max_uses) {
    this.max_uses = max_uses;
  }

  public void setUses_remaining(int uses_remaining) {
    this.uses_remaining = uses_remaining;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setWhen_used(String when_used) {
    this.when_used = when_used;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  /**
   * Returns a string representation of the Item.
   * @return A formatted string that shows the item attributes.
   */
  @Override
  public String toString() {
    return "Item{" +
            "name='" + name + '\'' +
            ", weight=" + weight +
            ", max_uses=" + max_uses +
            ", uses_remaining=" + uses_remaining +
            ", value=" + value +
            ", when_used='" + when_used + '\'' +
            ", description='" + description + '\'' +
            ", picture='" + picture + '\'' +
            '}';
  }
}