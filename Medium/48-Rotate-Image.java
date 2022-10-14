class Solution {
    public void rotate(int[][] matrix) {
        int i = 0;
        while (i < matrix.length) {
            for (int k = i; k < matrix.length - i - 1; k++) {
                int a = matrix[i][k];
                int b = matrix[k][matrix.length - i - 1];
                int c = matrix[matrix.length - i - 1][matrix.length - k - 1];
                int d = matrix[matrix.length - k - 1][i];
                
                matrix[i][k] = d;
                matrix[k][matrix.length - i - 1] = a;
                matrix[matrix.length - i - 1][matrix.length - k - 1] = b;
                matrix[matrix.length - k - 1][i] = c; 
            }
            i++;
        }
    }
}
