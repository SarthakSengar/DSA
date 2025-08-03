import java.util.HashMap;

public class _26_subarraySumK {

    //brute iterate for all subarrays O(n^2)
    
    //optimal prefix sum approach 
    //inportant is to maintain 0 prefix sum 
    static void sumK(int arr[],int k){
        int count=0;
        int prefixSum=0;
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(0,1);
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(hashmap.containsKey(prefixSum-k)){
                count+=hashmap.get(prefixSum-k);
            }
            if(hashmap.containsKey(prefixSum)){
                hashmap.put(prefixSum,hashmap.get(prefixSum)+1);
            }else{
                hashmap.put(prefixSum,1);
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int arr[] ={3,-3,1,1,1};
        sumK(arr, 3);
        
    }
}
