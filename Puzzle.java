
/**
 * The Puzzle class extends Challenge, whereby all common attributes
 * and methods are inherited. It represents the game's puzzle logic.
 */
public class Puzzle extends Challenge {


  /**
   * If the puzzle is solved using an item instead of a text
   * input:
   */
  @Override
  public String solve(Item item) {
    if (solution.startsWith("'") && solution.endsWith("'")) {
      return ("solution is a text, not an item");
      // if solution is a text instead of a item ,then return
    } else if (solution.equalsIgnoreCase(item.getName())) {

      //check if solution equal to item name,if solution is a item
      this.active = false;
      return ("Puzzle solved using the correct item!");
    } else {
      return ("The item does not match the puzzle's solution.");
    }
  }

  /**
   * If the puzzle is solved using a single magic word (text input)
   * instead of an item s:
   */
  @Override
  public String solve(String magicWord) {
    if (!(solution.startsWith("'") || solution.endsWith("'"))) {
      return ("solution is a item not a text");

      // if solution is a item instead of a string
    } else if (solution.equalsIgnoreCase(magicWord)) {
      //check if solution equal to magic word
      this.active = false;
      return ("Puzzle solved using the correct magic word!");
    } else {
      return ("The magicword does not match the puzzle's solution.");
    }
  }
}