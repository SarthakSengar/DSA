public class _6_searchRotatedSortedUnique {
    static int search(int arr[],int target){
        int n =arr.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid = low+ (high-low)+1;
            if(arr[mid]==target)return mid;

            //LEFT PART SORTED 
            else if(arr[low]<=arr[mid]){

                //Contains target?
                if(arr[low]<=target && arr[high]>=target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            //Right PART SORTED 
            else{
                //Contains target?
                if(arr[mid]<=target && target<=arr[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }

            }
        }
        return -1;
    }
    
}
