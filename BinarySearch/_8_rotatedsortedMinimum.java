public class _8_rotatedsortedMinimum {
    static int finMin(int arr[]){
        int ans = Integer.MAX_VALUE;
        int low=0, n=arr.length, high =n-1;
        
        while(low<=high){
            int mid= low + (high-low)/2;
            // When low, mid, high are equal — can't decide, reduce range
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                ans= Math.min(ans,arr[low]);
                low++;
                high--;
                continue;
            }
            else if(arr[low]<=arr[mid]){
                ans=Math.min(ans, arr[low]);
                low=mid+1;
            }else{
                ans=Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
}
