public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0)     return 0;
        
        int ans = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                // 若j到B末端到距离≤ans,则不必继续了
                if (B.length() - j + 1 <= ans) {
                    break;
                }
                
                if (A.charAt(i) == B.charAt(j)) {
                    int curAns = 0;
                    while (i + curAns < A.length() &&
                           j + curAns < B.length() &&
                           A.charAt(i + curAns) == B.charAt(j + curAns)) {
                        curAns++;
                    }
                    ans = Math.max(ans, curAns);
                }
            }
        }
        
        return ans;
    }
}
