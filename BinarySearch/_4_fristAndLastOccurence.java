import java.util.ArrayList;
import java.util.List;

public class _4_fristAndLastOccurence{
    static int lowerBound(int arr[],int target){
        int n = arr.length;
        int low=0,high=n-1,ans=n;

        while(low<=high){
            int mid =low +(high-low)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    static int upperBound(int arr[],int target){
        int n = arr.length;
        int low=0,high=n-1,ans=n;
        while(low<=high){
            int mid =low +(high-low)/2;
            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    static List<Integer> firstAndLast(int arr[],int target){
        List<Integer> answer = new ArrayList<>();
        int lb =lowerBound(arr, target);
        if(lb==arr.length || arr[lb]!=target){
            answer.add(-1);
            answer.add(-1);
            return answer;
        }
        else{
            answer.add(lb);
            answer.add(upperBound(arr, target));
            return answer;
        }
    }


    static int first(int arr[],int target){
        int n= arr.length;
        int low=0,high=n-1,first=-1;

        while(low<=high){
            int mid= low+(high-low)/2;
            if(arr[mid]==target){
                first=mid;
                high=mid-1;
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return first;
    }

    static int last(int arr[],int target){
        int n= arr.length;
        int low=0,high=n-1,last=-1;

        while(low<=high){
            int mid = low+ (high-low)/2;
            if (arr[mid]==target){
                last=mid;
                low=mid+1;
            }
            else if (arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return last;
    }


    static List<Integer> firstAndLastPure(int arr[],int target){
        List<Integer> answer = new ArrayList<>();
        int first= first(arr,target);
        if(first==-1){
            answer.add(-1);
            answer.add(-1);
            return answer;
        }
        else{
            answer.add(first);
            answer.add(last(arr,target));
            return answer;

        }
    }
    
}