import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class _10_unionIntersectionSorted {
    //brute force "-> insertion into sorted set (Tree Set)
    static int Union(int arr1[],int arr2[],int result[]){
        TreeSet<Integer> set = new TreeSet<>();
        for(int i : arr1){
            set.add(i);
        }
        for(int i :arr2){
            set.add(i);
        }
        int size  =set.size();
        for(int i =0 ;i<size;i++){
            result[i]=set.first();
            set.removeFirst();
        }
        return size;
    }

    //optimal using two pointer each for one array
    //use the merging sorted array approach + take care of duplicates

    //insert the smallest if not already added to result(so no duplicates are in union)
    //increment anyways on the smallest one

    static void UnionOptimal(int arr1[], int arr2[], List<Integer> result) {
        int point1 = 0, point2 = 0;

        while (point1 < arr1.length && point2 < arr2.length) {
            int val1 = arr1[point1];
            int val2 = arr2[point2];

            if (val1 < val2) {
                if (result.isEmpty() || result.get(result.size() - 1) != val1) {
                    result.add(val1);
                }
                point1++;
            } else if (val2 < val1) {
                if (result.isEmpty() || result.get(result.size() - 1) != val2) {
                    result.add(val2);
                }
                point2++;
            } else {
                if (result.isEmpty() || result.get(result.size() - 1) != val1) {
                    result.add(val1);
                }
                point1++;
                point2++;
            }
        }

        // Process remaining elements of arr1
        while (point1 < arr1.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[point1]) {
                result.add(arr1[point1]);
            }
            point1++;
        }

        // Process remaining elements of arr2
        while (point2 < arr2.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[point2]) {
                result.add(arr2[point2]);
            }
            point2++;
        }
    }

    
    //Brute force -> itterate over one on each element iterate other array and find if common and and mark visited O(n1*n2)
    static void intersection(int arr1[],int arr2[] ,List<Integer>result){
        int visited[] = new int [arr2.length ];
        for(int i =0 ;i<visited.length;i++){
            visited[i]=0;
        }
        for(int i=0;i<arr1.length;i++){
            for(int j =0;j<arr2.length;j++){
                if(arr1[i]==arr2[j] && visited[j]==0){
                    result.add(arr2[j]);
                    visited[j]=1;
                    break;
                }
                if(arr2[j]>arr1[i]) break;
            }
        }

    }
    // again two pointer approach O(n1+n2)
    static void intersectionO(int arr1[],int arr2[],List<Integer> result){
        int i=0 ,j=0;
        while(i<arr1.length&& j<arr2.length){
            int num1= arr1[i];
            int num2=arr2[j];

            if(num1<num2){
                i++;
            }
            else if(num2<num1){
                j++;
            }
            else{
                result.add(num1);
                i++;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5,6,6,7,7,7,7,7};
        int arr2[]={3,4,5,6,6,7,8,9};
        // int result[]=new int[arr1.length+arr2.length];
        // int size=Union(arr1,arr2,result);
        // for(int i= 0;i<size ;i++){
        //     System.out.println(result[i]);
        // }

        // List<Integer> resultO = new ArrayList<>();
        // UnionOptimal(arr1, arr2, resultO);
        // for(int i : resultO){
        //     System.out.println(i);
        // }
        System.out.println();
        List<Integer> result2 = new ArrayList<>();
        intersection(arr1, arr2, result2);
        for(int i : result2){
            System.out.println(i);
        }
        System.out.println();
        List<Integer> result3 = new ArrayList<>();
        intersectionO(arr1, arr2, result3);
        for(int i : result3){
            System.out.println(i);
        }

    }
    
}
