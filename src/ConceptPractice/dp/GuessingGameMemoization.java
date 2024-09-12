package ConceptPractice.dp;

import java.util.HashMap;

public class GuessingGameMemoization {
    //Dynamic Programming Approach
    public static int minSum(int n) {
        return calculateCost(1, n, new HashMap<>());
    }

    private static int calculateCost(int start, int end, HashMap<String, Integer> memo) {
        int minCost = Integer.MAX_VALUE;

        if (start >= end) {
            return 0;
        }

        String key = start + "," + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        for (int i = start; i <= end; i++) {
            int costIfGuessI = i + Math.max(calculateCost(start, i - 1, memo), calculateCost(i + 1, end,memo));
            //System.out.println(costIfGuessI);
            minCost = Math.min(minCost, costIfGuessI);
        }

        memo.put(key, minCost);
        return minCost;
    }

    public static void main(String[] args) {
        int n =  10;
        int result = minSum(n);
        System.out.println(result);
    }
}
