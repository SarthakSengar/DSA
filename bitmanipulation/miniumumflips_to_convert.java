public class miniumumflips_to_convert {

    static int count(int num1,int num2){
        int disitinctbitsetto1 =num1^num2;
        int count=0;

        //count the set bits
        while (disitinctbitsetto1!=0){
            count++;
            disitinctbitsetto1=disitinctbitsetto1&(disitinctbitsetto1-1);
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
    
}