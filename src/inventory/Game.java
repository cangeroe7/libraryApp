package inventory;

/**
 * The {@code Game} class represents a game item in the inventory system.
 */
public class Game extends Item {
    private String developer;
    private GameGenre genre;

    /**
     * Constructs a game with the specified title, inventory date, developer, and genre.
     *
     * @param title         the title of the game
     * @param inventoryDate the inventory date of the game in the format "MM-DD-YYYY"
     * @param developer     the developer of the game
     * @param genre         the genre of the game
     * @throws Exception if the title is empty
     */
    public Game(String title, String inventoryDate, String developer, GameGenre genre) throws Exception {
        super(title, inventoryDate);
        this.developer = developer;
        this.genre = genre;
    }

    /**
     * Constructs a game with the specified title, inventory date, description, developer, and genre.
     *
     * @param title         the title of the game
     * @param inventoryDate the inventory date of the game in the format "MM-DD-YYYY"
     * @param description   the description of the game
     * @param developer     the developer of the game
     * @param genre         the genre of the game
     * @throws Exception if the title is empty
     */
    public Game(String title, String inventoryDate, String description, String developer, GameGenre genre) throws Exception {
        super(title, inventoryDate, description);
        this.developer = developer;
        this.genre = genre;
    }

    /**
     * Retrieves the developer of the game.
     *
     * @return the developer of the game
     */
    public String getDeveloper() {
        return this.developer;
    }

    /**
     * Sets the developer of the game.
     *
     * @param developer the developer of the game
     * @throws Exception if the developer is an empty string
     */
    public void setDeveloper(String developer) throws Exception {
        if (developer.isEmpty()) {
            throw new Exception("Developer can not be an empty string");
        }
        this.developer = developer;
    }

    /**
     * Retrieves the genre of the game.
     *
     * @return the genre of the game
     */
    public GameGenre getGenre() {
        return this.genre;
    }

    /**
     * Sets the genre of the game.
     *
     * @param genre the genre of the game
     */
    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }

    /**
     * Displays the game information in a single line.
     */
    @Override
    public void displayItemLine() {
        System.out.printf("Id: %-5d | Title: %-20s | Inventory Date: %-12s | Developer: %-20s | Game Genre: %s\n", this.getId(), this.getTitle(), this.getInventoryDate(), this.getDeveloper(), this.getGenre());
    }

    /**
     * Displays the game information in a block format.
     */
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