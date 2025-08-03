import java.util.ArrayList;
import java.util.List;

public class _34_MissingAndRepeating {
    // O(n^2) time complexity O(1) space complexity
    static List<Integer> missingRepeatingBrute(int arr[]){
        int repeating= -1 , missing =-1; 
        for(int i =1;i<=arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(i==arr[j]){
                    count++;
                }
            }
            if(count==2){
                repeating= i;
            }
            if(count==0){
                missing=i;
            }

            if(repeating!=-1 && missing!=-1)break;
        }

        List<Integer> answer =new ArrayList<>();
        answer.add(missing);
        answer.add(repeating);
        System.out.println(answer);
        return answer;
    }

    //Better hashing T: O(2*N) S: O(n) to store the hashArray count
    static List<Integer> missingRepeatingHashin(int arr[]){
        int n=arr.length;
        int hashArray[]= new int[n+1];
        for(int i =0 ;i<hashArray.length;i++){
            hashArray[i]=0;
        }
        for(int i :arr){
            hashArray[i]++;
        }
        int repeating= -1 , missing =-1; 
        for(int i =1;i<=n;i++){
            if(hashArray[i]==0){
                missing = i;
            }
            if(hashArray[i]==2){
                repeating=i;
            }
        }
        List<Integer> answer =new ArrayList<>();
        answer.add(missing);
        answer.add(repeating);
        System.out.println(answer);
        return answer;
    }

    //Use math O(1) O(1)
    static List<Integer> missingRepeatiIntegersMath(int arr[]){
        int sn =0 ,sna =0 ,sn2 =0, sn2a =0;

        for(int i =0 ;i<arr.length;i++){
            sn+= i+1;
            sna+= arr[i];
            sn2 += (i+1)*(i+1);
            sn2a += arr[i]* arr[i];
        }

        //x : missing   y :repeating
        int x_minus_y = sn-sna;
        int x_plus_y =(sn2-sn2a)/x_minus_y;

        int x = (x_minus_y + x_plus_y )/2;
        int y = x_plus_y -x;

        List<Integer> answer =new ArrayList<>();
        answer.add(x);
        answer.add(y);
        System.out.println(answer);
        return answer;

    }

    public static void main(String[] args) {
        int arr[]={1,1,2,3,4};
        missingRepeatingBrute(arr);
        missingRepeatingHashin(arr);
        missingRepeatiIntegersMath(arr);
    }


    
}
