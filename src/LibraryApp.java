import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import inventory.*;

public class LibraryApp {
    private ArrayList<Item> inventoryItems = new ArrayList<>();
 

    public static void main(String[] args) {
        // Instantiate an ArrayList to store inventory items
    }       

    private void addInventoryItem() throws Exception {
        int itemChoice = Input.getIntRange("Select your item type:\nMovie: 1 - Music: 2 - Game: 3", 1, 3);

        Item newItem = null;

        String title = this.inputTitle();
        String inventoryDate = this.inputDate();
        String description = this.inputDescription();


        switch (itemChoice) {
            case 1:
                MovieGenre movieGenre = this.inputMovieGenre();
                String director = this.inputDirector();
                newItem = new Movie(title, inventoryDate, description, director, movieGenre);
                break;

            case 2:
                MusicGenre musicGenre = this.inputMusicGenre();
                String artist = this.inputArtist();
                newItem = new Music(title, inventoryDate, description, artist, musicGenre);
                break;

            case 3:
                GameGenre gameGenre = this.inputGameGenre();
                String developer = this.inputDeveloper();
                newItem = new Game(title, inventoryDate, description, developer, gameGenre);
                break;
        }

        this.inventoryItems.add(newItem);
    }

    private void updateInventoryItem() throws Exception {

        int id = Input.getInt("Enter the ID of the item to update:\n");
        Item item = null;

        for (Item inventoryItem : this.inventoryItems) {
            if (inventoryItem.getId() == id) {
                item = inventoryItem;
                break;
            }
        }

        if (item == null) {
            System.out.printf("No item found with ID: %d", id);
            return;
        }

        System.out.println("Select the field to update: ");
        System.out.println("Title: 1");
        System.out.println("Inventory Date: 2");
        System.out.println("Description: 3");

        if (item instanceof Movie) {
            System.out.println("Director: 4");
            System.out.println("Movie Genre: 5");
        } else if (item instanceof Music) {
            System.out.println("Artist: 4");
            System.out.println("Music Genre: 5");
        } else if (item instanceof Game) {
            System.out.println("Developer: 4");
            System.out.println("Game Genre: 5");
        }

        int choice = Input.getIntRange("Your choice: ", 1, 5);

        switch (choice) {
            case 1:
                String newTitle = this.inputTitle();
                item.setTitle(newTitle);
                break;

            case 2:
                String newDate = this.inputDate();
                item.setInventoryDate(newDate);
                break;

            case 3:
                String newDescription = this.inputDescription();
                item.setDescription(newDescription);
                break;
            
            case 4:
                if (item instanceof Movie) {
                    Movie movieItem = (Movie) item;
                    String newDirector = this.inputDirector();
                    movieItem.setDirector(newDirector);

                } else if (item instanceof Music) {
                    Music musicItem = (Music) item;
                    String newArtist = this.inputArtist();
                    musicItem.setArtist(newArtist);
                } else if (item instanceof Game) {
                    Game gameItem = (Game) item;
                    String newDeveloper = this.inputDeveloper();
                    gameItem.setDeveloper(newDeveloper);
                }
                break;

            case 5:
                if (item instanceof Movie) {
                    Movie movieItem = (Movie) item;
                    MovieGenre newMovieGenre = this.inputMovieGenre();
                    movieItem.setGenre(newMovieGenre);
                    
                } else if (item instanceof Music) {
                    Music musicItem = (Music) item;
                    MusicGenre newMusicGenre = this.inputMusicGenre();
                    musicItem.setGenre(newMusicGenre);
                    
                } else if (item instanceof Game) {
                    Game gameItem = (Game) item;
                    GameGenre newGameGenre = this.inputGameGenre();
                    gameItem.setGenre(newGameGenre);
                    
                }
                break;
        }
    }

    private void removeInventoryItem() {

        int id = Input.getInt("Enter the ID of the item to remove:\n");
        
        for (Item item : this.inventoryItems) {
            if (item.getId() == id) {
                this.inventoryItems.remove(item);
                System.out.printf("Item with ID: %d removed!", id);
            }
        }
    }

   private String inputTitle() {
        String title = "";
        while (title.isEmpty()) {
            title = Input.getLine("Input the title:\n");
            if (title.isEmpty()) {System.out.println("The title can not be empty\n");}
        }
        return title;
    }

    private String inputDate() {
        String date;
        while (true) {
            date = Input.getLine("Input date in format MM-DD-YYYY:\n");
            try {
                LocalDate.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            } catch (Exception e) {
                System.out.println("Invalid date! Must be MM-DD-YYYY");
                continue;
            }
            return date;
        }
    }

    private String inputDescription() {
        return Input.getLine("Input the description (optional):\n");
    }

    private MovieGenre inputMovieGenre() {
        System.out.println("Give the number of your genre:\n");

        for (int i = 0; i < MovieGenre.values().length; i++) {
            MovieGenre genre = MovieGenre.values()[i];
            System.out.println(genre + ":" + i);
        }

        return MovieGenre.values()[Input.getIntRange("Your Choice: ", 0, MovieGenre.values().length - 1)];
    }

    private MusicGenre inputMusicGenre() {
        System.out.println("Give the number of your genre:\n");

        for (int i = 0; i < MusicGenre.values().length; i++) {
            MusicGenre genre = MusicGenre.values()[i];
            System.out.println(genre + ":" + i);
        }

        return MusicGenre.values()[Input.getIntRange("Your Choice: ", 0, MusicGenre.values().length - 1)];
    }

    private GameGenre inputGameGenre() {
        System.out.println("Give the number of your genre:\n");

        for (int i = 0; i < GameGenre.values().length; i++) {
            GameGenre genre = GameGenre.values()[i];
            System.out.println(genre + ":" + i);
        }

        return GameGenre.values()[Input.getIntRange("Your Choice: ", 0, GameGenre.values().length - 1)];
    }

    private String inputDirector() {
        String director = "";
        while (director.isEmpty()) {
            director = Input.getLine("Input the director's name: ");
            if (director.isEmpty()) {System.out.println("The name can not be empty\n");}
        }
        return director;
    }

    private String inputArtist() {
        String artist = "";
        while (artist.isEmpty()) {
            artist = Input.getLine("Input the director's name: ");
            if (artist.isEmpty()) {System.out.println("The name can not be empty\n");}
        }
        return artist;
    }

    private String inputDeveloper() {
        String developer = "";
        while (developer.isEmpty()) {
            developer = Input.getLine("Input the director's name: ");
            if (developer.isEmpty()) {System.out.println("The name can not be empty\n");}
        }
        return developer;
    }
}
