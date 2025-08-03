import java.util.ArrayList;
import java.util.List;

public class _21_leadersInArray {
    static void leaderInArray(int arr[]){
        List<Integer> leaders = new ArrayList<>();
        leaders.add(arr[arr.length-1]);
        int max=arr[arr.length-1];

        for(int i =arr.length-2 ;i>=0;i--){
            if(arr[i]>max){
                max=arr[i];
                leaders.add(arr[i]);
            }
        }
        for(int i :leaders){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int arr[] ={90,80,40,60,10,55,1,2,3,0};
        leaderInArray(arr);

    }
}
