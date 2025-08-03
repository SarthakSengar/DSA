public class _9_numberOfRotations {
    static int findRotations(int arr[]){
        //Minimum number found 
        //[7 8 9 | 1 2 3 4 ]
        //         3 = number of rotations  
        int ans = Integer.MAX_VALUE;
        int low=0, n=arr.length, high =n-1;
        int index=-1;
        
        while(low<=high){
            int mid= low + (high-low)/2;
            // When low, mid, high are equal — can't decide, reduce range
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                low++;
                high--;
                continue;
            }
            else if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                    index=low;
                }
                low=mid+1;

            }else{
                if(arr[mid]<ans){
                    index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }
}
