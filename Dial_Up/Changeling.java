
/*  A Changeling is a mutant of a string, where some of its characters have been modified to their roommates
 *  This includes the original string as well, since every character is its own roommate
 * 
 *  This class acts mostly as a static library of functions related to changelings,
 *  as it is impossible to extend a class from String, which is the core ancestor of a Changeling
 * 
 *  Alternatively, strings can be passed to arguments in any of the functions that need them
 */

import Exceptions.*;

public class Changeling {
    // Every element of the following array represents a room with roommate
    // characters:

    private static char[][] dataTable = new char[][] {
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
    };

    public static char[] roomMatesOf(char x) throws CharacterNotInTableException {
        if (x >= '2' && x <= '9') {
            return dataTable[(int)(x - 48 - 2)];
        }

        for (int i = 0; i < dataTable.length; i++) {
            for (char c : dataTable[i]) {
                if (x == c) {
                    return dataTable[i];
                }
            }
        }

        throw new CharacterNotInTableException();
    }

    public static int countOfChangelings(String word) {
        int count = 1;
        for (int i = 0; i < word.length(); i++) {
            count *= (roomMatesOf(word.charAt(i))).length;
        }
        return count;
    }

    public static String[] nextChangelings(String[] words, int index) {
        String[] ans = new String[countOfChangelings(words[0])];
        for (int i = 0, j = 0; i < words.length; i++) {
            if (words[i] == null) {
                break;
            }
            String word = words[i];
            StringBuilder sb = new StringBuilder(word);
            for (char c : roomMatesOf(word.charAt(index))) {
                sb.setCharAt(index, c);
                ans[j] = sb.toString();
                j++;
            }
        }
        return ans;
    }

    public static String[] changelingList(String word) {
        String[][] allLines = new String[word.length() + 1][countOfChangelings(word)];
        allLines[0][0] = word;
        for (int i = 1; i < allLines.length; i++) {
            allLines[i] = nextChangelings(allLines[i - 1], i - 1);
        }
        return allLines[word.length()];
    }

    public static int countOfNumbersIn(String word) {
        int count = 0;
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] >= 2 && wordChars[i] <= '9') {
                count++;
            }
        }
        return count;
    }

    public static int[] numberIndicesOf(String word) {
        char[] wordChars = word.toCharArray();
        int[] numberIndices = new int[countOfNumbersIn(word)];

        for (int i = 0, j = 0; i < wordChars.length; i++) {
            if (wordChars[i] >= 2 && wordChars[i] <= '9') {
                numberIndices[j] = i;
                j++;
            }
        }

        return numberIndices;
    }

    public static String numbersIn(String word) {
        char[] wordChars = word.toCharArray();
        char[] numberArray = new char[countOfNumbersIn(word)];
        for (int i = 0, j = 0; i < wordChars.length; i++) {
            if (wordChars[i] >= 2 && wordChars[i] <= '9') {
                numberArray[j] = wordChars[i];
                j++;
            }
        }
        return new String(numberArray);
    }

    public static String modifiedNumbers(String word1, String word2) throws InvalidLengthException {
        int[] numberIndices = numberIndicesOf(word1);
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();

        if (numberIndices.length != word2Chars.length) {
            throw new InvalidLengthException();
        }

        int j = 0;
        for (int i : numberIndices) {
            word1Chars[i] = word2Chars[j];
            j++;
        }
        return new String(word1Chars);
    }

}
