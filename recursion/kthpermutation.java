import java.util.ArrayList;
import java.util.List;

public class kthpermutation {
    static void kthperm(String str,int n,int k){
       int blocksize=1;
       List<Character> chars = new ArrayList<>();
       for(int i = 1; i <= n; i++) {
            blocksize = blocksize * i;
            chars.add(str.charAt(i - 1));  // now includes all n characters
        }
       blocksize = blocksize / n;
       //intial blocksize acchieved (n-1)! 
       k=k-1 ; //zero based index for kth permutation
       String ans="";
       while(true){
        int blocknumber =k/blocksize;
        ans+=chars.get(blocknumber);
        chars.remove(blocknumber);

        if(chars.size()==0){
            System.out.println(ans);
            return;
        }

        //new k vlaue inside the block
        k=k%blocksize;

        //size of new blocks
        blocksize= blocksize/chars.size();
        
       }
        
    }
    public static void main(String[] args) {
        String str ="1234";
        kthperm(str,str.length(), 17);
    }
}
