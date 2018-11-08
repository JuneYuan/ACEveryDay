public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndexII(int[] A) {
        if (A == null || A.length == 0)     return 0;

        Map<Integer, Integer> hashmap = new HashMap<>();
        long index = 1, fact = 1, multiFact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            // collect its repeated times and update multiFact
            if (hashmap.containsKey(A[i])) {
                hashmap.put(A[i], hashmap.get(A[i]) + 1);
                multiFact *= hashmap.get(A[i]);
            } else {
                hashmap.put(A[i], 1);
            }

            int rank = getRank(A, i);

            // do divide by multiFact
            index += rank * fact / multiFact;
            fact *= (A.length - i);
        }

        return index;
    }

    private int getRank(int[] A, int i) {
        int rank = 0;
        for (int j = i + 1; j < A.length; j++) {
            if (A[i] > A[j]) {
                rank++;
            }
        }
        return rank;
    }
}
