package inventory;

/**
 * The {@code Game} class represents a game item in the inventory system.
 */
public class Game extends Item implements CheckInOut {
    private String developer;
    private GameGenre genre;
    private Boolean checkedOut;

    /**
     * Constructs a game with the specified title, inventory date, developer, and genre.
     *
     * @param title         the title of the game
     * @param inventoryDate the inventory date of the game in the format "MM-DD-YYYY"
     * @param developer     the developer of the game
     * @param genre         the genre of the game
     * @param checkedOut    boolean if the item is checked out
     * @throws Exception if the title is empty
     */
    public Game(String title, String inventoryDate, String developer, GameGenre genre, boolean checkedOut) throws Exception {
        super(title, inventoryDate);
        this.developer = developer;
        this.genre = genre;
        this.checkedOut = checkedOut;
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
        this.checkedOut = false;
    }

    /**
     * Constructs a game with the specified title, inventory date, description, developer, and genre.
     *
     * @param title         the title of the game
     * @param inventoryDate the inventory date of the game in the format "MM-DD-YYYY"
     * @param description   the description of the game
     * @param developer     the developer of the game
     * @param genre         the genre of the game
     * @param checkedOut    boolean if the item is checked out
     * @throws Exception if the title is empty
     */
    public Game(int id, String title, String inventoryDate, String description, String developer, GameGenre genre, boolean checkedOut) throws Exception {
        super(id, title, inventoryDate, description);
        this.developer = developer;
        this.genre = genre;
        this.checkedOut = checkedOut;
    }

    public void checkIn() {
        if (!this.isCheckedOut()) {
            System.out.println("Game Is Already Checked In");
            return;
        }
        this.checkedOut = false;
        System.out.println("You Have Checked In The Game: " + this.getTitle());
    }

    public void checkOut() {
        if (this.isCheckedOut()) {
            System.out.println("Game Is Already Checked Out");
            return;
        }
        this.checkedOut = true;
        System.out.println("You Have Checked Out The Game: " + this.getTitle());
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
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
        System.out.printf("Id: %-5d | Title: %-16s | Checked Out: %-6b | Inventory Date: %-10s | Developer: %-16s | Game Genre:  %s\n", this.getId(), this.getTitle(), this.isCheckedOut(),  this.getInventoryDate(), this.getDeveloper(), this.getGenre());
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