package inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * The enumeration class {@code MovieGenre} represents various genres of movies.
 */
public enum MovieGenre {
    ACTION,
    COMEDY,
    DRAMA,
    HORROR,
    ROMANCE,
    SCIENCE_FICTION,
    THRILLER,
    ANIMATION,
    DOCUMENTARY,
    FANTASY;

    /**
     * A map to store the mapping between genre names and their corresponding {@code MovieGenre} enums.
     */
    private static final Map<String, MovieGenre> enumMap = new HashMap<>();

    static {
        // Populate the enumMap with lowercase genre names as keys and corresponding MovieGenre enums as values.
        for (MovieGenre genre : MovieGenre.values()) {
            enumMap.put(genre.name().toLowerCase(), genre);
        }
    }

    /**
     * Retrieves the {@code MovieGenre} enum associated with the given genre name.
     *
     * @param str the genre name
     * @return the corresponding {@code MovieGenre} enum, or {@code null} if the genre name is not found
     */
    public static MovieGenre fromString(String str) {
        return enumMap.get(str.toLowerCase());
    }
}