import java.util.Arrays;

public class Fiboonachi {
    /*
    fibonachi is a special sequeuence which each number is the sum of  two numbers before.
    for example  1,1,2,3,5,8,13,21.....
     */
    //induction : time Complexity O(n)
    public static int [] fiboonachi (int n){
        int [] ans = new int [n];
        int first = 1 ,  second = 1 , sum;
        ans[0] = first;
        ans [1] = second;
        for (int  i = 2;  i < n;  i++) {
            sum = first + second;
            ans[i] = sum;
            first = second ;
            second = sum;

        }
        return ans;
    }
    //recursion Time Complexity : O(2^n)
    public static int recursionFibonacci(int n){
       if(n<=1)
           return n;
        return recursionFibonacci(n-1)+recursionFibonacci(n-2);
    }


    public static void main(String[] args) {
        int [] arr = new int [44];
        arr = fiboonachi(44);
        System.out.println(Arrays.toString(arr));
        int recurseian_answer = recursionFibonacci(44);
        System.out.println(recurseian_answer);
    }
}

