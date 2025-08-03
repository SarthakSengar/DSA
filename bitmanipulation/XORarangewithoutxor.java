public class XORarangewithoutxor {
    // 1 3 0 4 , 1 7 0 8 ,1 11 0 12 
    static int findXor(int n ){
        if(n%4==1)return 1;
        else if(n%4==2) return n+1;
        else if(n%4==3) return 0;
        else return n;
    }

    static int xorRange (int l ,int r){
        int _1toL = findXor(l);
        int _1toR =findXor(r); 
        return _1toL^_1toR ;
    }
    public static void main(String[] args) {
        int n=10;
        System.out.println(findXor(n));
        System.out.println(xorRange(10, 20));
    }
    
}
