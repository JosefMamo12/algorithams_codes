

public class MinMaxProblems {
    /**
     * minMax problem this algorithm is an algorithm which compare between two pairs
     * the main issue of this algorithm is the time complexity which is improved O(n)
     * 3 of n elements divided by 2 .
     *
     * @param arr
     * @return
     */

    public static int[] returnMinAndMax(int[] arr) {
        int[] ans = new int[2];
        int[] indexAns = new int[2];
        int max = arr[0], min = arr[1], indexMin = 1, indexMax = 0, comperssions = 0;
        if (max < min) {
            comperssions++;
            max = arr[1];
            min = arr[0];
            indexMin = 0;
            indexMax = 1;
        }
        for (int i = 2; i < arr.length - 1; i += 2) {
            comperssions++;
            if (arr[i] < arr[i + 1]) {
                comperssions+=2;
                if (arr[i] < min) {
                    min = arr[i];
                    indexMin = i;
                }
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                    indexMax = i + 1;
                }
            } else {
                comperssions+=2;
                if (arr[i] > max) {
                    max = arr[i];
                    indexMax = i;
                }
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                    indexMin = i + 1;
                }
            }
        }
        if (arr.length % 2 != 0) {
            comperssions++;
            if (arr[arr.length - 1] < min) {
                min = arr[arr.length - 1];
                indexMin = arr.length - 1;
            }
            else{
                comperssions++;
            if (arr[arr.length - 1] > max) {
                max = arr[arr.length - 1];
                indexMax = arr.length - 1;
            }
            }
        }
        ans[0] = min;
        ans[1] = max;
        indexAns[0] = indexMin;
        indexAns[1] = indexMax;
        System.out.println("Comperssions: "+comperssions);
        for (int i:indexAns) {
            System.out.print(i+" ");
        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        int arr [] = new int[10000000];
        for (int i=0;i<arr.length;i++) {
            int rand = (int) (Math.random() * arr.length) + 1;
            arr[i] = rand;
        }
        System.out.println();
        int [] ans = new int [2];
        ans = returnMinAndMax(arr);
        for (int i = 0; i < ans.length ; i++) {
            System.out.print(ans[i]+ " ");
        }
    }

}
