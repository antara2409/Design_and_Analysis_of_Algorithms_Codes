import java.util.*;

public class LDS {
    static List<Integer> getLDS(int []num){
        Arrays.sort(num);// sort array
        // if array is empty or null then return empty list
        if(num==null || num.length==0){ 
            return Collections.emptyList();
        }
        int []dp=new int[num.length]; // array to keep track of maximum length
        int []prev=new int[num.length];  // array to store prev index for reconstruction
        Arrays.fill(dp,1);  // initialize dp with 1 ( minimum possible length )
        Arrays.fill(prev,-1); // initialize prev with -1 
        int maxLength=0; // variable to keep track of longest subsequence
        int lastIndex=-1; // variable to store last elemnts index
        for(int i=1;i<num.length;i++){ // iterate over all elements
            for(int j=0;j<i;j++){ // iterate over all previous elements
                if(num[i]%num[j]==0 && dp[j]+1>dp[i]){ // check for increasing length and divisible numbers
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
        LinkedList<Integer> lds=new LinkedList<>();
         // this if condition is not necessary but for extra safety to check if it is modified or not
        if(lastIndex!=-1){
            while(lastIndex!=-1){
                lds.addFirst(num[lastIndex]); // add element to first position
                lastIndex=prev[lastIndex];  // get previous elements index for current element
            }
        }
        return lds;
    }
}
