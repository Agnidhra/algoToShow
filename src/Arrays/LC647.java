package Arrays;

/*
647. Palindromic Substrings

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

public class LC647 {
    public int countSubstrings(String s) {
        int numberOfPalindrome = 0;
        char[] input = s.toCharArray();
        for(int i =0; i<s.length(); i++){
            numberOfPalindrome += countPalindrome(input, i, i);
            numberOfPalindrome += countPalindrome(input, i, i+1);
        }
        return numberOfPalindrome;
    }

    public int countPalindrome(char[] input, int firstIndex, int lastIndex) {
        int numberOfPalindrome = 0;
        while(firstIndex >=0 && lastIndex<= input.length-1 && input[firstIndex] == input[lastIndex]) {
            numberOfPalindrome++;
            firstIndex--;
            lastIndex++;
        }
        return numberOfPalindrome;
    }
}
