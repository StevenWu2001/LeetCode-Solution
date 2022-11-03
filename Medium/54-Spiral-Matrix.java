class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int offset = 0;
        
        while (true) {
            for (int i = offset; i < matrix[0].length - offset; i++) {
                ans.add(matrix[offset][i]);
            }
            
            for (int i = 1 + offset; i < matrix.length - offset - 1; i++) {
                ans.add(matrix[i][matrix[0].length - offset - 1]);
            }
            
            if (matrix.length - offset - 1 == offset) {
                break;
            }
            
            for (int i = matrix[0].length - offset - 1; i >= offset; i--) {
                ans.add(matrix[matrix.length - offset - 1][i]);
            }
            
            if (matrix[0].length - offset - 1 == offset) {
                break;
            }
            
            for (int i = matrix.length - offset - 2; i > offset; i--) {
                ans.add(matrix[i][offset]);
            }
            
            
            offset++;
            if (offset * 2 >= Math.min(matrix.length, matrix[0].length)) {
                break;
            }
            
            
        }
        
        return ans;
    }
}
