import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _29_3SUM {
    //brtue
    static void _3sum(int arr[]){
        Set<List<Integer>> set = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++ ){
                    if(arr[i]+arr[j]+arr[k] == 0){
                        List<Integer> triple = new ArrayList<>();
                        triple.add(arr[i]);
                        triple.add(arr[j]);
                        triple.add(arr[k]);
                        Collections.sort(triple);
                        set.add(triple);
                    }
                }
            }
        }

        for(List<Integer> l : set){System.out.println(l);}

    }
    //better i -----hashed------j   if -(arr[i]+arr[j]) in the hash means found a set and add it to the result

    static void _3SumBetter(int arr[]){
        Set<List<Integer>> result = new HashSet<>();
        

        for(int i=0;i<arr.length;i++){
            Set<Integer> hash = new HashSet<>();
            for(int j=i+1;j<arr.length;j++){
                if(hash.contains(-(arr[i]+arr[j]))){
                    List<Integer> triple = new ArrayList<>();
                    triple.add(arr[i]);
                    triple.add(arr[j]);
                    triple.add(-(arr[i]+arr[j]));
                    Collections.sort(triple);
                    result.add(triple);    
                }
                hash.add(arr[j]);
            }
        }
        for(List<Integer> l : result){System.out.println(l);}

    }
    
    //optimal
    //i j-> ---------- <-k
    static void _3SumwithoutSet(int arr[]){
        int n = arr.length;
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1])continue;
            else{
                int j= i+1;
                int k=n-1;
                int sum=0;
                while(j<k){
                    sum= arr[i]+arr[j]+arr[k];
                    if(sum>0){
                        k--;
                    } 
                    else if(sum<0){
                        j++;
                    }
                    else{
                        List<Integer> result = new ArrayList<>();
                        result.add(arr[i]);
                        result.add(arr[j]);
                        result.add(arr[k]);
                        answer.add(result);
                        j++;
                        k--;
                        while(j<k && arr[j]== arr[j-1])j++;
                        while(j<k && arr[k]==arr[k+1])k--;
                    }
                }

            }
        }
        for(List<Integer> l : answer){System.out.println(l);}
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,-3,-2,5,1,-9,-1,2};
        _3SumwithoutSet(arr);
    }
}
