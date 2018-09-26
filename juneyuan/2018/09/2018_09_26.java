/**
 * Single NumberI: 2*n+1
 */
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)   return -1;
        
        int ret = 0;
        for (int a : nums) {
            ret ^= a;
        }
        
        return ret;
    }
}

/**
 * Single NumberIII: 2*n+2
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        
        if (nums == null || nums.length == 0)   return ret;
        
        int n1XORn2 = 0;
        for (int i : nums) {
            n1XORn2 ^= i;
        }
        
        // get the last 1 bit of x1xorx2, e.g. 1010 ==> 0010
        int last1Bit = n1XORn2 - (n1XORn2 & (n1XORn2 - 1));
        int single1 = 0, single2 = 0;
        for (int i : nums) {
            if ((i & last1Bit) == 0) {
                single1 ^= i;
            } else {
                single2 ^= i;
            }
        }
        
        ret[0] = single1;
        ret[1] = single2;
        return ret;
    }
}

/**
 * Single NumberII: 3*n+1
 */
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)   return -1;

        int ret = 0;

        int[] helper = new int[32];
        for (int i : nums) {
            for (int k = 0; k < 32; k++) {
                helper[k] += ((i >>> k) & 1);
                helper[k] %= 3;
            }
        }

        for (int k = helper.length -1; k >= 0; k--) {
            ret <<= 1;
            if (helper[k] != 0) {
                ret += 1;
            }
        }

        return ret;
    }
}
