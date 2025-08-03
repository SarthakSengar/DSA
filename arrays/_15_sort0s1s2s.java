public class _15_sort0s1s2s {
    //brute use any sorting algorithm T: O(logn)

    //use counting T: O(2n)
    static void Sort0_1_2(int arr[]){
        int count1= 0, count2=0,count0=0;
        for(int i =0 ;i<arr.length;i++){
            if(arr[i]==0)count0++;
            else if(arr[i]==1)count1++;
            else count2++;
        }
        for(int i= 0;i<count0;i++){
            arr[i]=0;
        }
        for(int i=count0 ;i<(count0+count1);i++){
            arr[i]=1;
        }
        for(int j= count0+count1 ;j<arr.length;j++){
            arr[j]=2;
        }
    }

    //OPTIMAL T:O(n) dutch national flag algorithm
    //O----low-1 | low ----mid-1 | mid -------high| high+1 ----n-1
    //0000----0  | 111111------1 | unsorted       |222222-------2 

    //three case mid =0,1,2

    static void Sort0_1_2_optimal(int arr[]){
        int low =0 ,mid=0 ,high= arr.length-1;

        while(mid<=high){
            if(arr[mid]==0){
                swap(low,mid,arr);
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else {
                swap(mid,high,arr); 
                high--;
            }
        }
    }
    static void swap(int j,int i,int arr[]){
      int temp=arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
    }

    public static void main(String[] args) {
        int arr[]={0,1,2,1,1,1,2,2,0,0,0,1,1,1,};
        //Sort0_1_2(arr);
        Sort0_1_2_optimal(arr);
        for(int i :arr){
            System.out.println(i);
        }
    }
    
}
