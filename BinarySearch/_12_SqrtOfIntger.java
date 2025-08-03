public class _12_SqrtOfIntger {
    static int squareRoot(int n){
        if (n == 0 || n == 1) return n;
        int low = 1 ,high =n ,ans=1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if((long)mid*mid <= n){
                ans =mid;
                low= mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(squareRoot(10));  
        System.out.println(squareRoot(25));   
    }

}
