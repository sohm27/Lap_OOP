import java.util.Scanner;
public class DisplayTriangle {
    public static void main(String args[]) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter n: ");
        int n=scan.nextInt();
        for (int i=0;i<n;i++){
            for (int j=n-i;j>0;j--){
                System.out.printf(" ");
            }
            for (int m=0;m<2*i+1;m++) {
                System.out.printf("*");
            }
            for (int p=n-i;p>0;p--){
                System.out.printf(" ");
            }
            System.out.println(" ");
        }
    }
}
