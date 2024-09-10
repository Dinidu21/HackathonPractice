package ConceptPractice.dp;

import java.util.HashMap;
import java.util.Scanner;

public class TribonacciMemoization {
    //Dynamic Programming applied

    public static int trib(int n){
        return trib(n,new HashMap<>());
    }

    public static int trib(int n, HashMap<Integer,Integer> memo){
        if(n == 0 || n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(memo.containsKey(n)){
            return  memo.get(n);
        }

        int result =  trib(n - 1 ,memo) +trib( n - 2,memo) + trib( n - 3,memo);
        memo.put(n,result);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number : ");
        int num = sc.nextInt();
        int result = trib(num);
        System.out.println("Result : "+result);
    }
}
