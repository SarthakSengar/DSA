import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _14_2SUM {
    //variety1 : retrun t/f variety2:index 
    //we will solve variety two mostly but in last approach use with variety one only
    //brute force try checking all element pairs
    static List<Integer> _2sum (int arr[],int target){
        List<Integer> result= new ArrayList<>();
        for(int i=0; i<arr.length ;i++){
            for(int j =i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    result.add(i);
                    result.add(j);
                    return result;
                }

            }
        }
        return result;    
    }
    //in this we check if there exist a number in array that can be summed upto target we use hashmap for O(1) (best case checking)
    //optimal t: (nlogn worst n^2 best  n depends on map and vlaues) just takes space for hashmap
    static List<Integer> _2sumHashing (int arr[],int target){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result= new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                result.add(i);
                result.add(map.get(target-arr[i]));
                return result;
            }
            map.put(arr[i],i);
        }
        return result;
    }

    //Optimal if want no exta space as is hashmap
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        System.out.println(_2sum(arr, 7));
        System.out.println(_2sumHashing(arr, 7));
        
    }
}
