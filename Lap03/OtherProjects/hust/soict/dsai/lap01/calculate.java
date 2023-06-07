import java.util.Scanner;
public class calculate {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        String strNum1=scan.nextLine();
        String strNum2=scan.nextLine();
        double num1=Double.parseDouble(strNum1);
        double num2=Double.parseDouble(strNum2);
        System.out.println(num1+num2);

    }
}
