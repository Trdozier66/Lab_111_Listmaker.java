import java.util.ArrayList;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        // Main loop waiting for user input
        while (running) {
            printMenu();
            char choice = SafeInput.getRegExString("Enter your choice: ", "[AaDdIiPpQq]").charAt(0);

            // Handle the user's choice
            switch (choice) {
                case 'A':
                    addItem();
                    break;
                case 'D':
                    deleteItem();
                    break;
                case 'I':
                    insertItem();
                    break;
                case 'P':
                    printList();
                    break;
                case 'Q':
                    running = quit();
                    break;
            }
        }
    }

    // Method to display the menu
    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    // Method to add an item to the list
    private static void addItem() {
        String item = SafeInput.getRegExString("Enter the item to add: ", ".+");
        list.add(item);
        System.out.println("Item added.");
    }

    // Method to delete an item from the list
    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        printList();
        int index = SafeInput.getRangedInt("Enter the item number to delete: ", 1, list.size()) - 1;
        list.remove(index);
        System.out.println("Item deleted.");
    }

    // Method to insert an item into the list at a specific location
    private static void insertItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to insert into.");
            return;
        }
        printList();
        int index = SafeInput.getRangedInt("Enter the location to insert at (1 to " + (list.size() + 1) + "): ", 1, list.size() + 1) - 1;
        String item = SafeInput.getRegExString("Enter the item to insert: ", ".+");
        list.add(index, item);
        System.out.println("Item inserted.");
    }

    // Method to print the current list
    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Current List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    // Method to handle quit confirmation
    private static boolean quit() {
        return SafeInput.getYNConfirm("Are you sure you want to quit?");
    }
}
