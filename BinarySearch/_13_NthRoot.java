public class _13_NthRoot {
    static int powerFunc(int mid , int n ,int num){
        int ans=1;
        for(int i=0;i<n;i++){
            ans=ans*mid;
            //during powering the answer exceded num no need to power more 
            //as is 2^4 > num then 2^5 > num too
            if(ans>num)return 2;
        }
        if(ans==num) return 1;
        else{
            return 0;
        }
    }

    static int nthRoot(int num ,int n){
        int low =1 , high=num ,ans=1;
        while(low<=high){
            int mid = low + (high-low )/2;
            int result =powerFunc(mid, n ,num);
            if(result!=2){
                ans =mid ;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(nthRoot(27, 3));
        System.out.println(nthRoot(81, 4));  
        System.out.println(nthRoot(10, 2));  
        System.out.println(nthRoot(1, 5));   
    }
    
}
