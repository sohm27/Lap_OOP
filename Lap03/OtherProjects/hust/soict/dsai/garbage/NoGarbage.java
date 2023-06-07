package hust.soict.dsai.garbage;
public class NoGarbage {
	public static void main(String[] args) {
    StringBuilder garbage=new StringBuilder();
		int i = 0;
		while (i<1234567) {
			garbage += i;
			System.out.println(i);
			i ++;
		}
	}
}
