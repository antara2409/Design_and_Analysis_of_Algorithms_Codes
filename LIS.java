import java.util.*;
class LIS{
    static List<Integer> getLIS(int []num){
        // if array is empty or null then return empty list
        if(num==null || num.length==0){
            return Collections.emptyList();
        }
        int []dp=new int[num.length]; // array to keep track of maximum length
        int []prev=new int[num.length]; // array to store prev index for reconstruction
        Arrays.fill(dp,1); // initialize dp with 1 ( minimum possible length )
        Arrays.fill(prev,-1); // initialize prev with -1 
        int maxLength=0; // variable to keep track of longest subsequence
        int lastIndex=-1; // variable to store last elemnts index
        for(int i=1;i<num.length;i++){ // iterate over all elements
            for(int j=0;j<i;j++){ // iterate over all previous elements
                if(num[i]>num[j] && dp[j]+1>dp[i]){ // check for increasing length and numbers
                    // update dp and prev array
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            // update maxLength and lastIndex 
            if(dp[i]>maxLength){
                maxLength=dp[i];
                lastIndex=i;
            }
        }
        // Linked list allow to preserve order and trverse accordingly hence chosen linked list over array
        LinkedList<Integer> lis=new LinkedList<>();
        // this if condition is not necessary but for extra safety to check if it is modified or not
        if(lastIndex!=-1){
            while(lastIndex!=-1){
                lis.addFirst(num[lastIndex]); // add element to first position
                lastIndex=prev[lastIndex]; // get previous elements index for current element
            }
        }
        return lis;
    }
}