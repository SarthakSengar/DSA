import java.util.ArrayList;
import java.util.List;

public class subsequence {
    //PowerDet appoach 
    static void Powerset(String str){
        int n =str.length();
        for(int i =0 ;i<=(1<<n)-1;i++){
            String sub="";
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    sub += str.charAt(j);
                }
            }
            System.out.println(sub);
        }
    }
    
    //recursive approach (string input )
    static void PrintS(int index ,String str,String current,List<String>store){
        if(index==str.length()){
            store.add(current);
            return;
        }
        PrintS(index+1, str, current+str.charAt(index), store);
        PrintS(index+1, str, current, store);
    }

    //now for array input

    //1.printing all sub sequences 
    static void PrintS(int index , int arr[], List<Integer> result,List<List<Integer>> store,int n){
        if(index==n){
            store.add(new ArrayList<>(result));
            return;
        }
        result.add(arr[index]);
        PrintS(index+1,arr,result,store,n);
        result.remove(result.size()-1);
        PrintS(index+1, arr, result, store,n);
    }
    
    //2.printing all sub sequneces wiht sum K 
    static void PrintSumK(int index , int currsum,int sum,int arr[], List<Integer> result,List<List<Integer>> store,int n){
        if(index==n){
            if(currsum==sum)
            store.add(new ArrayList<>(result));
            return;
        }
        currsum+=arr[index];
        result.add(arr[index]);
        PrintSumK(index+1,currsum,sum,arr,result,store,n);
        result.remove(result.size()-1);
        currsum-=arr[index];
        PrintSumK(index+1, currsum,sum,arr, result, store,n);
    }

    //3.printing only 1 sub seuences with sum K 
    static boolean PrintSumKOnly1(int index , int currsum,int sum,int arr[], List<Integer> result,int n){
        if(index==n){
            if(currsum==sum){
                for(Integer i : result){
                    System.out.print(i+" ");
                }            
                return true;
            }
            else{
                return false;
            }
        }
        currsum+=arr[index];
        result.add(arr[index]);
        if(PrintSumKOnly1(index+1,currsum,sum,arr,result,n)==true)return true;
        result.remove(result.size()-1);
        currsum-=arr[index];
        if(PrintSumKOnly1(index+1, currsum,sum,arr, result,n)==true)return true;
        
        return false;
    }
    //4.counting all sub sequences wiht sum K
    static int PrintSumKCount(int index , int currsum,int sum,int arr[], List<Integer> result,int n){
        if(index==n){
            if(currsum==sum){
                return 1;
            }
            else{
                return 0;
            }
        }

        currsum+=arr[index];
        result.add(arr[index]);
        int l = PrintSumKCount(index+1,currsum,sum,arr,result,n);
        result.remove(result.size()-1);
        currsum-=arr[index];
        int r= PrintSumKCount(index+1, currsum,sum,arr, result,n);

        return l+r;
    }

    public static void main(String[] args) {
        // Powerset("abc");

        // List<String> store = new ArrayList<>();
        // PrintS(0, "312", "", store);
        // for(String i : store){
        //     System.out.println(i);
        // }
        List<List<Integer>> store = new ArrayList<>();
        List<Integer> result= new ArrayList<>();
        int arr[]={3,1,2};
        //PrintS(0,arr,result,store,3);
        //PrintSumK(0,0,3,arr,result,store,3);
        // for(List<Integer> i : store){
        //     System.out.println(i);
        // }
        //PrintSumKOnly1(0,0,3,arr,result,3);
        System.out.println(PrintSumKCount(0,0,3,arr,result,3));
        
        

        
    }
}
