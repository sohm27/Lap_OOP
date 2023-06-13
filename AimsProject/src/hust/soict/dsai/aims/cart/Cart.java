package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println("Added " + media.getTitle() + " to the cart.");
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed " + media.getTitle() + " from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
		
	public void print() {
		System.out.println("***************Cart***************");
		System.out.println("Ordered Items");
		int order=1;
		for (Media cart:itemsOrdered ) {
			if (cart!=null) {
				System.out.print(order+".DVD-");
				System.out.print(String.format("%s -%s -%s -%d: %.2f $",
						cart.getTitle(), cart.getCategory(), cart.getDirector(), cart.getLength(), cart.getCost()));
				System.out.println("");
				order+=1;
			}
		}
		System.out.println("Total cost: "+totalCost());
		System.out.println("**********************************");
	}
}
	