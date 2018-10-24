class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)     return false;
        if (s.length() != t.length())   return false;
        
        int CHAR_SIZE = 256;
        int[] letterCnt = new int[CHAR_SIZE];
        for (int i = 0; i < s.length(); i++) {
            letterCnt[s.charAt(i)]++;
            letterCnt[t.charAt(i)]--;
        }
        
        for (int i = 0; i < CHAR_SIZE; i++) {
            if (letterCnt[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
