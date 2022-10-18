class Solution {
    public int numDecodings(String s) {
        int a = 0, b = 1;
        if (s.charAt(s.length() - 1) != '0') {
            a = 1;
        }
        
        for (int i = s.length() - 2; i >= 0; i--) {
            int temp = a;
            if (s.charAt(i) == '0') {
                temp = 0;
            }
            
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) != -1)) {
                temp += b;
            }
            b = a;
            a = temp;
        }
        
        return a;
    }
}
