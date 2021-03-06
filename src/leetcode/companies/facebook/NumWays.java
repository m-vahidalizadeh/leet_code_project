package leetcode.companies.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * 1269. Number of Ways to Stay in the Same Place After Some Steps
 * You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position to the right in the array or stay in the same place  (The pointer should not be placed outside the array at any time).
 *
 * Given two integers steps and arrLen, return the number of ways such that your pointer still at index 0 after exactly steps steps.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 *
 * Input: steps = 3, arrLen = 2
 * Output: 4
 * Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
 * Right, Left, Stay
 * Stay, Right, Left
 * Right, Stay, Left
 * Stay, Stay, Stay
 * Example 2:
 *
 * Input: steps = 2, arrLen = 4
 * Output: 2
 * Explanation: There are 2 differents ways to stay at index 0 after 2 steps
 * Right, Left
 * Stay, Stay
 * Example 3:
 *
 * Input: steps = 4, arrLen = 2
 * Output: 8
 *
 * Constraints:
 *
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 */
public class NumWays {

    int n;
    Map<String, Integer> cache;

    public int numWays(int steps, int arrLen) {
        n = arrLen;
        cache = new HashMap<>();
        return dfs(0, steps);
    }

    private int dfs(int currPos, int remSteps) {
        if (currPos < 0 || currPos >= n || currPos > remSteps) return 0;
        if (remSteps == 0) return currPos == 0 ? 1 : 0;
        String key = currPos + "," + remSteps;
        if (cache.containsKey(key)) return cache.get(key);
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            sum = (sum + dfs(currPos + i, remSteps - 1)) % 1_000_000_007;
        }
        cache.put(key, sum);
        return sum;
    }

}
