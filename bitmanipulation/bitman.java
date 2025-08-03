public class bitman {
    static void checkithbit(int n,int i){
        if((n & (1<<i))==0){
            System.out.println(" ith not set");
        }
        else{
            System.out.println("ith Set");
        }
    }

    static int setting_ith_bit(int n ,int i){
        return (n | (1<<i));
    }

    static int clearing_ith_bit(int n ,int i){
        return (n & (~(1<<i)));
    }

    static int remove_last_setbit(int n){
        return n&(n-1);
    }

    static boolean is_power_of2(int n){
       return n > 0 && (n & (n - 1)) == 0;
    }
    static int number_of_setBits(int n){
        int count=0;
        while(n!=0){
            n= (n&n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
    
}
