public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public int bitSwapRequired(int a, int b) {
        int count = 0;
        int aXORb = a ^ b;
        while (aXORb != 0) {
            count++;
            aXORb &= (aXORb - 1);
        }
        
        return count;
    }
}
