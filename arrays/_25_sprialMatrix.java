public class _25_sprialMatrix {
    static void spiral(int mat[][]){
        int row=mat.length;
        int col=mat[0].length;

        int top=0,left=0,right=col-1,bottom=row-1;
        int c =1;

        while(top<=bottom && right>=left){
             //print top
            for(int i=left;i<=right;i++){
                mat[top][i]=c;
                c++;
            }
            top++;

            //print right
            for(int i=top;i<=bottom;i++){
                mat[i][right]=c;
                c++;
            }
            right--;

            //print bottom
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    mat[bottom][i]=c;
                    c++;
                }
                bottom--;
            }
            
            //print left
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    mat[i][left]=c;
                    c++;
                }
                left++;
            }
            
        }

    }
    public static void main(String[] args) {
        int arr[][] = new int[6][6];
        spiral(arr);
        for(int[] row : arr){
            for(int i :row){
                System.out.print(String.format("%3s",(i+"")));
            }
            System.out.println();
        }
    }

    
}
