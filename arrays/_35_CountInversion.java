public class _35_CountInversion {
    //Brute O(n^2) 
    static void inversion(int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //Merge Sort Approach 

    static void CountInversion(int arr[]){
        int count = mergeSort(arr,0,arr.length-1);
        System.out.println(count);
    }

    static int mergeSort(int arr[],int low,int high){
        int count=0;

        if(low<high){
            int mid = (low+high)/2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid+1, high);
            count += merge(arr,low,mid,high);
        }

        return count;
    }
    //O(nlogn) megre sort so S:O(n)
    static int merge(int arr[],int low ,int mid ,int high){
        int count =0;
        int left =low ;
        int right =mid+1;
        int temp[] =new int[high-low+1];
        int k =0;

        while(left<=mid && right <=high){
            if(arr[left]>arr[right]){
                //count pairs 
                count+= mid-left+1;
                //add to temp
                temp[k]=arr[right];
                right++;
            }else{
                temp[k]=arr[left];
                left++;
            }
            k++;
        }
        while(left<=mid){
            temp[k]=arr[left];
            left++;
            k++;
        }
        while(right<=high){
            temp[k]=arr[right];
            right++;
            k++;
        }

        for(int i=low ;i<=high ;i++){
            arr[i]=temp[i-low];
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]={5,3,2,4,1};
        inversion(arr);
        CountInversion(arr);
    }
    
}
