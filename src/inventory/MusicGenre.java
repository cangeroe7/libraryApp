package inventory;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<String, MusicGenre> enumMap = new HashMap<>();

    static {
        for (MusicGenre genre : MusicGenre.values()) {
            enumMap.put(genre.name().toLowerCase(), genre);
        }
    }

    public static MusicGenre fromString(String str) {
        return enumMap.get(str.toLowerCase());
    }
}