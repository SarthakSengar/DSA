import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _30_4Sum {
    ///brute
    static void _4Sum(int arr[],int target){
        Set<List<Integer>> answer = new HashSet<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        if(arr[i]+arr[j]+arr[k]+arr[l]==target){
                            List<Integer> result = new ArrayList<>();
                            result.add(arr[i]);
                            result.add(arr[j]);
                            result.add(arr[k]);
                            result.add(arr[l]);
                            Collections.sort(result);
                            answer.add(result);
                        }
                    }
                }
            }
        }
        for(List<Integer> l : answer)System.out.println(l);
    }

    //better
    static void _4SumSet(int arr[],int target){
        Set<List<Integer>> answer = new HashSet<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer> hash = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    int fourth = target-(arr[i]+arr[j]+arr[k]);
                    if(hash.contains(fourth)){
                        List<Integer> result = new ArrayList<>();
                        result.add(arr[i]);
                        result.add(arr[j]);
                        result.add(arr[k]);
                        result.add(fourth);
                        Collections.sort(result);
                        answer.add(result);
                    }
                    hash.add(arr[k]);
                    
                }
                
            }
        }
        for(List<Integer> l : answer)System.out.println(l);
    }

    //optimal
    static void _4SumWithoutSet(int arr[],int target){
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1])continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && arr[j]==arr[j-1])continue;
                int k= j+1;
                int l= n-1;
                while(k<l){
                    int sum = arr[i]+arr[j]+arr[k] +arr[l];
                    if(sum<target){
                        k++;
                    }
                    else if (sum>target){
                        l--;
                    }
                    else{
                        List<Integer> result = new ArrayList<>();
                        result.add(arr[i]);
                        result.add(arr[j]);
                        result.add(arr[k]);
                        result.add(arr[l]);
                        answer.add(result);
                        k++;
                        l--;
                        while(k<l && arr[k]==arr[k-1])k++;
                        while(k<l && arr[l]==arr[l+1])l--;
                    }
                }
            }
        }
        for(List<Integer> l : answer)System.out.println(l);
    }
    public static void main(String[] args) {
        int arr[]={1,1,1,1,2,2,2,2,3,3,3,4,4,4,5};
        int target =8;
        _4SumWithoutSet(arr, target);
    }
    
}
    

