import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
// game data package everything except
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameData {
    public String name;
    public String version;
    public List<Item> items;
    public List<Monster> monsters;
    public List<Puzzle> puzzles;
    public List<Fixture> fixtures;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public List<Puzzle> getPuzzles() {
        return puzzles;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public void setPuzzles(List<Puzzle> puzzles) {
        this.puzzles = puzzles;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }
}
