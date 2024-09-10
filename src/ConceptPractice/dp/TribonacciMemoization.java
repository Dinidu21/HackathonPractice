package ConceptPractice.dp;

import java.util.Scanner;

public class TribonacciMemoization {
    //Bruteforce method


    public static int trib(int n){
        if(n == 0 || n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return trib(n - 1) +trib( n - 2) + trib( n - 3);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number : ");
        int num = sc.nextInt();
        int result = trib(num);
        System.out.println("Result : "+result);
    }
}
