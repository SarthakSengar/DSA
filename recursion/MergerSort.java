import java.util.ArrayList;
import java.util.List;

public class MergerSort {
    static void merge(int arr[],int low ,int mid,int high){
        int i =low ;
        int j= mid+1;
        List<Integer> temp = new ArrayList<>();
        
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
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
    }
    static void mergerSort(int arr[],int low ,int high){
        int mid;
        if(low<high){
            mid=(low+high)/2;
            mergerSort(arr, low, mid);
            mergerSort(arr, mid+1, high);
            merge(arr,low,mid,high);
        }
    }


    public static void main(String[] args) {
        int arr[]={4,5,2,1,8,6};
        mergerSort(arr, 0, 5);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
