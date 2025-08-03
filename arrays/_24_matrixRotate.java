public class _24_matrixRotate {
    //brtue force approach
    //maintaing an answer matrix for it S: O(N^2)
    static void rotateMatrix90(int matrix[][]){
        int ans[][] = new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                ans[j][matrix.length-1-i]=matrix[i][j];
            }
        }

        for(int[] row : ans){
            for(int i :row){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    //optimal approach withour using extra space unlinke the brute approach 
    //transpose  + reverse
    //T:O(n^2) S:O(1)
    static void rotateMatrix(int arr[][]){
        transpose(arr);
        for(int i=0;i<arr.length;i++){
            reverse(0, arr.length-1,arr[i]);
        }
        for(int[] row : arr){
            for(int i :row){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    } 

    static void transpose(int arr[][]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp =arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
    static void reverse(int start ,int end,int arr[]){
        while(start<end){
            swap(start,end,arr);
            start++;
            end--; 
        }
    }
    static void swap(int j,int i,int arr[]){
      int temp=arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
    }
    
    public static void main(String[] args) {
        int[][] intMatrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotateMatrix90(intMatrix);

        rotateMatrix(intMatrix);
    }
}
