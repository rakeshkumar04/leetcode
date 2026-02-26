class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int m = matrix.length;
       int n = matrix[0].length;

       if(m==1 && n==1) return (matrix[m-1][n-1] == target);

       int row = -1;

       int low = 0;
       int high = m - 1;

       while(low<=high){
            int mid = (low + high) / 2;

            if(matrix[mid][0] == target){
                return true;
            }

            if(matrix[mid][0] > target){
                high = mid - 1;
            }

            if(matrix[mid][0] < target){
                row = mid;
                low = mid + 1;
            }
       }

       if(row == -1) return false;

        return searchMatrixRow(matrix[row], target, n);
    }

    public boolean searchMatrixRow(int[] row, int target, int n){
        int low = 0;
        int high = n - 1;

        while(low<=high){
            int mid = (low + high) / 2;

            if(row[mid] == target){
                return true;
            }

            if(row[mid] > target){
                high = mid - 1;
            }

            if(row[mid] < target){
                low = mid + 1;
            }
        }

        return false;
    }
}