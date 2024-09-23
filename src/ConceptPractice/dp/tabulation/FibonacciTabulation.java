package ConceptPractice.dp.tabulation;
import java.util.Scanner;

public class FibonacciTabulation {
    private static int fib(int n) {

        if(n ==0 ||n == 1){return n;}

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number  : ");
        int num = sc.nextInt();
        int result = fib(num);
        System.out.println("Num : "+num+" Result : "+result);

    }
}


