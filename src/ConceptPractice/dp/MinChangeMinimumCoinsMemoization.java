package ConceptPractice.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinChangeMinimumCoinsMemoization {
    //BruteForce Approach
    public static int minChangeProblem(int targetSum, List<Integer> arr) {
        if(targetSum == 0 ){
            return 0;
        }

        if (targetSum < 0){
            return -1;
        }

        int minCoins = -1;

        for (int coin :arr){
            int subAmount = targetSum - coin;
            int subCoins = minChangeProblem(subAmount,arr);
            if(subCoins != -1){
                int numCoins = subCoins+1;
                if(numCoins < minCoins || minCoins == -1){
                    minCoins =numCoins;

                }
            }
        }

        return minCoins;
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
        int result = minChangeProblem(targetSum,arr);
        System.out.println(result);

    }
}
