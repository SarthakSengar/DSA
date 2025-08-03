public class _16_majorityElement1 {
    static int majorityElementmooreOptimal(int arr[]){
        int cnt =0;
        int el=arr[0];
        int n =arr.length;
        for(int i =0;i<n;i++){
            if(cnt==0){
                cnt=1;
                el=arr[i];
            }
            else if (el==arr[i]){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        if(cnt==0)return -1;
        int count=0;
        for(int i=0 ;i<n ;i++){
            if(arr[i]==el){
                count++;
            }
        }
        if(count>n/2)return el;
        else return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,1,1,1,3,3,4,5,3,2,2,22,2,2,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,};
        System.out.println(majorityElementmooreOptimal(arr));
    }
}
