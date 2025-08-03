import java.util.HashMap;
import java.util.Map;

public class _12_missingNumber1toN {
    //brute force given n-1 number have to figure out 1 to N which number is missing
    //check each number one by from enitre array
    static void missing(int n,int arr[]){
        for(int i =1;i<=n;i++){
            int flag=0;
            for(int j=0;j<arr.length;j++){
                if(i==arr[j]){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                System.out.println("missing = "+i);
            }
        }
    }
    //better use a map to store this values
    static void bettermissing(int n ,int arr[]){
        Map <Integer,Integer> counts = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            counts.put(arr[i],1);
        }
        for(int i=1 ;i<n;i++){
            if(!counts.containsKey(i)){
                System.out.println("missing = "+i);
                break;
            }
        }
    }

    //optimal solution 
    static void missingO(int arr[],int n){
        int sum =n*(n+1)/2;
        int sumOfArray =0;
        for(int i:arr){
            sumOfArray+=i;
        }
        System.out.println("missing = "+(sum-sumOfArray));
    }

    //best solution XOR
    static void missingOXor(int arr[],int n){
        int xor1=0;
        int xor2=0;
        for(int i=0;i<arr.length;i++){  
            xor2^=arr[i];
            xor1^=(i+1);
        }
        xor1 ^=n;
        System.out.println("missing = "+(xor1^xor2));
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,6,7,8};
        missing(8, arr);
        bettermissing(8, arr);
        missingO(arr, 8);
        missingOXor(arr, 8);
    }
}
