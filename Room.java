import java.util.List;

public class Room {
    private String room_name; // room name
    private int room_number; // number
    private String description;
    private int N; // north
    private int S;//south
    private int E; //east
    private int W; //west
    private List<Puzzle> puzzles;
    private List<Monster> monsters;
    private List<Item> item;
    private List<Fixture> fixures;
    private String picture;

    public Room(String room_name, int room_number, String description, int n, int s, int e, int w, List<Puzzle> puzzles, List<Monster> monsters, List<Item> item, List<Fixture> fixures, String picture) {
        this.room_name = room_name;
        this.room_number = room_number;
        this.description = description;
        N = n;
        S = s;
        E = e;
        W = w;
        this.puzzles = puzzles;
        this.monsters = monsters;
        this.item = item;
        this.fixures = fixures;
        this.picture = picture;
    }
    // getter method

    public String getRoom_name() {
        return room_name;
    }

    public int getRoom_number() {
        return room_number;
    }


    /**
     * Returns the description of the room.
     * This method first checks the list of puzzles in the room. For each puzzle,
     * if it is active,
     * affects its target, and has a valid target  that matches
     * current room number and name
     *  then the puzzle's effects description is returned.
     * If no matching puzzle is found, the method then checks the list of monsters
     * in a similar manner.
     * For each monster, if it is active, affects its target, and has a valid target
     * string in the format
     * and have a target that match current room number and name
     * return monster's effect decription
     * If neither an active puzzle nor n active monster that affects the room is found,
     * the original room description is returned.
     * @return effect from an active puzzle or monster or the original room description.
     */
    public String getDescription() {
        for (int i = 0; i < puzzles.size(); i++) {
            Puzzle puzzle = puzzles.get(i);
            // Check that the puzzle is active, affects the target, and has a valid target string.
            if (puzzle.isActive() && puzzle.isAffects_target() && puzzle.getTarget() != null) {
                String[] targetParts = puzzle.getTarget().split(":");
                if (targetParts.length == 2) {
                    // Remove any extra whitespace
                    String targetRoomNumber = targetParts[0].trim();
                    String targetRoomName = targetParts[1].trim();
                    if (targetRoomNumber.equals(this.room_number) && targetRoomName.equalsIgnoreCase(this.room_name)) {
                        return puzzle.getEffects();
                        // if the puzzle  is active and affect this room ,then return a puzzle's effect
                        // instead of returning the original description
                    }
                }
            }
        }
        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
            // Check that the monster is active, affects the target, and has a valid target string.
            if (monster.isActive() && monster.isAffects_target() && monster.getTarget() != null) {
                String[] targetParts = monster.getTarget().split(":");
                if (targetParts.length == 2) {
                    // Remove any extra whitespace
                    String targetRoomNumber = targetParts[0].trim();
                    String targetRoomName = targetParts[1].trim();
                    if (targetRoomNumber.equals(this.room_number) && targetRoomName.equalsIgnoreCase(this.room_name)) {
                        return monster.getEffects();
                        // if the monster  is active and affect this room, then return a monster's effect
                        // instead of returning the original description
                    }
                }
            }
        }
        return description;
    }

    public int getN() {
        return N;
    }

    public int getS() {
        return S;
    }

    public int getE() {
        return E;
    }

    public int getW() {
        return W;
    }

    public List<Puzzle> getPuzzles() {
        return puzzles;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public List<Item> getItem() {
        return item;
    }

    public List<Fixture> getFixures() {
        return fixures;
    }

    public String getPicture() {
        return picture;
    }


    // setter method


    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setN(int n) {
        N = n;
    }

    public void setS(int s) {
        S = s;
    }

    public void setE(int e) {
        E = e;
    }

    public void setW(int w) {
        W = w;
    }

    public void setPuzzles(List<Puzzle> puzzles) {
        this.puzzles = puzzles;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public void setFixures(List<Fixture> fixures) {
        this.fixures = fixures;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
