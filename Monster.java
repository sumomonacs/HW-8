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

  /**
   * Attack the player damaging the health of the player
   * @param player current player
   * @return boolean - whether attack successfully
   */
  public boolean attackPlayer(Player player) {
    int playerHealth = player.getHealth();
    // Attack the player and affects the health of the player
    // whether the player's health is out of range < 0
    return player.setHealth(playerHealth - this.damage);
  }

  @Override
  public Integer solve(Item item) {
    if (solution.startsWith("'") && solution.endsWith("'")) {
      // solution is a text, not an item"
      return SOLVE_WRONG_TYPE;
      // if solution is a text instead of a item ,then return
    } else if (solution.equalsIgnoreCase(item.getName())) {
      //check if solution equal to item name,if solution is a item
      this.active = false;
      // "Monster solved using the correct item!";
      return SOLVE_SUCCESS;
    } else {
      // "The item does not match the Monster's solution.";
      return SOLVE_FAIL;
    }
  }


  @Override
  public Integer solve(String magicWord) {
    if (!(solution.startsWith("'") || solution.endsWith("'"))) {
      // return ("solution is a item not a text");
      return SOLVE_WRONG_TYPE;

      // if solution is a item instead of a string
    } else if (solution.equalsIgnoreCase(magicWord)) {
      //check if solution equal to magic word
      this.active = false;
      // "Monster solved using the correct magic word!"
      return SOLVE_SUCCESS;
    } else {
      // "The magicword does not match the Monster's solution."
      return SOLVE_FAIL;
    }
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