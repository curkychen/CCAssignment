package yu;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * 
 * @author zhengyu
 *
 */

public class test {

        static String levenshteinDistance(String misspelledWord,
            String[] dictionaryWords) {
        String result = "0";
        int distance = -1;
        for (int i = 0; i < dictionaryWords.length; i++) {
            int temp = editdistance(misspelledWord, dictionaryWords[i]);
            if (distance == -1) {
                distance = temp;
                result = dictionaryWords[i];
            }
            if (temp < distance) {
                distance = temp;
                result = dictionaryWords[i];
            }
        }
        return distance + "," + result;
    }

    static int editdistance(String longstring, String shortstring) {
        if (longstring.equals(shortstring))
            return 0;
        if (shortstring.length() == 0)
            return longstring.length();
        if (longstring.length() == 0)
            return shortstring.length();

        int[] longform = new int[shortstring.length() + 1];
        int[] shortform = new int[shortstring.length() + 1];

        for (int i = 0; i < longform.length; i++)
            longform[i] = i;
        for (int i = 0; i < longstring.length(); i++) {
            shortform[0] = i + 1;
            
            for (int j = 0; j < shortstring.length(); j++) {
                int cost = 1;
                if(longstring.charAt(i) == shortstring.charAt(j))
                    cost = 0;
                shortform[j + 1] = min(longform[j] + cost, shortform[j] + 1,
                        longform[j + 1] + 1);
            }
            
            for (int j = 0; j < longform.length; j++) {
                longform[j] = shortform[j];
            }
        }
        return shortform[shortstring.length()];
    }
    
    static int min(int a, int b, int c) {
        int d = Math.min(a, b);
        return Math.min(d, c);
    }

}