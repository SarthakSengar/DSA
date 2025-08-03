public class singlenumber {
    //Single number 1 (pair off two and a single to find)
    static int find1(int arr[]){
        int result=0;
        for(int i :arr){
            result^=i;
        }
        return result;
    }

    //single number 2 (pairs of 3 an done single to find)
    static int find(int arr[]){
        int ones=0 ,twos=0;
        for(int i : arr){
            ones= (ones^i)&(~twos);
            twos= (twos^i)&(~ones);
        }
        return ones;
    }

    //single number 3 (pairs of 2 and two singles to find)
    static void find3(int arr[]){
        int result=0;
        for(int i :arr){
            result^=i;
        }
        int firstbitset = (result&result-1)^result;

        int num1 =0;
        int num2=0;

        for(int i :arr){
            if((i ^ firstbitset) == 0){
                num2^=i;
            }else{
                num1^=i;
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }
    public static void main(String[] args) {

        int arr1[]={2,6,6,2,3};
        int arr2[]={1,1,1,2,6,2,2,3,3,3};
        int arr3[]={1,1,2,3,3,4,5,5,6,6};
        System.out.println(find(arr2));
        System.out.println(find1(arr1));
        find3(arr3);
    }
}
