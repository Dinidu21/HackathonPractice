package ConceptPractice.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NonAdjacentSumMemoization {
        //Dynamic Programming Approach
        private static int nonAdjecentSum(List<Integer> nums) {
            return nonAdjecentSum(nums,0,new HashMap<>());
        }
        private static int nonAdjecentSum(List<Integer> nums,int i,HashMap<Integer,Integer>memo) {
            if(i >= nums.size()){
                return 0; //if is i more than array size
            }
            if(memo.containsKey(i)){
                return memo.get(i);
            }
            int result = Math.max(nums.get(i)+nonAdjecentSum(nums,i + 2,memo),
                    nonAdjecentSum(nums,i + 1,memo));
            memo.put(i,result);
            return result;

        }

        public static void main(String[] args) {
            List<Integer> nums = Arrays.asList(2,4,5,12,7,12,5,6,8,2,9,2,9,2,87,3,8,4,
                    8,2,9,5,4,8,5,8,8,51,8,9,5,5,0,9,9,0,2,4,5,12,7,
                    12,5,6,8,2,9,2,9,2,87,3,8,4,8,2,9,5,4,8,5,8,8,51,
                    8,9,5,5,0,2,4,5,12,7,12,5,6,8,2,9,2,9,2,87,3,8,4
                    ,8,2,9,5,4,8,5,8,8,51,8,9,5,5,0,2,4,5,12,7,12,5,
                    6,8,2,9,2,9,2,87,3,8,4,8,2,9,5,4,8,5,8,8,51,8,9,5
                    ,5,0,2,4,5,12,7,12,5,6,8,2,9,2,9,2,87,3,8,4,8,5,
                    2,9,5,4,8,5,8,8,51,8,9,5,5,0,2,4,5,12,7,12,5,6
                    ,8,2,9,2,9,2,87,3,8,4,8,2,9,5,4,8,5,8,8,51,8,5,
                    9,5,5,0,2,4,5,12,7,12,5,6,8,2,9,2,9,2,87,3,8,4,8
                    ,2,9,5,4,8,5,8,8,51,8,9,5,5,0,2,4,5,12,7,12,5,6,8,2,9,
                    2,9,2,87,3,8,4,8,2,9,5,4,8,5,8,8,51,8,9,5,5,0,2,4,5,12,7,
                    12,5,6,8,2,9,2,9,2,87,3,8,4,8,2,9,5,4,8,5,8,8,51,8,9,5,5,0,2
                    ,4,5,12,7,12,5,6,8,2,9,2,9,2,87,3,8,4,8,2,9,5,4,8,5,8,8,51,8,9,5,5,0);

            System.out.println("arrays Size : "+nums.size());
            int result = nonAdjecentSum(nums);
            System.out.println("Non Adjacent Sum is : " + result);
        }
    }


