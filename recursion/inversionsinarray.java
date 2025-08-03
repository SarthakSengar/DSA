import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class inversionsinarray {
    static int merge(int arr[],int low ,int mid,int high){
        int i =low ;
        int j= mid+1;
        List<Integer> temp = new ArrayList<>();
        int count=0;
        
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                count+=mid-i+1;
                j++;
            }
        }
        while(i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while(j<=high){
            temp.add(arr[j]);
            j++;
        }

        for(int k = 0;k<temp.size();k++){
            arr[low+k]=temp.get(k);
        }
        return count;
    } 
    static int mergerSort(int arr[],int low ,int high){
        int mid;
        int count =0;
        if(low>=high)return count;
        mid=(low+high)/2;
        count += mergerSort(arr, low, mid);
        count += mergerSort(arr, mid+1, high);
        count += merge(arr,low,mid,high);
        return count;
    } 
    
    public static void main(String[] args) {
        int arr[]={4,3,2,1};
        System.out.println(mergerSort(arr,0 , 3));
    }    
}
