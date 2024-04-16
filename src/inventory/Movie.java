package inventory;

/**
 * The {@code Movie} class represents a movie item in the inventory system.
 */
public class Movie extends Item implements CheckInOut {
    private String director;
    private MovieGenre genre;
    private Boolean checkedOut;

    /**
     * Constructs a movie with the specified title, inventory date, director, and genre.
     *
     * @param title         the title of the movie
     * @param inventoryDate the inventory date of the movie in the format "MM-DD-YYYY"
     * @param director      the director of the movie
     * @param genre         the genre of the movie
     * @param checkedOut    boolean if the item is checked out
     * @throws Exception if the title is empty
     */
    public Movie(String title, String inventoryDate, String director, MovieGenre genre, boolean checkedOut) throws Exception {
        super(title, inventoryDate);
        this.director = director;
        this.genre = genre;
        this.checkedOut = checkedOut;
    }

    /**
     * Constructs a movie with the specified title, inventory date, description, director, and genre.
     *
     * @param title         the title of the movie
     * @param inventoryDate the inventory date of the movie in the format "MM-DD-YYYY"
     * @param description   the description of the movie
     * @param director      the director of the movie
     * @param genre         the genre of the movie
     * @throws Exception if the title is empty
     */
    public Movie(String title, String inventoryDate, String description, String director, MovieGenre genre) throws Exception {
        super(title, inventoryDate, description);
        this.director = director;
        this.genre = genre;
        this.checkedOut = false;
    }

    /**
     * Constructs a movie with the specified title, inventory date, description, director, and genre.
     *
     * @param title         the title of the movie
     * @param inventoryDate the inventory date of the movie in the format "MM-DD-YYYY"
     * @param description   the description of the movie
     * @param director      the director of the movie
     * @param genre         the genre of the movie
     * @param checkedOut    boolean if the item is checked out
     * @throws Exception if the title is empty
     */
    public Movie(int id, String title, String inventoryDate, String description, String director, MovieGenre genre, boolean checkedOut) throws Exception {
        super(id, title, inventoryDate, description);
        this.director = director;
        this.genre = genre;
        this.checkedOut = checkedOut;
    }

    public void checkIn() {
        if (!this.isCheckedOut()) {
            System.out.println("Movie Is Already Checked In");
            return;
        }
        this.checkedOut = false;
        System.out.println("You Have Checked In The Movie: " + this.getTitle());
    }

    public void checkOut() {
        if (this.isCheckedOut()) {
            System.out.println("Movie Is Already Checked Out");
            return;
        }
        this.checkedOut = true;
        System.out.println("You Have Checked Out The Movie: " + this.getTitle());
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }
    
    /**
     * Retrieves the director of the movie.
     *
     * @return the director of the movie
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the director of the movie.
     *
     * @param director the director of the movie
     * @throws Exception if the director is an empty string
     */
    public void setDirector(String director) throws Exception {
        if (director.isEmpty()) {
            throw new Exception("Director can not be an empty string");
        }
        this.director = director;
    }

    /**
     * Retrieves the genre of the movie.
     *
     * @return the genre of the movie
     */
    public MovieGenre getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the movie.
     *
     * @param genre the genre of the movie
     */
    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    /**
     * Displays the movie information in a single line.
     */
    @Override
    public void displayItemLine() {
        System.out.printf("Id: %-5d | Title: %-16s | Checked Out: %-6b | Inventory Date: %-10s | Director:  %-16s | Movie Genre: %s\n", this.getId(), this.getTitle(), this.isCheckedOut(), this.getInventoryDate(), this.getDirector(), this.getGenre());
    }

    /**
     * Displays the movie information in a block format.
     */
    @Override
    public void displayItemBlock() {
        System.out.println("Id: " + this.getId());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Inventory Date: " + this.getInventoryDate());
        System.out.println("Director: " + this.getDirector());
        System.out.println("Movie Genre: " + this.getGenre());
        System.err.println("Description: \n" + this.getDescription());
    }
}