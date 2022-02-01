import java.util.Scanner;
public class MinimumElement {
    // write code here
    
    
    private static int readInteger(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        return n;
    }
     private static int[] readElements(int size){
        Scanner sc = new Scanner(System.in);
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        return arr;
    }
    
    private static int findMin(int[] arr){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(min > arr[i]){
                min=arr[i];
            }
        }
        return min;
    }
    
}