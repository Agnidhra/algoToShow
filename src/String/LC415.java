package String;

/*
415. Add Strings
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class LC415 {
    public String addStrings(String num1, String num2) {
        int length1 = num1.length()-1;
        int length2 = num2.length()-1;
        int carry = 0;
        StringBuilder output = new StringBuilder();
        while(length1 >=0 || length2 >=0) {
            if(length1 >=0 && length2 >=0) {
                output.insert(0,((num1.charAt(length1) - '0') + (num2.charAt(length2)-'0') + carry)%10);
                carry = ((num1.charAt(length1) - '0') + (num2.charAt(length2)-'0') + carry)/10;
            } else if(length1 >=0) {
                output.insert(0,((num1.charAt(length1) - '0') + carry)%10);
                carry = ((num1.charAt(length1) - '0') + carry)/10;
            } else if(length2 >=0) {
                output.insert(0,((num2.charAt(length2) - '0') + carry)%10);
                carry = ((num2.charAt(length2) - '0') + carry)/10;
            }
            length1--;
            length2--;
        }
        if(carry != 0) {
            output.insert(0, carry);
        }
        return output.toString();
    }
}
