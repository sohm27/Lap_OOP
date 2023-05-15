
public class Aims {
	public static void main(String[] args) {
		Cart anOrder=new Cart();
		DigitalVideoDisc dvd1=new DigitalVideoDisc("jd","jj","jm",83,19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		System.out.println(anOrder.totalCost()+" "+anOrder.getQtyOrdered());
		anOrder.removeDigitalVideoDisc(dvd1);
	}
}
