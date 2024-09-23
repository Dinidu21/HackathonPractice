package ConceptPractice.dp.tabulation;

import java.util.Scanner;

public class TribonacciTabulation {
    public static int trib(int n){
        if(n == 0 || n == 1 ){
            return 0;
        }

        if (n == 2){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <=n ; i++) {
            dp [i] = dp[i-1] + dp [i-2] +dp [i-3];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number  : ");
        int num = sc.nextInt();
        int result = trib(num);
        System.out.println("Num : "+num+" Result : "+result);
    }
}
