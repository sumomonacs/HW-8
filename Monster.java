import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Monster {
  public String name;
  public boolean active;
  public boolean affects_target;
  public boolean affects_player;
  public String solution;
  public int value;
  public String description;
  public String effects;
  public int damage;
  public String target;
  public boolean can_attack;
  public String attack;
  public String picture;

  @Override
  public String toString() {
    return "Monster{" +
            "name='" + name + '\'' +
            ", active=" + active +
            ", affects_target=" + affects_target +
            ", affects_player=" + affects_player +
            ", solution='" + solution + '\'' +
            ", value=" + value +
            ", description='" + description + '\'' +
            ", effects='" + effects + '\'' +
            ", damage=" + damage +
            ", target='" + target + '\'' +
            ", can_attack=" + can_attack +
            ", attack='" + attack + '\'' +
            ", picture='" + picture + '\'' +
            '}';
  }
}
