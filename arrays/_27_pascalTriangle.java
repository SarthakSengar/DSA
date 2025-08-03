public class _27_pascalTriangle {
    //three qurstion 
    //1.print r,c th element row start and col start from 1

    //2.print ith row row nuber start from 1

    //3.print pascal triangle of n rows

    //answer 1 : T: O(r)
    static int R_C_element(int r ,int c){
        //r-1 C c-1 
        return nCr(r-1,c-1);
    }
    static int nCr(int n,int r){
        int num =1, den=1;
        for(int i =0;i<r;i++){
            num *= n-i;
            den *= (i+1);
        }
        return num/den;
    }

    //anser 2 : printing row one solution is callinng above function for each row element
    static void pascalRow(int r){
        //each row in pascal triangle has columna equal to row number 
        for(int i=1;i<=r;i++){
            System.out.println(R_C_element(r, i));
        }
    }
    //second approach is instead of using the function n time giving O(n*r) complexity 

    //O(r);
    static void optimalRow(int r){
        int ans=1;
        System.out.print(ans+ " ");
        for(int i=1;i<r;i++){
            ans*=r-i;
            ans/=i;
            System.out.print(ans+" ");
        }
        System.out.println();
    }

    //printing triangle 
    //brute call formula for each rand column O(n^3)
    //best calling row fucntion for each row
    //O(r^2)
    static void pascalTiriangle(int r){
        for(int i=1;i<=r;i++){
            optimalRow(i);
        }
    }
    public static void main(String[] args) {
        System.out.println(R_C_element(6, 5));
        optimalRow(5);
        pascalTiriangle(6);

    }
}
