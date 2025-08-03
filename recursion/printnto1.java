

public class printnto1{

    static void Nto1(int n){
        if(n==0)return;
        System.out.println(n);
        Nto1(n-1);
    }
    static void Nto1backtrack(int i,int n){
        if(i>n)return;
        Nto1backtrack(i+1, n);
        System.out.println(i);
    }
    static void _1toN (int n){
        if(n==0)return;
        _1toN(n-1);
        System.out.println(n);
    }
    static void NameNtime(String str,int n){
        if(n==0)return;
        System.out.println(str);
        NameNtime(str, n-1);
    }

    static int sumofN(int n){
        if(n==1)return 1;
        return n + sumofN(n-1);
    }
    static int Factorial(int n){
        if(n==0) return 1;
        return n * Factorial(n-1);
    }

    static void reverseArray(int arr[],int l ,int r){
        if(l>r)return;
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
        reverseArray(arr, l+1, r-1);
    }
    static boolean pallendrome(String str , int i){
        if(i>=str.length()/2)return true;
        else if(str.charAt(i)!=str.charAt(str.length()-i-1))return false;
        return pallendrome(str, ++i);
    }

    static int fibo(int n){
        if(n==1|| n==0)return n;
        return fibo(n-2)+fibo(n-1);
    }

    public static void main(String[] args) {
        //Nto1(10);
        //_1toN(10);
        //NameNtime("sarthak",5);
        //Nto1backtrack(1, 5);
        //System.out.println(sumofN(5));
        //System.out.println(Factorial(4));
        int arr[] =  {1,2,3,4,5,6} ;
        reverseArray(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println(pallendrome("saasss", 0));
        System.out.println(fibo(5));
        //System.out.println(arr););
    }
}