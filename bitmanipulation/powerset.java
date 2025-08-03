import java.util.ArrayList;
import java.util.List;

public class powerset {

    static void powersetsolve(String str,List<String> result){
        for(int i =0 ;i<(1<<str.length());i++){
            String tempstr="";
            for(int j =0 ;j<str.length();j++){
                if((i&(1<<j))!=0){
                    tempstr+=str.charAt(j);
                }
            }
            result.add(tempstr);

        }
    }

    public static void main(String[] args) {
        String n="123";
        List<String> result = new ArrayList<>();
        powersetsolve("123", result);
        for(String i : result){
            System.out.println(i);
        }


    }
    
}
