package leetcode.companies.amazon;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 909. Snakes and Ladders
 * On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating direction each row.  For example, for a 6 x 6 board, the numbers are written as follows:
 *
 * You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:
 *
 * You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
 * (This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations, regardless of the size of the board.)
 * If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
 * A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].
 *
 * Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)
 *
 * Return the least number of moves required to reach square N*N.  If it is not possible, return -1.
 *
 * Example 1:
 *
 * Input: [
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,35,-1,-1,13,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,15,-1,-1,-1,-1]]
 * Output: 4
 * Explanation:
 * At the beginning, you start at square 1 [at row 5, column 0].
 * You decide to move to square 2, and must take the ladder to square 15.
 * You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
 * You then decide to move to square 14, and must take the ladder to square 35.
 * You then decide to move to square 36, ending the game.
 * It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
 * Note:
 *
 * 2 <= board.length = board[0].length <= 20
 * board[i][j] is between 1 and N*N or is equal to -1.
 * The board square with number 1 has no snake or ladder.
 * The board square with number N*N has no snake or ladder.
 */
public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, Integer> disMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        disMap.put(1, 0);
        int nSquare = n * n;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == nSquare) return disMap.get(curr);
            for (int a = curr + 1; a <= Math.min(curr + 6, nSquare); a++) {
                Pair<Integer, Integer> rowCol = getRowCol(a, n);
                int newCurr = board[rowCol.getKey()][rowCol.getValue()] == -1 ? a : board[rowCol.getKey()][rowCol.getValue()];
                if (!disMap.containsKey(newCurr)) {
                    disMap.put(newCurr, disMap.get(curr) + 1);
                    q.add(newCurr);
                }
            }
        }
        return -1;
    }

    private Pair<Integer, Integer> getRowCol(int a, int n) {
        int q = (a - 1) / n;
        int rem = (a - 1) % n;
        int row = n - 1 - q;
        int col = row % 2 == n % 2 ? n - 1 - rem : rem;
        return new Pair<>(row, col);
    }

}
