package inventory;

/**
 * The {@code Music} class represents a music item in the inventory system.
 */
public class Music extends Item {
    private String artist;
    private MusicGenre genre;

    /**
     * Constructs a music item with the specified title, inventory date, artist, and genre.
     *
     * @param title         the title of the music item
     * @param inventoryDate the inventory date of the music item in the format "MM-DD-YYYY"
     * @param artist        the artist of the music item
     * @param genre         the genre of the music item
     * @throws Exception if the title is empty
     */
    public Music(String title, String inventoryDate, String artist, MusicGenre genre) throws Exception {
        super(title, inventoryDate);
        this.artist = artist;
        this.genre = genre;
    }

    /**
     * Constructs a music item with the specified title, inventory date, description, artist, and genre.
     *
     * @param title         the title of the music item
     * @param inventoryDate the inventory date of the music item in the format "MM-DD-YYYY"
     * @param description   the description of the music item
     * @param artist        the artist of the music item
     * @param genre         the genre of the music item
     * @throws Exception if the title is empty
     */
    public Music(String title, String inventoryDate, String description, String artist, MusicGenre genre) throws Exception {
        super(title, inventoryDate, description);
        this.artist = artist;
        this.genre = genre;
    }

    /**
     * Retrieves the artist of the music item.
     *
     * @return the artist of the music item
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the artist of the music item.
     *
     * @param artist the artist of the music item
     * @throws Exception if the artist is an empty string
     */
    public void setArtist(String artist) throws Exception {
        if (artist.isEmpty()) {
            throw new Exception("Artist can not be an empty string");
        }
        this.artist = artist;
    }

    /**
     * Retrieves the genre of the music item.
     *
     * @return the genre of the music item
     */
    public MusicGenre getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the music item.
     *
     * @param genre the genre of the music item
     */
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    /**
     * Displays the music item information in a single line.
     */
    @Override
    public void displayItemLine() {
        System.out.printf("Id: %-5d | Title: %-20s | Inventory Date: %-12s | Artist: %-20s | Music Genre: %s\n", this.getId(), this.getTitle(), this.getInventoryDate(), this.getArtist(), this.getGenre());
    }

    /**
     * Displays the music item information in a block format.
     */
    @Override
    public void displayItemBlock() {
        System.out.println("Id: " + this.getId());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Inventory Date: " + this.getInventoryDate());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Music Genre: " + this.getGenre());
        System.err.println("Description:\n" + this.getDescription());
    }
}