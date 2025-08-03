public class dividingwihtoutDivision {
    //striver 
    static int divide(int num ,int div){


        if (div == 0) return 0 ;
        if (num == Integer.MIN_VALUE && div == -1) return Integer .MAX_VALUE
;

        boolean negative = false;
        if(num<0 && div>0) negative =true;
        if(num>0 && div<0) negative= true;

        long numt= Math.abs(num);
        long divt =Math.abs(div);

        //keep subtracting mac div * power of 2 till possible
        int result = 0; 
        while(num >=div){
            int power =0;
            while(num>=(div<<power)){
                power++;
            }
            num = num-(div<<(power-1));
            result +=(1<<power-1);
        }

        return negative ? - result : result;
    }
    public static void main(String[] args) {

        int n=22;
        int d =3;
        System.out.println(divide(n, d));

    }
    
}
