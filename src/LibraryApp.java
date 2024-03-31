import java.util.ArrayList;

import javax.print.attribute.standard.Sides;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import inventory.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

public class LibraryApp {

    private static final String DOUBLE_DASH_LINE = String.valueOf("=").repeat(50);
    private static final String SINGLE_DASH_LINE = String.valueOf("-").repeat(50);

    private static final String fileName = "inventory_items.csv";
    private ArrayList<Item> inventoryItems = new ArrayList<>();
 

        
    
    private void readFromFile() throws Exception {

        try (BufferedReader bufReader = new BufferedReader(new FileReader(LibraryApp.fileName))) {

            bufReader.readLine();

            String line;

            while ((line = bufReader.readLine()) != null) {

                String[] fields = line.split(",");

                switch (fields[0]) {

                    case "movie":
                        MovieGenre movieGenre = MovieGenre.fromString(fields[5]);
                        this.addInventoryItem(fields[1], fields[2], fields[3], fields[4], movieGenre);

                        break;

                    case "music":
                        MusicGenre musicGenre = MusicGenre.fromString(fields[5]);
                        this.addInventoryItem(fields[1], fields[2], fields[3], fields[4], musicGenre);

                        break;

                    case "game":
                        GameGenre gameGenre = GameGenre.fromString(fields[5]);
                        this.addInventoryItem(fields[1], fields[2], fields[3], fields[4], gameGenre);

                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {

        File file = new File(LibraryApp.fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(LibraryApp.fileName))) {

            bufWriter.write("item type,title,inventory date,description,director artist developer,genre");
            bufWriter.newLine();

            for (Item item : this.inventoryItems) {
               String csvEntry = this.getCsvString(item);
               bufWriter.write(csvEntry); 
               bufWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCsvString(Item item) {

        String csvString = "";
        csvString += item.getTitle() + ",";
        csvString += item.getInventoryDate() + ",";
        csvString += item.getDescription() + ",";
        
        if (item instanceof Movie) {
            Movie movie = (Movie) item;
            csvString = "movie," + csvString;
            csvString += movie.getDirector() + ",";
            csvString += movie.getGenre().toString();

        } else if (item instanceof Music) {
            Music music = (Music) item;
            csvString = "music," + csvString;
            csvString += music.getArtist() + ",";
            csvString += music.getGenre().toString();
            
        } else if (item instanceof Game) {
            Game game = (Game) item;
            csvString = "game," + csvString;
            csvString += game.getDeveloper() + ",";
            csvString += game.getGenre().toString();
        }

        return csvString;
    }

    private void addInventoryItem(String title, String inventoryDate, String description, String director, MovieGenre genre) throws Exception {
        Movie movie = new Movie(title, inventoryDate, description, director, genre);
        this.inventoryItems.add(movie);
    }

    private void addInventoryItem(String title, String inventoryDate, String description, String artist, MusicGenre genre) throws Exception {
        Music music = new Music(title, inventoryDate, description, artist, genre);
        this.inventoryItems.add(music);
    }

    private void addInventoryItem(String title, String inventoryDate, String description, String developer, GameGenre genre) throws Exception {
        Game game = new Game(title, inventoryDate, description, developer, genre);
        this.inventoryItems.add(game);
    }

    private void addInventoryItem() throws Exception {
        System.out.println(SINGLE_DASH_LINE);
        System.out.println("Item To Add");
        System.out.println(SINGLE_DASH_LINE);

        System.out.println("0 = Exit");
        System.out.println("1 = Movie");
        System.out.println("2 = Music");
        System.out.println("3 = Game");

        System.out.println(SINGLE_DASH_LINE);
        int itemChoice = Input.getIntRange("Item Choice: ", 0, 3);
        System.err.println(SINGLE_DASH_LINE);

        if (itemChoice == 0) {
            System.out.println("Exiting...");
            return;
        }

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
            default:
                System.out.println("Invalid Menu Choice = " + itemChoice);
        }

        this.inventoryItems.add(newItem);
    }

    private void updateInventoryItem() throws Exception {

        System.out.println(SINGLE_DASH_LINE);
        int id = Input.getInt("Enter the ID of the item to update:\n");
        System.out.println(SINGLE_DASH_LINE);
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

        System.out.println(SINGLE_DASH_LINE);
        System.out.println("Select the field to update: ");
        System.out.println(SINGLE_DASH_LINE);

        System.out.println("0 = Exit");
        System.out.println("1 = Title");
        System.out.println("2 = Inventory Date");
        System.out.println("3 = Description");

        if (item instanceof Movie) {
            System.out.println("4 = Director");
            System.out.println("5 = Movie Genre");
        } else if (item instanceof Music) {
            System.out.println("4 = Artist");
            System.out.println("5 = Music Genre");
        } else if (item instanceof Game) {
            System.out.println("4 = Developer");
            System.out.println("5 = Game Genre");
        }

        System.out.println(SINGLE_DASH_LINE);
        int choice = Input.getIntRange("Your choice: ", 0, 5);
        System.out.println(SINGLE_DASH_LINE);

        switch (choice) {
            case 0:
                System.out.println("Exiting...");
                return;
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
            default:
                System.out.println("Invalid Menu Choice = " + choice);
        }
    }

    private void removeInventoryItem() {

        System.out.println(SINGLE_DASH_LINE);
        int id = Input.getInt("Enter the ID of the item to remove:\n");
        System.out.println(SINGLE_DASH_LINE);
        
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

    private void runLibraryApp() throws Exception {
        boolean keepLooping = true;



        while (keepLooping) {
            keepLooping = this.displayMenu();
        }

    }

    private void displayHeading() {
        System.out.println(DOUBLE_DASH_LINE);
        System.out.println("Welcome To The Library App");
        System.out.println(DOUBLE_DASH_LINE);
        System.out.println();
    }

    private void exitLibraryApp() {
        System.out.println(DOUBLE_DASH_LINE);
        System.out.println("Thanks For Using The Library App!\n");
        System.out.println("Saving Library Items To File");
        System.out.println();
        System.out.println("...");
        System.out.println();
        try {
            this.writeToFile();
            System.out.println("Succesfully Saved To File!");
        } catch (Exception e) {
            System.out.println("Failed To Write To File");    
        }
        System.out.println(DOUBLE_DASH_LINE);
    }

    private boolean displayMenu() throws Exception {

        System.out.println(SINGLE_DASH_LINE);
        System.out.println("Main Menu");
        System.out.println(SINGLE_DASH_LINE);

        System.out.println("0 = Exit Library App");
        System.out.println("1 = Add New Item");
        System.out.println("2 = Update Item");
        System.out.println("3 = Remove Item");

        System.out.println(SINGLE_DASH_LINE);
        int userInput = Input.getIntRange("Menu Choice: ", 0, 3);           
        System.out.println(SINGLE_DASH_LINE);
        System.out.println();

        switch (userInput) {
            case 0:
                this.exitLibraryApp();
                return false;
            case 1: 
                this.addInventoryItem();
                break;
            case 2:
                this.updateInventoryItem();
                break;
            case 3:
                this.removeInventoryItem();
                break;
            default:
                System.out.println("Invalid Menu Choice = " + userInput);
                break;
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        LibraryApp app = new LibraryApp();

        app.displayHeading();

        try {
            app.readFromFile();
            app.runLibraryApp();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error. Please contact Tom Kraan");
        }

        Input.sc.close();
    }
}
