package hust.soict.dsai.garbage;
public class GarbageCreator {
	public static void main(String[] args) {
		String garbage = "";
		int i = 0;
		while (i<1234567) {
			garbage += i;
			System.out.println(i);
			i ++;
		}
	}
}