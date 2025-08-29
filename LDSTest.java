import java.util.*;

public class LDSTest {
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=input.nextInt();
        int []arr=new int[n];// get number of elements required
        System.out.println("Enter array: ");
        for(int i=0;i<n;i++){ // enter array
            arr[i]=input.nextInt();
        }
        input.close();
        List<Integer> lds = LDS.getLDS(arr);
        System.out.println("Longest Divisible Subset: "+lds+" Length="+lds.size()); // print subset and length
    }
}
