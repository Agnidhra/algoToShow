package String;

/*
434. Number of Segments in a String

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
*/

public class LC434 {
    public int countSegments(String s) {
        if(s.trim().length() == 0 || s == null) {
            return 0;
        }
        int segmentCount = 0;
        boolean previousSpace = false;
        for(char letter: s.trim().toCharArray()) {
            if(letter == ' ' && !previousSpace){
                segmentCount++;
                previousSpace = true;
            } else if (letter != ' ') {
                previousSpace = false;
            }
        }
        segmentCount++;
        return segmentCount;
    }
}
