import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameData {
    public String name;
    public String version;
    public List<Item> items;
    public List<Monster> monsters;
    public List<Puzzle> puzzles;

}
