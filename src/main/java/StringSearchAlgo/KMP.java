package StringSearchAlgo;

import java.util.Arrays;

public class KMP {

    public static void main(String[] arg){
        String s = "stringtomatchonions";
        String i = "onions";
        //LPS      [0,0,0,1,2,0]
        //          o n i o
        //          o n   o n
        //                    s

        System.out.println(Arrays.toString(new KMP().lps("aabaaac")));
    }

    //aabaaac
    //0101220 --> lps
    public int[] lps(String s){
        int l = 0;
        int[] lps = new int[s.length()];
        lps[0]  = 0;
        int i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(l)) {
                lps[i] = l+1;
                l++;
                i++;
            } else if(l == 0){
                lps[i] = 0;
                i++;
            } else {
                l = lps[l - 1];
            }
        }
        return lps;
    }


    //s = onionionsky
    //sub = onions
    public boolean regex(String s, String sub){
        int[] lps = lps(sub);
        int i = 0;
        int j = 0;
        while (j < s.length() && i < sub.length()){
            if(s.charAt(j) == s.charAt(i)){
                i++;
                j++;
            } else if(i == 0){
                j++;
            } else {
                i = lps[i -1];
            }
        }

        return (i == sub.length()) ;

    }
}
