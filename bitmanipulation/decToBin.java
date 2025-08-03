public class decToBin{
    static String DtoB(int dec){
        StringBuilder result = new StringBuilder();
        while(dec>0){
            result.append(dec%2==0?'0':'1');
            dec/=2;
        }
        String str ="";
        for(int i=result.length()-1 ;i>=0;i--){
            str+=result.charAt(i);
        }
        return str;
    }

    static int BtoD(String Bin){
        int result=0 ;
        int pow=1;
        for(int j=Bin.length()-1;j>=0;j--){
            if(Bin.charAt(j)=='1'){
                result+=pow;
            }
            pow*=2;
        }
        return result;
    }

    
    public static void main(String[] args) {
     System.out.println(DtoB(6));   
     System.out.println(BtoD("110"));
    }
}