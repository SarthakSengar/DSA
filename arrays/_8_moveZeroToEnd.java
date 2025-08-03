import java.util.ArrayList;
import java.util.List;

public class _8_moveZeroToEnd {
    //brute->copy non-zero values to temp.......then paste em in front
    static void moveZero(int arr[]){
        List<Integer> temp =new ArrayList<>();
        //copying no zero
        for(int i = 0 ;i<arr.length;i++){
            if(arr[i]!=0){
                temp.add(arr[i]);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(i<temp.size()){
                arr[i]=temp.get(i);
            }
            else{
                arr[i]=0;
            }
        }
    }
    //optimal ->two pointer approach 
    static void moveZeroP(int arr[]){
        int j=0;
        while(arr[j]!=0)j++;

        for(int i=j+1 ;i<arr.length;i++){
            if(arr[i]!=0){
                int temp =arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[]= {1,2,0,0,6,7,0,0,4,3};
        moveZeroP(arr);
        for(int i: arr){
            System.out.println(i);
        }
    }
}
