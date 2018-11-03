public class Solution {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
       if (string == null) return 0;

        int space_cnt = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                space_cnt++;
            }
        }
        final int new_length = 2*space_cnt + length;

        int right = new_length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[right--] = '0';
                string[right--] = '2';
                string[right--] = '%';
            } else {
                string[right--] = string[i];
            }
        }

        return new_length;
    }
}
