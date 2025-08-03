import java.util.ArrayList;
import java.util.List;

public class permutation {
    //
    static void perm1(int index,List<Boolean> visited,int arr[],List<Integer> result,List<List<Integer>>store,int n){
        if(n==index){
            store.add(new ArrayList<>(result));
            return;
        }
        for(int i = 0 ;i < n;i++){
            if(visited.get(i)==false){
                visited.set(i, true);
                result.add(arr[i]);
                perm1(index+1,visited,arr,result,store,n);
                result.remove(result.size()-1);
                visited.set(i, false);
            }
        }
    }

    //swap approach 
    static void swap(int i , int j ,int arr[]){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void perm2(int index,int arr[],List<List<Integer>> store,int n){
        if(index==n){
            List<Integer> permutation = new ArrayList<>();
            for(int i : arr){
                permutation.add(i);
            }
            store.add(new ArrayList<>(permutation));
            return;
        }
        for(int i= index;i<n;i++){
            swap(index,i,arr);
            perm2(index+1,arr,store,n);
            swap(index, i, arr);
        }
    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> store = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();
        int arr[]={1,2,3};
        // for (int i : arr) {
        //     visited.add(false);
        // }
        // perm1(0,visited,arr,result,store,3);
        // for(List<Integer> i : store){
        //     System.out.println(i);
        // }
        result.clear();
        store.clear();
        perm2(0,arr,store,3);
        for(List<Integer> i : store){
            System.out.println(i);
        }

    }
    
}
