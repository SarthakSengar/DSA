public class _1_largestelement{

    //find largest (brute -> sort and last element)
    //optimal->

    static int findlargest(int arr[]){
        int largest =arr[0];
        for(int element : arr){
            if(element>largest) largest =element;
        }
        return largest;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(findlargest(arr));

    }
}