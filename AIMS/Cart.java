public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered=0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered<20) {
			qtyOrdered+=1;
		    itemsOrdered[qtyOrdered]=disc;
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
				if (itemsOrdered[qtyOrdered]==disc) {
					itemsOrdered[qtyOrdered]=null;
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
		for (int i=0;i<qtyOrdered;i++) {
			sum+=itemsOrdered[qtyOrdered].getCost();
		}
		return sum;
	}
}
