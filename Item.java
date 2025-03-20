public class Item {
  public String name;
  public int weight;
  public int max_uses;
  public int uses_remaining;
  public int value;
  public String when_used;
  public String description;
  public String picture;


  public Item() {
    this.name = name;
    this.weight = weight;
    this.max_uses = max_uses;
    this.uses_remaining = uses_remaining;
    this.value = value;
    this.when_used = when_used;
    this.description = description;
    this.picture = picture;
  }


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