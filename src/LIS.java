import java.util.Arrays;

public class LIS {
    public static int lis(int[] a) {
        int arrayRunner = 0;
        int sortedArrayRunner = 0;
        int size = a.length;
        int[] b = new int[size];
        for (int i = 0; i < size; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        int[][] dynamicArray = new int[size + 1][size + 1];

        for (int i = 1; i < dynamicArray.length; i++) {
            arrayRunner = 0;
            for (int j = 1; j < dynamicArray.length; j++) {
                if (a[arrayRunner] == b[sortedArrayRunner]) {
                    dynamicArray[i][j] = dynamicArray[i - 1][j - 1] + 1;
                } else
                    dynamicArray[i][j] = Math.max(dynamicArray[i - 1][j], dynamicArray[i][j - 1]);
                arrayRunner++;
            }
            sortedArrayRunner++;
        }
        return dynamicArray[size][size];
    }

    /**
     * TimeComplexity (n*logn)
     */
    public static int upgradedLis(int[] arr) {
        int j = 0, sizeHelpArr = 0;
        int[] helpArr = new int[arr.length];
        helpArr[j] = arr[j];
        sizeHelpArr++;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > helpArr[j]) {
                j++;
                helpArr[j] = arr[i];
                sizeHelpArr++;
            } else {
                while (j >= 0 && arr[i] < helpArr[j]) {
                    j--;
                }
                helpArr[j + 1] = arr[i];
                j = sizeHelpArr - 1;
            }

        }
        int counter = 0;
        while (helpArr[counter] < helpArr[counter + 1]) {
            counter++;
        }
        return counter + 1;
    }

    public static int[] bestLis(int[] arr) {
        int size = arr.length;
        int mat[][] = new int[size][size];
        mat[0][0] = arr[0];
        int currentLength = 0;

        for (int i = 1; i < size; i++) {
            int index = binarySearch(mat, currentLength, arr[i]);
            for (int j = 0; j < index; j++) {
                mat[index][j] = mat[index-1][j];
            }
            mat[index][index] = arr[i];
            if(index>currentLength)
                currentLength++;
        }
        int [] a = new int [currentLength+1];
        for (int i = 0; i < a.length ; i++) {
            a[i] = mat[currentLength][i];
        }
        return a;
    }

    private static int binarySearch(int[][] mat, int end, int key) {
        int left = 0;
        int right = end;
        int middle = 0;
        if (key < mat[0][0])
            return 0;
        if (key > mat[end][end])
            return end + 1;
        while (left < right - 1) {
            middle = (left + right) / 2;
            if (mat[middle][middle] < key)
                left = middle;
            else
                right = middle;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] array = {5 , 9, 4 ,20 ,23,24,25,27 ,22};
        int [] b = bestLis(array);
        System.out.println(Arrays.toString(b));
    }
}
