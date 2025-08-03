import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class suddokusolver {

    static boolean isSafe(int row,int col ,char value,List<List<Character>> board){
        for(int i=0;i<9;i++){
            if((board.get(row).get(i)==value)||
            (board.get(i).get(col)==value)||
            board.get((3*(row/3) + i/3)).get(3*(col/3)+i%3)==value)
            return false;
        }
        return true;
    }

    static boolean solve(List<List<Character>>board){
        for(int i =0 ;i<9;i++){
            for(int j=0 ;j<9;j++){
                if(board.get(i).get(j)=='.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isSafe(i,j,c,board)){
                            board.get(i).set(j,c);
                            if(solve(board)==true)return true;
                            board.get(i).set(j,'.');
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void solveSuddoku(List<List<Character>> board){
        if(solve(board)==true){
            for(List<Character> row : board){
                System.out.println(row);
            }
            return;
        }
        System.out.println("No valid input");
        
    }
    public static void main(String[] args) {
        List<List<Character>> board = new ArrayList<>();
        List<List<Character>> boardinput = Arrays.asList(
            Arrays.asList('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            Arrays.asList('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            Arrays.asList('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            Arrays.asList('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            Arrays.asList('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            Arrays.asList('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            Arrays.asList('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            Arrays.asList('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            Arrays.asList('.', '.', '.', '.', '8', '.', '.', '7', '9')
            );
            solveSuddoku(boardinput);
    }
}
