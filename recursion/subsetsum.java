import java.util.ArrayList;
import java.util.List;

public class subsetsum {
    //all posible subset with distinct elements input
    static void subset1(int index,int arr[],List<Integer> result,List<List<Integer>>store,int n){
        if(index==n){
            store.add(new ArrayList<>(result));
            return;
        }
        result.add(arr[index]);
        subset1(index+1, arr, result, store, n);

        result.remove(result.size()-1);
        subset1(index+1, arr, result, store, n);
    }

    //all possible subset with duplicates in input
    static void subset2(int index,int arr[],List<Integer> result,List<List<Integer>> store,int n){
        store.add(new ArrayList<>(result));
        for(int i =index ; i <n ;i++){
            if(i>index && arr[i]==arr[i-1])continue;
            result.add(arr[i]);
            subset2(i+1, arr, result, store, n);
            result.remove(result.size()-1);
        }
    }
    // the differennce is basically in the input tbh duplicate inputs use the for loop else use the pick not pick approach ..........for sub sequene1 where we can repeat values dont move index forward thats it
    
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> store = new ArrayList<>();
        int arr[] ={1,2,3};
        subset1(0, arr, result, store, 3);
        for(List<Integer> i : store){
            System.out.println(i);
        }
        result.clear();
        store.clear();
        int arr2[]={1,1,2};
        subset2(0, arr2, result, store, 3);
        for(List<Integer> i : store){
            System.out.println(i);
        }
    }
    
}
