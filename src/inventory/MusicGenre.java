package inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * The enumeration class {@code MusicGenre} represents various genres of music.
 */
public enum MusicGenre {
    ROCK,
    POP,
    JAZZ,
    CLASSICAL,
    HIP_HOP,
    ELECTRONIC,
    COUNTRY,
    REGGAE,
    BLUES,
    METAL;

    /**
     * A map to store the mapping between genre names and their corresponding {@code MusicGenre} enums.
     */
    private static final Map<String, MusicGenre> enumMap = new HashMap<>();

    static {
        // Populate the enumMap with lowercase genre names as keys and corresponding MusicGenre enums as values.
        for (MusicGenre genre : MusicGenre.values()) {
            enumMap.put(genre.name().toLowerCase(), genre);
        }
    }

    /**
     * Retrieves the {@code MusicGenre} enum associated with the given genre name.
     *
     * @param str the genre name
     * @return the corresponding {@code MusicGenre} enum, or {@code null} if the genre name is not found
     */
    public static MusicGenre fromString(String str) {
        return enumMap.get(str.toLowerCase());
    }
}