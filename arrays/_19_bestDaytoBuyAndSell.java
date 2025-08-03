public class _19_bestDaytoBuyAndSell {
    static void maxProfit(int arr[]){

        int min =arr[0] ,maxProfit=0,profit=0;

        int start=0 ,end=0,minindex=0;

        for(int i=1;i<arr.length;i++){
            profit=arr[i]-min;
            if(profit>maxProfit){
                maxProfit=profit;
                start=minindex;
                end=i;
            }
            if(min>arr[i]){
                min=arr[i];
                minindex=i;
            }
        }

        System.out.println("Max Profit : "+ maxProfit);
        System.out.println("Buy on : "+start +" Sell on : "+end);


    }
    public static void main(String[] args) {
        int cost[]={1,7,1,5,3,6,4};
        maxProfit(cost);
    }
}