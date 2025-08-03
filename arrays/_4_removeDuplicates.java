public class _4_removeDuplicates {
    //sorted array

    //brute ->use a set traverse twice once throu array putting into set taking nlogn time and then through set replacing element in array O(m) m=no.unique elements
    
    //optimal (two pointer approach )
    // less intutive
    static void removeduplicates1(int arr[]){
        int i=0;
        int j=1;
        for(j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        for(int k =0 ;k<i+1 ;k++){
            System.out.println(arr[k]);
        }
    }
    //moreintutive
    static void removeduplicates(int arr[]){
        int index=0;
        int element= arr[0];

        for(int newelement : arr){
            if(newelement != element){
                arr[index+1]= newelement;
                element =newelement;
                index++;
            }
        }
    }
    

    public static void main(String[] args) {
        int arr[]={1,2,2,3,3,3,4,4,5,6,6,6,7,8,8,8,9,9};
        removeduplicates1(arr);
    //     removeduplicates(arr);
    //     for(int i :arr){
    //         System.out.println(i);
    //     }
    }
    
}
