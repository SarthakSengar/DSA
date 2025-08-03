public class _17_maximumSubArraySumKadanes {
    //kadanes algorithm
    static int maximumSuBSum(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        int start=0,end =0 ,tempstart =0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>maxSum){
                start=tempstart;
                end=i;
                maxSum=sum;
            }
            if(sum<0){
                tempstart=i+1;
                sum=0;
            }
        }
        System.out.println(start+"("+arr[start]+")"+"->"+end+"("+arr[end]+")");
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[]={-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maximumSuBSum(arr));
    }
}
