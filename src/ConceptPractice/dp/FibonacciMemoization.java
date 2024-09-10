package ConceptPractice.dp;

import java.util.HashMap;
import java.util.Scanner;


public class FibonacciMemoization  {
    public static int  fib(int n){
       return fib(n,new HashMap<>());
    }

    public static int  fib(int n,HashMap<Integer,Integer> memo){
        if(n ==0 ||n == 1){
            return n;
        }

        if(memo.containsKey(n)){
           return memo.get(n);
        }
        int result = fib(n - 1,memo) + fib(n - 2,memo);

        memo.put(n,result);

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number  : ");
        int num = sc.nextInt();
        int result = fib(num);
        System.out.println("Num : "+num+" Result : "+result);

    }
}
