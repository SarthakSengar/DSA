public class _11_findPeak{
    static int peak(int arr[],int n){
        if(n==1)return arr[0];
        if(arr[0]>arr[1])return arr[0];
        if(arr[n-1]>arr[n-2])return arr[n-1];
        int low = 1,high= n-2;
        while(low<=high){
            int mid =low +(high-low)/2;

            //mid is peak element 
            if (arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1])return arr[mid];

            //mid on increasing curve --> search on right side
            else if (arr[mid]>arr[mid-1]){
                low =mid+1;
            }

            //mid is on trough --> move any side
            else if(arr[mid]<arr[mid+1] && arr[mid] <arr[mid-1]){
                low=mid+1;
            }

            //on decreasing curver
            else{
                high =mid-1;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 20,30, 4, 1, 0};
        System.out.println("Peak Element: " + peak(arr, arr.length));
        
    }
}