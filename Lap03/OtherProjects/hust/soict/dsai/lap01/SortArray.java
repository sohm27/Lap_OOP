import java.util.*;
import math;
public class SortArray {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int length=scan.nextInt();
        int array[]=new int[length];
        System.out.println("Enter the elements of the array:");
        for (int i=0;i<length;i++) array[i]=scan.nextInt();
        int sum=0;
        for (int i=0;i<length;i++) sum+=array[i];
        System.out.println("Sum of the array element: "+sum);
        //float avg=sum/length;
        System.out.println("Avarage value of the array element: "+(float)sum/length);
    }
}
