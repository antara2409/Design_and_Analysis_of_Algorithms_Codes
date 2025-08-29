import java.util.*;

public class LISTest {
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=input.nextInt(); // get number of elements required
        int []arr=new int[n];
        System.out.println("Enter array: ");
        for(int i=0;i<n;i++){ // enter array
            arr[i]=input.nextInt(); 
        }
        input.close();
        List<Integer> lis = LIS.getLIS(arr);
        System.out.println("Longest Increasing Subsequence: "+lis+" Length="+lis.size()); // print subsequence and length
    }
}
