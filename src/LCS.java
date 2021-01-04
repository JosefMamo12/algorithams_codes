import java.util.Stack;

public class LCS {
    private static int[][] array;

    /**
     * Dynamic algoritham which exmaine the longest common subsequence
     * the time complexity of this algoritham is O(n*m)(check the all the charcters of one string with all charcters
     * of the second string).
     *
     * @param x
     * @param y
     * @return int
     */
    public static int lcs(String x, String y) {
        int xRunner = 0, yRunner = 0;
        array = new int[x.length() + 1][y.length() + 1];

        for (int i = 1; i < array.length; i++) {
            yRunner = 0;
            for (int j = 1; j < array[0].length; j++) {
                if (x.charAt(xRunner) == y.charAt(yRunner)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                yRunner++;
            }
            xRunner++;

        }
        return array[array.length - 1][array[0].length - 1];
    }

    /**
     * TimeComplexity of print the lcs is O(m+n)
     * by retrivaling back..
     * @param x
     * @param y
     * @return String
     */
    public static String printLcs(String x, String y) {
        String ans = " ";
        int i = x.length() , j = y.length();
        Stack<Character> st = new Stack<>();
        int lcsCounter = lcs(x, y);

        while (lcsCounter > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                st.push(x.charAt(i-1));
                i--;
                j--;
                lcsCounter = array[i][j];
            } else {
                if (array[i - 1][j] > array[i][j - 1]) {
                    i--;
                    lcsCounter = array[i][j];
                } else {
                    j--;
                    lcsCounter = array[i][j];
                }
            }
        }
        while(!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String x = "pizza";
        String y = "pastaccccp";
        System.out.println(printLcs(x, y));
    }
}
