class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prev = countAndSay(n - 1);
        return getNext(prev);
    }
    
    private String getNext(String seq) {
        StringBuilder nexSeq = new StringBuilder();
        
        int cnt = 1;
        for (int i = 0; i < seq.length(); i++) {
            if (i < seq.length() - 1 && seq.charAt(i) == seq.charAt(i + 1)) {
                cnt++;
            } else {
                nexSeq.append(cnt).append(seq.charAt(i));
                cnt = 1;
            }
        }
        
        return nexSeq.toString();
    }
}
