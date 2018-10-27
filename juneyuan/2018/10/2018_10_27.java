public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        if (A == null || A.length == 0) {
            return 0L;
        }
        
        long ret = 1, fact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    rank++;
                }
            }
            ret += rank * fact;
            fact *= (A.length - i);
        }
        
        return ret;
    }
}
