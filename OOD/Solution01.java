/*
 * Complete the function below.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static String stemmer(String inputTerms) {
        
        String l = stemmer1(inputTerms);
        String s = stemmer2(inputTerms);
        if(s.length() == 0)
            return l;
        if(l.length() - s.length() == 2) {
            return l;
        }
        return s;
    }
    
    static String stemmer2(String inputTerms) {
        String[] input = inputTerms.split(" ");
        String result = input[0];
        for (int i = 0; i < input.length; i++) {
            String first = input[i];
            for (int j = i + 1; j < input.length; j++) {
                String second = input[j];
                String temp;
                for (int k = 0; k <= first.length(); k++) {
                    if(!second.contains(first.substring(0, k))) {
                        temp = (String)first.substring(0, k - 1);
                        if(temp.length() < result.length())
                            result = temp;
                        break;
                    }
                }
            }
        }
        
        return result;
        
    }
    static String stemmer1(String inputTerms) {
        String[] input = inputTerms.split(" ");
        String result = "";
        for (int i = 0; i < input.length; i++) {
            String first = input[i];
            for (int j = i + 1; j < input.length; j++) {
                String second = input[j];
                for(int k = first.length(); k >= 0; k--) {
                    if(second.contains(first.substring(0, k))) {
                        if(k > result.length())
                            result = (String)first.substring(0, k);
                    }
                }
            }
        }
        return result;
    }
    
}


