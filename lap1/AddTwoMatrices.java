import java.util.*;
public class AddTwoMatrices {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number of rows of matrices: ");
        int m=scan.nextInt();
        System.out.println("Enter the number of columns of matrices: ");
        int n=scan.nextInt();
        int array1[][]= new int[m][n];
        int array2[][]= new int[m][n];
        System.out.println("Enter the element of first matrix: ");
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) array1[i][j]=scan.nextInt();
        }
        System.out.println("Enter the element of second matrix: ");
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) array2[i][j]=scan.nextInt();
        }
        System.out.println("Result of the additon:");
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                System.out.print((array1[i][j]+array2[i][j])+"\t");
            }
            System.out.println();    
        }
    }
    
}
