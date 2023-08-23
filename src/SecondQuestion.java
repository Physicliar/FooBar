/**
 * As a henchman on Commander Lambda's space station, you're expected to be resourceful, smart, and a quick thinker.
 * It's not easy building a doomsday device and ordering the bunnies around at the same time, after all! In order to
 * make sure that everyone is sufficiently quick-witted, Commander Lambda has installed new flooring outside
 * the henchman dormitories. It looks like a chessboard, and every morning and evening you have to solve a new movement
 * puzzle in order to cross the floor. That would be fine if you got to be the rook or the queen, but instead, you have
 * to be the knight. Worse, if you take too much time solving the puzzle, you get "volunteered" as a test subject for
 * the LAMBCHOP doomsday device!
 * <p>
 * To help yourself get to and from your bunk every day, write a function called solution(src, dest) which takes in two
 * parameters: the source square, on which you start, and the destination square, which is where you need to land to
 * solve the puzzle.  The function should return an integer representing the smallest number of moves it will take for
 * you to travel from the source square to the destination square using a chess knight's moves (that is, two squares in
 * any direction immediately followed by one square perpendicular to that direction, or vice versa, in an "L" shape).
 * Both the source and destination squares will be an integer between 0 and 63, inclusive, and are numbered like the
 * example chessboard below:
 * <p>
 * -------------------------
 * | 0| 1| 2| 3| 4| 5| 6| 7| <p>
 * -------------------------
 * | 8| 9|10|11|12|13|14|15| <p>
 * -------------------------
 * |16|17|18|19|20|21|22|23| <p>
 * -------------------------
 * |24|25|26|27|28|29|30|31| <p>
 * -------------------------
 * |32|33|34|35|36|37|38|39| <p>
 * -------------------------
 * |40|41|42|43|44|45|46|47| <p>
 * -------------------------
 * |48|49|50|51|52|53|54|55| <p>
 * -------------------------
 * |56|57|58|59|60|61|62|63| <p>
 * -------------------------
 * <p>
 * Languages
 * =========
 * <p>
 * To provide a Java solution, edit Solution.java
 * <p>
 * Test cases
 * ==========
 * Your code should pass the following test cases.
 * Note that it may also be run against hidden test cases not shown here.
 * -- Java cases --
 * Input:
 * Solution.solution(19, 36)
 * Output:
 * 1
 * <p>
 * Input:
 * Solution.solution(0, 1)
 * Output:
 * 3
 */
public class SecondQuestion {
    public static int solution(int src, int dest) {
        if (src == dest) {
            return 0; // Source and destination are the same
        }

        int boardSize = 8;
        int[] rows = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] cols = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] visited = new int[boardSize * boardSize];
        int[] queue = new int[boardSize * boardSize];
        int front = 0, rear = 0;
        queue[rear++] = src;
        visited[src] = 0;

        while (front < rear) {
            int curr = queue[front++];
            int row = curr / boardSize;
            int col = curr % boardSize;

            for (int i = 0; i < 8; i++) {
                int newRow = row + rows[i];
                int newCol = col + cols[i];
                int newSquare = newRow * boardSize + newCol;
                if (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize && visited[newSquare] == 0) {
                    if (newSquare == dest) {
                        return visited[curr] + 1;
                    }
                    visited[newSquare] = visited[curr] + 1;
                    queue[rear++] = newSquare;
                }
            }
        }

        return -1; // Destination not reachable
    }

}
