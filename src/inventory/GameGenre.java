package inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * The enumeration class {@code GameGenre} represents various genres of games.
 */
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

    /**
     * A map to store the mapping between genre names and their corresponding {@code GameGenre} enums.
     */
    private static final Map<String, GameGenre> enumMap = new HashMap<>();

    static {
        // Populate the enumMap with lowercase genre names as keys and corresponding GameGenre enums as values.
        for (GameGenre genre : GameGenre.values()) {
            enumMap.put(genre.name().toLowerCase(), genre);
        }
    }

    /**
     * Retrieves the {@code GameGenre} enum associated with the given genre name.
     *
     * @param str the genre name
     * @return the corresponding {@code GameGenre} enum, or {@code null} if the genre name is not found
     */
    public static GameGenre fromString(String str) {
        return enumMap.get(str.toLowerCase());
    }
}
