public class _2_LowerBound {
    static int lowerBound(int arr[],int x){
        int low =0 , high =arr.length-1;
        int answer= arr.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=x){
                answer=mid;
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return answer;
    }
    static int upperBound(int arr[],int x){ 
        int low =0 , high =arr.length-1;
        int answer= arr.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>x){
                answer=mid;
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return answer;
    } 
    public static void main(String[] args) {
        
    }
    
}
