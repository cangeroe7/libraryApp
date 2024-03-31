package inventory;

public class Music extends Item {
    private String artist;
    private MusicGenre genre;

    public Music(String title, String inventoryDate, String artist, MusicGenre genre) throws Exception {
        super(title, inventoryDate);
        this.artist = artist;
        this.genre = genre;
    }
    
    public Music(String title, String inventoryDate, String description, String artist, MusicGenre genre) throws Exception {
        super(title, inventoryDate, description);
        this.artist = artist;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) throws Exception {
        if (artist.isEmpty()) {
            throw new Exception("Artist can not be an empty string");
        }
        this.artist = artist;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    @Override
    public void displayItemLine() {
        System.out.println("Id: " + this.getId() + " - Title: " + this.getTitle() + " - Inventory Date: " + this.getInventoryDate() + " - Artist: " + this.getArtist() + " - Music Genre: " + this.getGenre());
    }

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
