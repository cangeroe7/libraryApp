package inventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The {@code Item} class represents an item in the inventory system.
 */
public abstract class Item {
    private static int nextId = 0;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    private LocalDate inventoryDate;
    private int id;
    private String title;
    private String description;

    /**
     * Constructs an item with the specified title and inventory date.
     *
     * @param title         the title of the item
     * @param inventoryDate the inventory date of the item in the format "MM-DD-YYYY"
     * @throws Exception if the title is empty or the date format is invalid
     */
    public Item(String title, String inventoryDate) throws Exception {
        this.id = nextId++;
        this.setTitle(title);
        this.setInventoryDate(inventoryDate);
        this.description = "";
    }

    /**
     * Constructs an item with the specified title, inventory date, and description.
     *
     * @param title         the title of the item
     * @param inventoryDate the inventory date of the item in the format "MM-DD-YYYY"
     * @param description   the description of the item
     * @throws Exception if the title is empty or the date format is invalid
     */
    public Item(String title, String inventoryDate, String description) throws Exception {
        this.id = nextId++;
        this.setTitle(title);
        this.setInventoryDate(inventoryDate);
        this.setDescription(description);
    }

    /**
     * Constructs an item with the specified title, inventory date, and description.
     *
     * @param title         the title of the item
     * @param inventoryDate the inventory date of the item in the format "MM-DD-YYYY"
     * @param description   the description of the item
     * @throws Exception if the title is empty or the date format is invalid
     */
    public Item(int id, String title, String inventoryDate, String description) throws Exception {
        this.id = id;
        this.setTitle(title);
        this.setInventoryDate(inventoryDate);
        this.setDescription(description);
    }
    
    public static void setNextId(int id) {
        Item.nextId = id;
    }

    public static int getNextId() {
        return Item.nextId;
    }
    
    /**
     * Retrieves the ID of the item.
     *
     * @return the ID of the item
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retrieves the title of the item.
     *
     * @return the title of the item
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the item.
     *
     * @param title the title of the item
     * @throws Exception if the title is empty
     */
    public void setTitle(String title) throws Exception {
        if (title.isEmpty()) {
            throw new Exception("Title can not be empty!");
        }
        this.title = title;
    }

    /**
     * Retrieves the description of the item.
     *
     * @return the description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the item.
     *
     * @param description the description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the inventory date of the item.
     *
     * @return the inventory date of the item formatted as "MM-DD-YYYY"
     */
    public String getInventoryDate() {
        return this.inventoryDate.format(Item.formatter);
    }

    /**
     * Sets the inventory date of the item.
     *
     * @param inventoryDate the inventory date of the item in the format "MM-DD-YYYY"
     * @throws Exception if the date format is invalid
     */
    public void setInventoryDate(String inventoryDate) throws Exception {
        try {
            this.inventoryDate = LocalDate.parse(inventoryDate, Item.formatter);
        } catch (Exception e) {
            throw new Exception("Invalid date! Must be MM-DD-YYYY");
        }
    }

    /**
     * Displays the item information in a single line.
     */
    public abstract void displayItemLine();

    /**
     * Displays the item information in a block format.
     */
    public abstract void displayItemBlock();
}