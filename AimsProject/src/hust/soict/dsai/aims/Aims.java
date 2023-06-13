package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.util.Scanner;
import hust.soict.dsai.aims.store.*;
public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        showMenu();
        handleMainMenuInput();
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    } 

    public static void handleMainMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            choice = scanner.nextInt();
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
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input! Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void viewStore() {
        storeMenu();
        handleStoreMenuInput();
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void handleStoreMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            choice = scanner.nextInt();
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
                    showMenu();
                    handleMainMenuInput();
                    break;
                default:
                    System.out.println("Invalid input! Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void seeMediaDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.search(title);
        if (media != null) {
            System.out.println(media.toString());

            if (media instanceof Playable) {
                mediaDetailsMenu();
                handleMediaDetailsMenuInput(media);
            }
        } else {
            System.out.println("Media not found!");
        }
        scanner.close();
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void handleMediaDetailsMenuInput(Media media) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            choice = scanner.nextInt
         }
    }
}