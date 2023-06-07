package hust.soict.dsai.garbage;
import java.util.Random;
public class ConcatenationInLoops {
	public static void main(String[] args) {
			Random r = new Random(100000);
			String s = "";
			long start = System.currentTimeMillis();
			for (int i= 0; i < 100000; i++) {
				s += r.nextInt(2);
			}
			System.out.println(System.currentTimeMillis() - start);
			r = new Random(100000);
			start = System.currentTimeMillis();
			StringBuffer strbuffer = new StringBuffer();
			for (int i= 0; i < 100000; i++) {
				strbuffer.append(r.nextInt(2));
			}
			System.out.println(System.currentTimeMillis() - start);
			r = new Random(100000);
			start = System.currentTimeMillis();
			StringBuilder strbuilder = new StringBuilder();
			for (int i= 0; i < 100000; i++) {
				strbuilder.append(r.nextInt(2));
			}
			System.out.println(System.currentTimeMillis() - start);
		}
	
}	
