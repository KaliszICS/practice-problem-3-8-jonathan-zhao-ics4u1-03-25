import java.util.*;
public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int fib(int num) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return fibHelper(map, num);
	}

	public static int fibHelper(HashMap<Integer, Integer> map, int num) {

		
		if (num == 0) {
			return 0;
		}

		if (num == 1) {
			return 1;
		}
		
		if (map.containsKey(num)) {
			return map.get(num);
		}


		int value = fibHelper(map, num -1) + fibHelper(map, num - 2);

		//add to map
		map.put(num, value);

		//return
		return value;
	}

	public static int minCostClimbingStairs(int[] cost) {
		HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>(); 
		int c = cost.length;
		if (c == 1) {
			return cost[0];
		}
		return Math.min(minCost(c - 1, cost, memo), minCost(c - 2, cost, memo));
	}	

	public static int minCost(int i, int[] cost, HashMap<Integer, Integer> memo) {
		if (i < 0) {
			return 0;
		}
		
		if (i == 0 || i == 1) {
			return cost[i];
		}

		if (memo.containsKey(i)) {
			return memo.get(i);
		}

		int result = cost[i] + Math.min(minCost(i - 1, cost, memo), minCost(i - 2, cost, memo));
		memo.put(i, result);
		return result;
	}
}