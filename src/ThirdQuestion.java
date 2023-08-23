/**
 * 7
 * 3   6
 * 1 2 4 5
 * <p>
 * Write a function solution(h, q) - where h is the height of the perfect tree of converters and q is a list of positive
 * integers representing different flux converters - which returns a list of integers p where each element in p is the
 * label of the converter that sits on top of the respective converter in q, or -1 if there is no such converter.
 * For example, solution(3, [1, 4, 7]) would return the converters above the converters at indexes 1, 4, and 7 in a
 * perfect binary tree of height 3, which is [3, 6, -1].
 * <p>
 * The domain of the integer h is 1 <= h <= 30, where h = 1 represents a perfect binary tree containing only the root,
 * h = 2 represents a perfect binary tree with the root and two leaf nodes, h = 3 represents a perfect binary tree with
 * the root, two internal nodes and four leaf nodes (like the example above), and so forth.  The lists q and p contain at
 * least one but no more than 10000 distinct integers, all of which will be between 1 and 2^h-1, inclusive.
 * <p>
 * Input:
 * Solution.solution(5, {19, 14, 28})
 * Output:
 * 21,15,29
 * <p>
 * Input:
 * Solution.solution(3, {7, 3, 5, 1})
 * Output:
 * -1,7,6,3
 */
public class ThirdQuestion {
    public static int[] solution(int h, int[] q) {
        int[] parents = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int level = h - 1;
            int parent = (1 << h) - 1;
            int start = 1;

            if (parent == q[i]) {
                parents[i] = -1;
            }
            while (start <= parent) {
                int left = parent - (1 << level );
                int right = parent - 1;
                int mid = (start + parent) / 2;
                if (q[i] == left || q[i] == right) {
                    parents[i] = parent;
                    break;
                }

                if (mid > q[i]) {
                    parent = left;
                } else {
                    start = mid;
                    parent = right;
                }
                --level;
            }

        }
        return parents;
    }

}
