package inventory;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<String, MovieGenre> enumMap = new HashMap<>();

    static {
        for (MovieGenre genre : MovieGenre.values()) {
            enumMap.put(genre.name().toLowerCase(), genre);
        }
    }

    public static MovieGenre fromString(String str) {
        return enumMap.get(str.toLowerCase());
    }
}

