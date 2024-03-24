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

    public void setDirector(String director) {
        this.director = director;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }
}
