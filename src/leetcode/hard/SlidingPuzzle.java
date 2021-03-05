package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 773. Sliding Puzzle
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 *
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 *
 * Examples:
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 *
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */
public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        int[] directions = new int[]{1, -1, 3, -3}; // right,left,down,up
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        Deque<String> q = new ArrayDeque<>();
        q.add(sb.toString());
        Set<String> visited = new HashSet<>();
        int move = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals("123450")) return move;
                visited.add(curr);
                int zeroIndex = curr.indexOf("0");
                for (int dir : directions) {
                    int newIndex = zeroIndex + dir;
                    if (newIndex < 0 || newIndex > 5 || (zeroIndex == 2 && dir == 1) || (zeroIndex == 3 && dir == -1))
                        continue;
                    sb = new StringBuilder(curr);
                    sb.setCharAt(zeroIndex, curr.charAt(newIndex));
                    sb.setCharAt(newIndex, curr.charAt(zeroIndex));
                    if (!visited.contains(sb.toString())) {
                        visited.add(sb.toString());
                        q.add(sb.toString());
                    }
                }
            }
            move++;
        }
        return -1;
    }

}
