---

# Library Inventory Management System

This project is a Library Inventory Management System developed in Java. It allows users to manage items in a library inventory, including movies, music, and games.

## Features

- **Add Items**: Add new movies, music, or games to the inventory.
- **Update Items**: Update existing items in the inventory, such as title, date, description, director/artist/developer, and genre.
- **Remove Items**: Remove items from the inventory.
- **Display Items**: View all items currently in the inventory.
- **Read/Write to File**: Read inventory items from a CSV file on startup and write changes back to the file upon exit.

## Project Structure

The project is organized into several Java classes and follows the MVC (Model-View-Controller) design pattern:

- **Model**:
  - `Item`: Represents a generic item in the library inventory.
  - `Movie`, `Music`, `Game`: Subclasses of `Item` representing specific types of items.
  - `MovieGenre`, `MusicGenre`, `GameGenre`: Enums representing genres for movies, music, and games respectively.

- **View**:
  - `Input`: Handles user input through the console.

- **Controller**:
  - `LibraryApp`: Main class that controls the application flow, including menu display, user input processing, and file I/O operations.

## Usage

1. **Run the Application**: Compile and run the `LibraryApp.java` file to start the application.
2. **Main Menu**: Follow the on-screen prompts to navigate through the main menu and perform various actions.
3. **Exit**: Choose the "Exit Library App" option to save changes and exit the application.

## Requirements

- Java Development Kit (JDK) 8 or higher.

## File Structure

- `inventory` Package: Contains all Java classes related to the library inventory.
- `inventory_items.csv`: CSV file used for storing inventory items.

## Contributing

Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.

---