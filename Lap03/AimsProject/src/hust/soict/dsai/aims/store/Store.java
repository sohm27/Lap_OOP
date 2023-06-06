package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_ORDERED=2000;
	private DigitalVideoDisc itemsStore[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered=0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered<MAX_NUMBERS_ORDERED) {
			for (int i=0;i<MAX_NUMBERS_ORDERED;i++) {
				if (itemsStore[i]==null) {itemsStore[i]=disc;
				qtyOrdered+=1;
				break;
				}
			}
			System.out.println("The disc has been added successfully");
		} else {
			System.out.println("The store is almost full");
		}
		
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered!=0) {
			boolean check=true;
			for(int i=0;i<qtyOrdered;i++) {
				if (itemsStore[i]==disc) {
					itemsStore[i]=null;
					check=false;
					qtyOrdered-=1;
					System.out.println("The disc has been removed");
					break;
				}
			}
			if (check) {
				System.out.println("That disc is not in the store anymore");
			}
		} else {
			System.out.println("The store is empty");
		}
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
}
