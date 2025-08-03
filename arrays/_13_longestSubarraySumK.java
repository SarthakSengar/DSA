import java.util.HashMap;
import java.util.Map;

public class _13_longestSubarraySumK {
    //brute force : find all subarrays and find sum and len 
    static int longestSubarrayB(int arr[],int K){
        int longest=0;
        for(int i=0 ;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==K && (j-i+1)>longest){
                    longest=j-i+1;
                }
            }
        }
        return longest;
    }

    // Hashing approach (optimal for both +ve and -ve)
    //prefixsum + k = sum 
    static int longestSubarrayHashingO(int arr[], long k){
        long sum =0;
        int longest=0;
        Map <Long,Integer> prefixSums = new HashMap<>(); 
        for(int i =0;i<arr.length;i++){
            sum+=arr[i];
            if(!prefixSums.containsKey(sum)){
                prefixSums.put(sum,i);
            }
            if(sum==k){
                longest=Math.max(longest,i+1);
            }
            //prefixsum + k = sum -->require prefixsum = sum -k;
            long reqPrefix = sum -k;
            if(prefixSums.containsKey(reqPrefix)){
                longest=Math.max(longest,i-prefixSums.get(reqPrefix));
            }
        }
        return longest;
    }
    //two pointer approach (optimal for +ve) wont work with negatives 
    static void longestSubarrayOpositive(int arr[],long k){
        int left=0,right=0;
        int n =arr.length;
        int sum=arr[0];
        int longest=0;
        while(right<n){
            while(left<=right && sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                longest=Math.max(longest,right-left+1);
            }
            right++;
            if(right<n){
                sum+=arr[right];   
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        long k = 5;
        System.out.println(longestSubarrayHashingO(arr, k));        
    }
}