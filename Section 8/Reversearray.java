import java.util.*;
public class ReverseArray {
    // write code here
    
    private static void reverse(int[] arr){
        System.out.println("Array = "+Arrays.toString(arr));
        
        int j=arr.length-1;
        int temp;
        for(int i=0;i<arr.length/2;i++){
            temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
            j--;
        }
        System.out.print("Reversed array = "+Arrays.toString(arr));
    }
}