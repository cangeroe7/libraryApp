package inventory;

public class Movie extends Item {
    private String director;
    private MovieGenre genre;

    public Movie(String title, String inventoryDate, String director, MovieGenre genre) throws Exception {
        super(title, inventoryDate);
        this.director = director;
        this.genre = genre;
    }

    public Movie(String title, String inventoryDate, String description, String director, MovieGenre genre) throws Exception {
        super(title, inventoryDate, description);
        this.director = director;
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) throws Exception {
        if (director.isEmpty()) {
            throw new Exception("Director can not be an empty string");
        }
        this.director = director;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    @Override
    public void displayItemLine() {
        System.out.printf("Id: %-5d | Title: %-20s | Inventory Date: %-12s | Director: %-20s | Movie Genre: %s\n", this.getId(), this.getTitle(), this.getInventoryDate(), this.getDirector(), this.getGenre());
    }

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
