public class _3_floorCeil {
    //ceil is smallest value greater than x {upper bounds value }
    static int ceil(int arr[],int x){
        int low,high,answer;
        low=0;
        high=arr.length-1;
        answer=arr.length;

        while(low<=high){
            int mid =low + (low-high)/2;
            if(arr[mid]>x){
                answer=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return answer;
    }

    //floor largest value less than X 
    static int floor(int arr[],int x){
        int low =0 , high=arr.length-1, answer = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]<=x){
                answer=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return answer ;
    }
}
