public class _2_secondOrderElement {
    //brute -> sort and star from n-2 to 0 and find first number smaller than largest 
    //better-> find largest in first traversal 
    //         then in second traversal intitalise second largest to int min
    //          traverse and find second < num < largest
    //optimal-> single traversal
    //          if a number > largest --> second = currlargest ,,,change largest to new
    //important if number < largest --> check if greater tha second largest in case
    //          note : "=" should not be considered

    static int secondlargest(int arr[]){
        int secondlargest = Integer.MIN_VALUE;
        int largest = arr[0];

        for(int element :arr){
            if(element >largest){
                secondlargest =largest;
                largest=element;
            }
            else if(element<largest){
                if(element>secondlargest){
                    secondlargest=element;
                }
            }
        }
        return secondlargest;
    } 
    static int secondsmallest(int arr[]){
        int smallest=Integer.MAX_VALUE;
        int secondSmallest =arr[0];
        for(int element : arr){
            if(element < smallest){
                secondSmallest= smallest;
                smallest =element;
            }
            else if(element>smallest){
                if(element<secondSmallest){
                    secondSmallest=element;
                }
            }
        }
        return secondSmallest;
    }  
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(secondlargest(arr));
        System.out.println(secondsmallest(arr));
    }
    
}
