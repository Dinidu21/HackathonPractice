package ConceptPractice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaxPathSumProblemMemoization {
        //Dynamic Programming Approach

        public static int maxPath (List<List<Integer>> grid){
            return (int) maxPath(0,0,grid,new HashMap<>());
        }
        public static double maxPath (int r,int c , List<List<Integer>> grid,HashMap<List<Integer>,Double>memo){
            if(r == grid.size() || c == grid.get(0).size()){
                return Double.NEGATIVE_INFINITY;
            }

            if(r==grid.size() - 1 && c == grid.get(0).size() - 1){
                return grid.get(r).get(c);
            }
            List<Integer> pos = List.of(r,c);

            if(memo.containsKey(pos)){
                return memo.get(pos);
            }

            double result = grid.get(r).get(c) + Math.max(
                    maxPath(r + 1,c,grid,memo),
                    maxPath(r,c+1,grid,memo));

            memo.put(pos,result);
            return result;
        }

        public static void main(String[] args) {
            List<List<Integer>> grid = new ArrayList<>();

            grid.add(Arrays.asList(1,3,12));
            grid.add(Arrays.asList(5,6,2));

            int result = maxPath(grid);
            System.out.println("Number of possible paths: " + result);

        }
    }

