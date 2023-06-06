package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
public class StoreTest {
	public static void main(String[] args) {
		Store anOrder=new Store();
		DigitalVideoDisc dvd1=new DigitalVideoDisc("jd","jj","jm",83,19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		System.out.println("Number of discs in store:"+anOrder.getQtyOrdered());
		anOrder.removeDigitalVideoDisc(dvd1);
		System.out.println("Number of discs in store:"+anOrder.getQtyOrdered());
	}
}
