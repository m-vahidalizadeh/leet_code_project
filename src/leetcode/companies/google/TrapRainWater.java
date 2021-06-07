package leetcode.companies.google;

/**
 * 42. Trapping Rain Water
 * Hard
 *
 * 11685
 *
 * 170
 *
 * Add to List
 *
 * Share
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class TrapRainWater {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            int temp = Math.min(maxLeft[i - 1], maxRight[i + 1]) - height[i];
            if (temp > 0) water += temp;
        }
        return water;
    }

}
