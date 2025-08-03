import java.util.HashMap;
import java.util.Map;
public class _31_subarrayXorK {
    //brute
    static void xorK(int arr[],int k){
        int n =arr.length;
        int count =0;
        for(int i=0;i<n;i++){
            for(int j =i ;j<n ;j++){
                int xor =0;
                for(int l =i ;l<=j;l++){
                    xor^=arr[l];
                }
                if(xor==k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //better 
    static void xorKBetter(int arr[],int k){
        int n =arr.length;
        int count =0;
        for(int i=0;i<n;i++){
            int xor =0;
            for(int j =i;j<n ;j++){
                xor^=arr[j];
                if(xor==k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //optimal approach Prefix Xor approach 
    static void prefixXorSolution(int arr[],int k){
        int prefixXor=0;
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            prefixXor ^= arr[i];
            int reqPrefix = prefixXor ^k;
            if(map.containsKey(reqPrefix)){
                count +=map.get(reqPrefix); 
            }
            if(map.containsKey(prefixXor)){
                map.put(prefixXor,map.get(prefixXor)+1);
            }else{
                map.put(prefixXor,1);
            }
        }
        System.out.println(count);
    }
    
    public static void main(String[] args) {
        int []arr={4,2,2,6,4};
        prefixXorSolution(arr, 2);
        xorK(arr, 2);
        xorKBetter(arr, 2);
        
    }
}
