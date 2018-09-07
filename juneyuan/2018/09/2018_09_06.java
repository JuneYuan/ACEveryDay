class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        // TODO handle leading 0
        
        int n = S.length();
        for (int len0 = 1; len0 < S.length(); len0++) {
            for (int len1 = 1; len1 < S.length(); len1++) {
                if (len0 + len1 >= n)   break;
                int len2 = n - len0 - len1;
                if (len2 < Math.max(len0, len1))    break;
                
                if (helper(len0, len1, S))  return true;
            }
        }
        
        return false;
    }
    
    private boolean helper(int len0, int len1, String S) {
        String s0 = S.substring(0, len0), s1 = S.substring(len0, len0 + len1);
        
        int sum = 0, totalLen = len0;

        boolean lenNotExceed = totalLen <= S.length();
        boolean currMatch = true;
        do {
            sum = Integer.valueOf(s0) + Integer.valueOf(s1);
            s0 = s1;
            s1 = Integer.toString(sum);
            
            totalLen += 
            lenNotEx
        } while (lenNotExceed && currMatch);
        
        boolean lenNotExceed = totalLen <= S.length();
        boolean currMatch = true;
        while (lenNotExceed && currMatch) {
            sum = Integer.valueOf(s0) + Integer.valueOf(s1);
            s0 = s1;
            s1 = Integer.toString(sum);
            totalLen += 
        }
    }
    
}
