class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i])     continue;

            List<String> gr = new ArrayList<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && beAnagrams(strs[i], strs[j])) {
                    gr.add(strs[j]);
                    visited[j] = true;
                }
            }

            gr.add(strs[i]);
            visited[i] = true;
            ret.add(gr);
        }

        return ret;
    }
    
    private boolean beAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null)   return false;
        if (s1.length() != s2.length())     return false;

        int SIZE = 26;
        int[] letterCnt = new int[SIZE];

        for (int i = 0; i < s1.length(); i++) {
            letterCnt[s1.charAt(i) - 'a']++;
            letterCnt[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < SIZE; i++) {
            if (letterCnt[i] != 0) {
                return false;
            }
        }

        return true;
    }   
    
}
