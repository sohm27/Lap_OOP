package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered=0;
	@SuppressWarnings("unused")
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered<MAX_NUMBERS_ORDERED) {
			for (int i=0;i<MAX_NUMBERS_ORDERED;i++) {
				if (itemsOrdered[i]==null) {itemsOrdered[i]=disc;
				qtyOrdered+=1;
				break;
				}
			}
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered!=0) {
			boolean check=true;
			for(int i=0;i<qtyOrdered;i++) {
				if (itemsOrdered[i]==disc) {
					itemsOrdered[i]=null;
					check=false;
					qtyOrdered-=1;
					System.out.println("The disc has been removed");
					break;
				}
			}
			if (check) {
				System.out.println("That disc is not in your cart");
			}
		} else {
			System.out.println("The cart is empty");
		}
	}
	public float totalCost() {
		float sum=0;
		for (int i=0;i<20;i++) {
			if (itemsOrdered[i]!=null) sum+=itemsOrdered[i].getCost();
		}
		return sum;
	}
	public void print() {
		System.out.println("***************Cart***************");
		System.out.println("Ordered Items");
		int order=1;
		for (DigitalVideoDisc cart:itemsOrdered ) {
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
	
