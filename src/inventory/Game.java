package inventory;

public class Game extends Item {
    private String developer;
    private MovieGenre genre;

    public Game(String title, String inventoryDate, String developer, MovieGenre genre) throws Exception {
        super(title, inventoryDate);
        this.developer = developer;
        this.genre = genre;
    }

    public Game(String title, String inventoryDate, String description, String developer, MovieGenre genre) throws Exception {
        super(title, inventoryDate, description);
        this.developer = developer;
        this.genre = genre;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }
}
