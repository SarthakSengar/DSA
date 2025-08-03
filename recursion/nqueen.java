import java.util.ArrayList;
import java.util.List;

public class nqueen{

    static Boolean isSafe(int col ,int row , char arr[][],int n){
        int coltemp =col;
        int rowtemp = row;
        while(col>=0&&row>=0){
            if(arr[row][col]=='Q')return false;
            col--;
            row--;
        }
        col=coltemp;
        row=rowtemp;
        while(col>=0){
            if(arr[row][col]=='Q')return false;
            col--;
        }
        col=coltemp;
        row=rowtemp;
        while(col>=0&&row<n){
            if(arr[row][col]=='Q')return false;
            col--;
            row++;;
        }
        return true;
    } 

    static void Nqueens(int column, int n ,char arr[][],List<List<String>> boards){
            if(column==n){
                List<String> board = new ArrayList<>();
                for(int i=0 ;i<n;i++){
                    board.add(new String(arr[i]));
                }
                boards.add(new ArrayList<>(board));
                return;
            }
            for(int i =0 ;i<n ;i++){
                if(isSafe(column,i,arr,n)){
                    arr[i][column]='Q';
                    Nqueens(column+1,n,arr,boards);
                    arr[i][column]='0';
                }
            }
    }


    //Optimised code left daigonal upper diagonal(n-1 col-row) ,lower diagonal(col + row) while fillingin value matain this hash and make entries according to check if possible condition we can check if its 0 for give row and colum 
    public static void main(String[] args) {
        List<List<String>> boards = new ArrayList<>();
        int n =4;
        //temp boards 
        char arr[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                arr[i][j]='0';
            }
        }
        Nqueens(0, n, arr, boards);
        for(List<String> i : boards){
            for(String s : i){
                System.out.println(s);
            }
            System.out.println();
        }

        
    }
}
