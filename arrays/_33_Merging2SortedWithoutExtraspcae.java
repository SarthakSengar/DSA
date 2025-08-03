import java.util.Arrays;

public class _33_Merging2SortedWithoutExtraspcae {
    static void PointerApproach(int arr1[],int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        int left=n-1;
        int right=0;
        while(left>=0 && right<m){
            if(arr1[left]>arr2[right]){
                int temp =arr1[left];
                arr1[left]=arr2[right];
                arr2[right]=temp;
                left--;
                right++;
            }
            else break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    //Gap method;
    static void gapApproach(int arr1[],int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        int len =n+m;
        int gap = (n+m)/2 + (n+m)%2 ;
        while(gap>0){
            int left=0;
            int right=left+gap;
            while(right<len){
                if(left< n && right <n){
                    if(arr1[left]>arr1[right]){
                        int temp =arr1[left];
                        arr1[left]=arr1[right];
                        arr1[right]=temp;
                    }
                }
                else if( left< n && right >=n){
                    if(arr1[left]>arr2[right-n]){
                        int temp =arr1[left];
                        arr1[left]=arr2[right-n];
                        arr2[right-n]=temp;
                    }
                }
                else{
                    if(arr2[left-n]>arr2[right-n]){
                        int temp =arr2[left-n];
                        arr2[left-n]=arr2[right-n];
                        arr2[right-n]=temp;
                    }
                }
                left++;
                right++;
            }
            if(gap==1)break;
            gap = gap/2 + gap%2;
        }
    }
    public static void main(String[] args) {
        int arr1[]={0,1,2,1,3,5,5};
        int arr2[]={2,2,4,6,7,9};
        gapApproach(arr1, arr2);
        for(int i:arr1){
            System.out.println(i);
        }
        for(int i:arr2){
            System.out.println(i);
        }
        
    }
    
}
