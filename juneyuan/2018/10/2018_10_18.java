class Solution {
    private static Map<Integer, String> lookup = new HashMap<>();
    private static final int mxIdx = 30;
    
    static {
        String curr = "1";
        lookup.put(new Integer(1), curr);
        
        for (int i = 1; i < mxIdx; i++) {
            curr = getNext(curr);
            lookup.put(new Integer(i + 1), curr);
        }
    }
    
    public String countAndSay(int n) {
        return lookup.get(n);
    }
    
    private static String getNext(String curr) {
        StringBuilder ret = new StringBuilder();
        
        int cnt = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (i == 0) {
                cnt = 1;
            } else {
                if (curr.charAt(i) == curr.charAt(i - 1)) {
                    cnt++;
                } else {
                    ret.append(cnt).append(curr.charAt(i - 1));
                    cnt = 1;
                }
            }
            
            if (i == curr.length() - 1) {
                ret.append(cnt).append(curr.charAt(i));
            }
        }
        
        return ret.toString();
    }
}
