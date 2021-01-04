import java.util.Arrays;
import java.util.Stack;
/*
Time Complexity : O(n-1 + log n);
 */
public class Max1Max2BestSolution {
    static class Node {
        int key;
        Stack<Integer> st;

        public Node(int i) {
            this.key = i;
            st = new Stack<>();
        }

        public int getKey() {
            return this.key;
        }


    }


    public static int maxMax2(int[] arr) {
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }

        int index = maxMax2(nodes, 0, nodes.length - 1);
        int maxMax1 = nodes[index].getKey();
        int max2 = 0, temp;
        while (!nodes[index].st.isEmpty()) {
            temp = nodes[index].st.pop();
            if (temp > max2) {
                max2 = temp;
            }
        }
        System.out.println("Max2:"+max2);
        System.out.print("Max1:");
        return maxMax1;
    }

    private static int maxMax2(Node[] nodes, int low, int high) {
        if (low < high) {
            int index = 0;
            int middle = (low + high) / 2;
            int i = maxMax2(nodes, low, middle);
            int j = maxMax2(nodes, middle + 1, high);
            if (nodes[i].getKey() > nodes[j].getKey()) {
                nodes[i].st.add(nodes[j].getKey());
                index = i;
            } else {
                nodes[j].st.add(nodes[i].getKey());
                index = j;

            }
            return index;
        } else
            return low;
    }




    public static void main(String[] args) {
        int arr[] = new int[8];
        for (int i = 0; i < arr.length; i++) {
            int rand = (int) (Math.random() * arr.length) + 1;
            arr[i] = rand;
        }
        System.out.println(Arrays.toString(arr));
        int max = maxMax2(arr);
        System.out.println(max);

    }
}

