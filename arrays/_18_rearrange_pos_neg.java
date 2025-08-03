import java.util.ArrayList;
import java.util.List;

public class _18_rearrange_pos_neg{

    //equal +ve and -ve optimal solution 
    static void rearrange(int arr[]){
        int n = arr.length;
        int pos =0,neg=1;
        int temp[] =new int[n];
        for(int i =0;i<n;i++){
            if(arr[i]<0){
                temp[neg]=arr[i];
                neg+=2;
            }
            else{
                temp[pos]=arr[i];
                pos+=2;
            }
        }
        for(int i=0;i<n;i++){
            arr[i]=temp[i];
        }
    }

    //optimal for unequal number +ve and -ve 

    static void rearrangeUnbalnced(int arr[]){
        int n =arr.length;
        List<Integer> postives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for(int i= 0;i<n;i++){
            if (arr[i]>=0) postives.add(arr[i]);
            else negatives.add(arr[i]);
        }

        int posCount = postives.size();
        int negCount = negatives.size();

        if(posCount<=negCount){
            for(int i =0 ;i< posCount;i++){
                arr[2*i]=postives.get(i);
                arr[2*i +1]=negatives.get(i);            
            }
            
            int index= posCount*2;
            for(int i =posCount ;i<negCount;i++){
                arr[index]=negatives.get(i);
                index++;
            }
        }
        else{
            for(int i =0 ;i< negCount;i++){
                arr[2*i]=postives.get(i);
                arr[2*i +1]=negatives.get(i);            
            }
            
            int index= negCount*2;
            for(int i =negCount ;i<posCount;i++){
                arr[index]=postives.get(i);
                index++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,-1,-2,};
        rearrangeUnbalnced(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }
    
}