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

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }
}
