package leetcode.hard;

/**
 * 995. Minimum Number of K Consecutive Bit Flips
 * In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of length K and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.
 * <p>
 * Return the minimum number of K-bit flips required so that there is no 0 in the array.  If it is not possible, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: A = [0,1,0], K = 1
 * Output: 2
 * Explanation: Flip A[0], then flip A[2].
 * Example 2:
 * <p>
 * Input: A = [1,1,0], K = 2
 * Output: -1
 * Explanation: No matter how we flip subarrays of size 2, we can't make the array become [1,1,1].
 * Example 3:
 * <p>
 * Input: A = [0,0,0,1,0,1,1,0], K = 3
 * Output: 3
 * Explanation:
 * Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
 * Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
 * Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 30000
 * 1 <= K <= A.length
 */
public class MinNumberOfKConsecutiveBitFlips {

    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int count = 0;
        int[] flipped = new int[n];
        int slidingFlipCount = 0;
        for (int i = 0; i < n; i++) {
            if (i >= K) slidingFlipCount -= flipped[i - K]; // Remove the first flip to add the new one <-[...]<-
            if (slidingFlipCount % 2 == A[i]) {
                if (i + K > n) return -1; // Not possible
                flipped[i] = 1;
                count++;
                slidingFlipCount++;
            }
        }
        return count;
    }

}
