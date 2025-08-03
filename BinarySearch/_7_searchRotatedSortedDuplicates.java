public class _7_searchRotatedSortedDuplicates {

    
    static int search(int arr[],int target){
        int n =arr.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid = low+ (high-low)+1;
            if(arr[mid]==target)return mid;

            //SHRINK THE ARRAY 
            if(arr[mid]==arr[low] && arr[mid]==arr[high]){
                low--;
                high--;
                continue;
            }

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
