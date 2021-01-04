import java.util.Arrays;

public class Max1Max2 {
    /*
    Max1>Max2 indexMax1 ASSSOCIATED WITH max1
     */
    public static void returnMax1Max2(int[] arr) {
        int max1 = arr[0], max2 = arr[1], indexMax1 = 0, indexMax2 = 1, compareator = 0;
        compareator++;
        if (max1 < max2) {
            max1 = arr[indexMax2];
            max2 = arr[indexMax1];
        }
        for (int i = 2; i < arr.length - 1; i += 2) {
            compareator++;
            if (arr[i] < arr[i + 1]) {
                compareator++;
                if (arr[i + 1] > max1) {
                    max2 = max1;
                    indexMax2 = indexMax1;
                    max1 = arr[i + 1];
                    indexMax1 = i + 1;
                    if (arr[i] > max2) {
                        max2 = arr[i];
                        indexMax2 = i;
                    }
                } else {
                    compareator++;
                    if (arr[i + 1] > max2) {
                        max2 = arr[i + 1];
                        indexMax2 = i + 1;
                    }
                }
            } else {
                compareator++;
                if (arr[i] > max1) {
                    max2 = max1;
                    indexMax2 = indexMax1;
                    indexMax1 = i;
                }
                compareator++;
                if (arr[i + 1] > max2) {
                    max2 = arr[i + 1];
                    indexMax2 = i + 1;
                }
            }

        }
        if (arr.length % 2 != 0) {
            compareator++;
            if (arr[arr.length - 1] > max1) {
                max2 = max1;
                indexMax2 = indexMax1;
                max1 = arr[arr.length - 1];
                indexMax1 = arr.length-1;
            }
            compareator++;
            if (arr[arr.length - 1] > max2) {
                max2 = arr[arr.length - 1];
                indexMax2 = arr.length-1;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Number of compares: "+ compareator);
        System.out.println("Max1:"+ max1 +", Max2:"+max2 + ", IndexMax1:"+ indexMax1+ ", IndexMax2:"+indexMax2);
    }

    public static void main(String[] args) {
        int arr [] = new int[10000000];
        for (int i=0;i<arr.length;i++) {
            int rand = (int) (Math.random() * arr.length) + 1;
            arr[i] = rand;
        }
        returnMax1Max2(arr);
    }
}
