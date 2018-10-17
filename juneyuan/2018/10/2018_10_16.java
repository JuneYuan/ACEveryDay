public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (A == null || B == null)     return false;
        if (A.length() < B.length())    return false;
        
        int LETTER_CNT = 26;
        int[] charHash = new int[LETTER_CNT];
        for (int i = 0; i < A.length(); i++) {
            charHash[A.charAt(i) - 'A']++;
        }
        
        for (int i = 0; i < B.length(); i++) {
            charHash[B.charAt(i) - 'A']--;
            if (charHash[B.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}
