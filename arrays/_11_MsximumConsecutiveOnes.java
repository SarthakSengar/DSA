public class _11_MsximumConsecutiveOnes {
    //optimal and best approach 
    static void findmax1s(int arr[]){
        int max= 0;
        int count =0;
        for(int i = 0 ;i <arr.length;i++){
            if(arr[i]==1){
                count++;
                if(count >max)max=count;
            }
            else{
                count=0;
            }
        }
        System.out.println("Maximum = " + max);
    }
    public static void main(String[] args) {
        int arr[]={1,1,1,0,0,1,1,1,1,1,1,0,1,1};
        findmax1s(arr);
    }
}
