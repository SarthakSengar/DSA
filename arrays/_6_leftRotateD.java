public class _6_leftRotateD {
    //wrost brute -> call one rotate d times 
    //brute-> use a tmep array 
    static void rotateD(int arr[],int d){
        d=d%arr.length;
        int n = arr.length;
        int temp[] =new int[d];
        //copying O(d)
        for(int i=0;i<d;i++){
            temp[i]=arr[i];
        }
        //shfiting O(n-d)
        for(int i=d;i<n;i++){
            arr[i-d]=arr[i];
        }
        //pasting back O(d)
        for(int i=n-d ; i<n;i++){
            arr[i]=temp[i-(n-d)];
        }
    }

    //reverse space optimal approach 
    static void rotateD_reverse(int arr[],int d){
        d=d%arr.length;
        reverse(arr, 0,d-1 );
        reverse(arr,d,arr.length-1);
        reverse(arr, 0, arr.length-1);
    }


    //reverse fucntion 
    static void reverse(int arr[],int start ,int end){
        while(start<end){
            int temp =arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        rotateD(arr, 5);
        for(int i : arr){
            System.out.println(i);
        }
        System.out.println();
        rotateD_reverse(arr, 3654646);
        for(int i : arr){
            System.out.println(i);
        }
        
    }
    
}
