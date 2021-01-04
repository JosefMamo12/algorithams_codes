// All the greedy algorithms on strings.
public class Greedy {
    public static String lcs (String s1 , String s2){//O(n*m)
        int start = 0;
        String ans = " ";
        for (int i = 0; i < s1.length(); i++) {
            int result = s2.indexOf(s1.charAt(i),start);
            if(result!=-1){
                ans+= s1.charAt(i);
                start = result + 1;
            }

        }
        return ans;
    }
    public static String lcs2 (String s1, String s2){
        int start = 0;
        int [] arr = new int [26];
        String ans = " ";
        for (int i = 0; i < s1.length(); i++) {
            char letter = s1.charAt(i);
            arr[letter - 'a']++;
        }
        for (int i = 0; i <s2.length(); i++) {
            char letter = s2.charAt(i);
            if(arr[letter -'a'] > 0){
                int index = s1.indexOf(s2.charAt(i),start);
                start = index + 1;
                ans+= letter;
                arr[letter -'a']--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abbbvde";
        String s2 = "bvde";
        System.out.println(lcs2(s1,s2));
    }
}

