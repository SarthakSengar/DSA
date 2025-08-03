public class _10_singleoccurenceINsorted {
    static int search(int arr[]){
        int n= arr.length;
        if(n==1)return arr[0];
        if(arr[0]!= arr[1])return arr[0];
        if(arr[n-1]!=arr[n-2])return arr[n-1];

        int low=1 ,high = n-2;
        while(low<=high){
            int mid=low +(high-low)/2;

            //Mid is the unique element 
            if(arr[mid]!=arr[mid-1] &&arr[mid]!=arr[mid+1])return arr[mid];

            //Mean mid is either in before portion or after poriton 

            //Checking for before portion {even ,odd } form a pair
                    //mid even                       //mid odd
            if((mid%2==0 && arr[mid]==arr[mid+1])||(mid%2==1 && arr[mid]==arr[mid-1])){
                low=mid+1;
            }
            //mid is int the after portion so check left part
            else{
                high=mid-1;
            }
        }
        return -1;
        
    }
}
