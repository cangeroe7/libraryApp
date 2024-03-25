package inventory;

public class Game extends Item {
    private String developer;
    private GameGenre genre;

    public Game(String title, String inventoryDate, String developer, GameGenre genre) throws Exception {
        super(title, inventoryDate);
        this.developer = developer;
        this.genre = genre;
    }

    public Game(String title, String inventoryDate, String description, String developer, GameGenre genre) throws Exception {
        super(title, inventoryDate, description);
        this.developer = developer;
        this.genre = genre;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String developer) throws Exception {
        if (developer.isEmpty()) {
            throw new Exception("Developer can not be an empty string");
        }
        this.developer = developer;
    }

    public GameGenre getGenre() {
        return this.genre;
    }

    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }
}
