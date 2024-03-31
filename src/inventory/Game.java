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

    @Override
    public void displayItemLine() {
        System.out.println("Id: " + this.getId() + " - Title: " + this.getTitle() + " - Inventory Date: " + this.getInventoryDate() + " - Developer: " + this.getDeveloper() + " - Game Genre: " + this.getGenre());
    }

    @Override
    public void displayItemBlock() {
        System.out.println("Id: " + this.getId());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Inventory Date: " + this.getInventoryDate());
        System.out.println("Developer: " + this.getDeveloper());
        System.out.println("Game Genre: " + this.getGenre());
        System.err.println("Description:\n" + this.getDescription());
    }
}
