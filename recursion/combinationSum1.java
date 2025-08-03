import java.util.ArrayList;
import java.util.List;


public class combinationSum1 {

    static void Csum1(int index,int target ,int arr[],List<Integer>result,List<List<Integer>> store){
        if(index==arr.length){
            if(target==0){
                store.add(new ArrayList<>(result));
            }
            return;
        }
        if(target>=arr[index]){
            result.add(arr[index]);
            Csum1(index,target-arr[index],arr,result,store);
            result.remove(result.size()-1);
        }
        Csum1(index+1,target,arr,result,store);
    }
    static void Csum2(int index,int target,int arr[],List<Integer>result,List<List<Integer>> store){
        if(target==0){
            store.add(new ArrayList<>(result));
            return;
        }

        for(int i = index ;i<arr.length;i++){
            if(i>index && arr[i] == arr[i-1])continue;
            if(target <arr[i]) break;

            result.add(arr[i]);
            Csum2(i+1, target-arr[i], arr, result, store);
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) {

        
    }    
}
