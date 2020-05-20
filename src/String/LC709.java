package String;

/*
709. To Lower Case
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"

*/


public class LC709 {
    public String toLowerCase(String str) {
        StringBuilder result = new StringBuilder();
        for(char letter: str.toCharArray()){
            if(letter >= 65 && letter <= 90) {
                result.append((char)(letter + 32));
            } else {
                result.append(letter);
            }

        }
        return result.toString();
    }
}
