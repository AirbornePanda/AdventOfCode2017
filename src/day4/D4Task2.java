package day4;

import util.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class D4Task2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final long startTime = System.currentTimeMillis();
        List<String> input = InputReader.readInputToLArrayList("day4/input");
        final long readerEnd = System.currentTimeMillis();

        Integer validLines = 0;

        for (String line: input){
            final List<String> words = new ArrayList<>(Arrays.asList(line.trim().split("\\s+")));
            final Map<String, Integer> map = new HashMap<>();
            Boolean found = false;
            for (String word: words) {
                if(!map.containsKey(word)) map.put(word, null);
                else {
                    found = true;
                    break;
                }
            }
            if(found) continue;

            //Going forward with the hashmap, because it wont' have duplicates
            for (String word: map.keySet()){
                final List<String> checkList = new ArrayList<>(map.keySet());
                checkList.remove(word);
                for (String w: checkList){
                    if (w.length() != word.length()) continue;
                    if(isAnagram(w, word)) {
                        found = true;
                        break;
                    }
                }

            }

            if(!found) validLines++;
        }

        final long calcEnd = System.currentTimeMillis();

        System.out.println("Valid lines: " + validLines);
        System.out.println();
        System.out.println("Process took: " + (calcEnd - startTime) + "ms");
        System.out.println("With the following tasks");
        System.out.println();
        System.out.println("Filereader: " + (readerEnd - startTime) + "ms");
        System.out.println("Calculation: " + (calcEnd - readerEnd) + "ms");

    }

    private static Boolean isAnagram (String word1, String word2){
        Map<String, Integer> w1Map = wordMap(word1);
        Map<String, Integer> w2Map = wordMap(word2);
        Boolean isAnagram = true;

        for (String key: w1Map.keySet()){
            if (!(w2Map.containsKey(key) && w1Map.get(key).equals(w2Map.get(key)))) isAnagram = false;
        }

        return isAnagram;
    }

    //Makes a Map from a string.
    //It maps all strings as keys and number of occurrences as value.
    private static Map<String, Integer> wordMap (final String word){
        Map<String, Integer> charMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++){
            try {
                if(charMap.containsKey(String.valueOf(word.charAt(i)))) charMap.replace(String.valueOf(word.charAt(i)), charMap.get(String.valueOf(word.charAt(i))) + 1);
                else charMap.put(String.valueOf(word.charAt(i)), 1);
            } catch (Exception e) {
                System.out.println(word);
            }

        }

        return charMap;
    }
}
