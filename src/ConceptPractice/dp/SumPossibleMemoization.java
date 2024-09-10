package ConceptPractice.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SumPossibleMemoization {
    //Dynamic Programming Approach
    public static boolean sumPossible(int amount , List <Integer> arr) {
        return sumPossible(amount,arr,new HashMap<>());

    }
    public static boolean sumPossible(int amount , List <Integer> arr, HashMap <Integer,Boolean> memo) {
        if (amount == 0){
            return true;
        }

        if(amount < 0){
            return false;
        }
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }

        for(int num : arr){
            int subAmount = amount - num;
            if(sumPossible(subAmount,arr,memo)){
                memo.put(subAmount,true);
                return true;
            }
        }
        memo.put(amount,false);
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();

        System.out.print("Enter list of space-separated integers: ");
        String n = sc.nextLine();

        String[] nums = n.split(" ");

        for (String num : nums) {
            arr.add(Integer.parseInt(num));
        }

        System.out.println("List: " + arr);

        System.out.print("Enter the target sum: ");
        int targetSum = sc.nextInt();

        boolean value = sumPossible(targetSum,arr);
        System.out.println("Is sum possible: " + value);
    }
}