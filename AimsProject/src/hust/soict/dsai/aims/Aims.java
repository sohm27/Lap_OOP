package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
public class Aims {
    private static Store store;
    private static Cart cart;

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        showMenu();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("AIMS:");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void viewStore() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void seeMediaDetails() {
    	System.out.println("Enter title of media: ");
		Scanner scanner;
		String title = scanner.nextLine();
		boolean isInStore = false;
		for (Media media: store.getItemsInStore()){
			if (media.getTitle().equals(title)){
				Media yourMedia = media;
				isInStore = true;
				System.out.println(media);
				mediaDetailsMenu();
			}
		}
		if (!isInStore){
			System.out.println("This media is not in the store.");
			
		}
		showMenu();
    }

    public static void mediaDetailsMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addMediaToCart();
                    break;
                case 2:
                    playMedia();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void addMediaToCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the title of the media to add to cart:");
        String title = scanner.nextLine();

        Media media = store.searchMedia(title);

        if (media != null) {
            cart.addMedia(media);

            if (media instanceof DigitalVideoDisc) {
                int dvdCount = cart.getDvdCount();
                System.out.println("Number of DVDs in cart: " + dvdCount);
            }

            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();

        Media media = store.searchMedia(title);

        if (media != null) {
            if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
                System.out.println("Playing " + media.getTitle());
            } else {
                System.out.println("Media is not playable.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStore() {
    	System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");

		System.out.println("Choose a number:");
		Scanner scanner;
		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option){
			case 1:
				addMediaToCart();
				break;
			case 2:
				removeMediaFromCart();
				break;
			case 0:
				
				break;
		}
		showMenu();
    }

    public static void seeCurrentCart() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void filterMediasInCart() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Filtering Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Filter by ID");
            System.out.println("2. Filter by Title");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter the ID to filter:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    cart.filterMediaById(id);
                    break;
                case 2:
                    System.out.println("Enter the Title to filter:");
                    String title = scanner.nextLine();

                    cart.filterMediaByTitle(title);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void sortMediasInCart() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Sorting Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Sort by Title");
            System.out.println("2. Sort by Cost");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    cart.sortMediaByTitle();
                    break;
                case 2:
                    cart.sortMediaByCost();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void removeMediaFromCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the title of the media to remove from cart:");
        String title = scanner.nextLine();

        boolean removed = cart.removeMedia(title);

        if (removed) {
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void placeOrder() {
        System.out.println("Order created. Thank you!");
        cart = new Cart(); 
    }
}
