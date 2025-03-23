import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Monster extends Challenge {
  // Additional attributes unique to Monster
  private int damage;
  private boolean can_attack;
  private String attack;

  // Getter and setter for damage
  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  // Getter and setter for can_attack
  public boolean isCan_attack() {
    return can_attack;
  }

  public void setCan_attack(boolean can_attack) {
    this.can_attack = can_attack;
  }

  // Getter and setter for attack
  public String getAttack() {
    return attack;
  }

  public void setAttack(String attack) {
    this.attack = attack;
  }

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