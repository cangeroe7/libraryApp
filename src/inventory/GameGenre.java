package inventory;

import java.util.HashMap;
import java.util.Map;

public enum GameGenre {
    ACTION,
    ADVENTURE,
    RPG,
    STRATEGY,
    SPORTS,
    PUZZLE,
    SIMULATION,
    FIGHTING,
    HORROR,
    PLATFORMER;

    private static final Map<String, GameGenre> enumMap = new HashMap<>();

    static {
        for (GameGenre genre : GameGenre.values()) {
            enumMap.put(genre.name().toLowerCase(), genre);
        }
    }

    public static GameGenre fromString(String str) {
        return enumMap.get(str.toLowerCase());
    }
}