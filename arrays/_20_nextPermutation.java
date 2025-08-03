public class _20_nextPermutation {
    static void next(int arr[]){
        int i=arr.length-2;

        while(i>=0 && arr[i]>=arr[i+1]){
            i--;
        }
        int j =arr.length-1;
        while(arr[j]<arr[i]){
            j--;
        }
        swap(i,j,arr);
        reverse(i + 1, arr.length-1, arr);
    }
    static void reverse(int start,int end,int arr[]){
        while(start<end){
            swap(start, end, arr);
            start++;
            end--;
        }
    }
    static void swap(int j,int i,int arr[]){
      int temp=arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
    }
    public static void main(String[] args) {
        int arr[]= {1,3,2};
        next(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }
    
}
