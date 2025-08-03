public class _7_rotateright {
    static void rotate1(int arr[]){
        int n =arr.length;
        int temp =arr[arr.length-1];
        for(int i=n-2;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=temp;
    }

    static void rotateD(int arr[],int d){
        int temp[] =new int[d];
        int n= arr.length;
        for(int i=n-d ;i<n;i++){
            temp[i-(n-d)]=arr[i];
        }
        for (int i=n-d-1; i>=0; i--) {
        arr[i + d] = arr[i];
    }
        for(int i=0 ;i<d;i++){
            arr[i]=temp[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        rotate1(arr);
        for(int i : arr){
            System.out.println(i);
        }
        System.out.println();
        rotateD(arr, 2);
        for(int i : arr){
            System.out.println(i);
        }
        // rotateD_reverse(arr, 3654646);
        // for(int i : arr){
        //     System.out.println(i);
        // }
        
    }
}
