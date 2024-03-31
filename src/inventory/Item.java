package inventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Item {
    private static int nextId = 0;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    private LocalDate inventoryDate;
    private int id;
    private String title;
    private String description;

    public Item(String title, String inventoryDate) throws Exception {
        this.id = nextId++;
        this.setTitle(title);
        this.setInventoryDate(inventoryDate);
        this.description = "";
    }

    public Item(String title, String inventoryDate, String description) throws Exception {
        this.id = nextId++;
        this.setTitle(title);
        this.setInventoryDate(inventoryDate);
        this.setDescription(description);
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) throws Exception {
        if (title.isEmpty()) {
            throw new Exception("Title can not be empty!");
        }
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInventoryDate() {
        return this.inventoryDate.format(Item.formatter);
    }

    public void setInventoryDate(String inventoryDate) throws Exception {
        try {
            this.inventoryDate = LocalDate.parse(inventoryDate, Item.formatter);
        } catch (Exception e){
            throw new Exception("Invalid date! Must be MM-DD-YYYY");
        }
    }

    public void displayItemLine() {
        System.out.println("Id: " + this.getId() + " - Title: " + this.getTitle() + " - Inventory Date: " + this.getInventoryDate());
    }

    public void displayItemBlock() {
        System.out.println("Id: " + this.getId());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Inventory Date: " + this.getInventoryDate());
        System.err.println("Description: \n" + this.getDescription());
    }
}
