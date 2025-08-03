import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _22_longestConsecutiveSequence {

    //Brute Force O(n^3)
    static void longest(int arr[]){
        int longest= 0;
        for(int i =0;i<arr.length;i++){
            int num =arr[i];
            int count=0;
            while(find(arr,num)==true){
                num++;
                count++;
            }
            if(count>longest)longest=count;
        }
        System.out.println("Longest : "+ longest);
    }

    static boolean find(int arr[],int n){
        for(int i :arr){
            if(i==n)return true;
        }
        return false;
    }

    //Better use A maintaining last smaller (sorting)
    //we basically intialise lastsmaller to a very small value
    //iterating we check if last smaller+1 is actually is ith element
    //as there either will be same element / element +1 /!= element on the next element 
    //if not the that mean no more a consequtive sequence and we start a new sequence 

    static void longestSortedBetter(int arr[]){
        Arrays.sort(arr);
        int lastsmaller = Integer.MIN_VALUE;
        int longest=0;
        int count =0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]==lastsmaller+1){
                lastsmaller++;
                count++;
            }
            else if (arr[i]!=lastsmaller){
                count =1;
                lastsmaller=arr[i];
            }
            longest=Math.max(count,longest);//this cant be in if block as on finding a new sequemce count=1 this wont be compared with longest untill second consecutive element is found 
        }
        System.out.println("Longest : "+ longest);
    }

    static void longestOSet(int arr[]){
        Set <Integer> hash = new HashSet<>();
        for(int i =0 ;i<arr.length;i++){
            hash.add(arr[i]);
        }
        int longest=0;

        for(int i :hash ){
            int count=0;
            if(!hash.contains(i-1)){
                count=1;
                int element = i;
                while(hash.contains(element+1)){
                    count++;
                    element++;
                }
                longest=Math.max(longest,count);
                //this cant be in while block 
            }
        }
        System.out.println("Longest : "+ longest);
    }
    
    
    public static void main(String[] args) {
        int arr[]= {1};
        longest(arr);
        longestSortedBetter(arr);
        longestOSet(arr);
        
    }
}
