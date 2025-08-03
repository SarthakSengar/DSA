public class _37_MaximumProductSubArray {
    static void maxProduct(int arr[]){
        int max = Integer.MAX_VALUE;
        int prefix=1;
        int sufix=1;
        int n =arr.length;

        for(int i=0;i<arr.length;i++){
            if(prefix==0)prefix=1;
            if(sufix==0)sufix=1;

            sufix=sufix*arr[n-i-1];
            prefix=prefix*arr[i];

            max=Math.max(prefix, sufix);
        }
    }
    public static void main(String[] args) {
        
    }
}
