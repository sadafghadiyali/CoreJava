/*
Write a method named getEvenDigitSum with one parameter of type int called number.

The method should return the sum of the even digits within the number.

If the number is negative, the method should return -1 to indicate an invalid value.


EXAMPLE INPUT/OUTPUT:

* getEvenDigitSum(123456789); → should return 20 since 2 + 4 + 6 + 8 = 20

* getEvenDigitSum(252); → should return 4 since 2 + 2 = 4

* getEvenDigitSum(-22); → should return -1 since the number is negative


NOTE: The method getEvenDigitSum should be defined as public static like we have been doing so far in the course.

NOTE: Do not add a main method to the solution code.
*/

public class EvenDigitSum {
    // write your code here
    
    public static int getEvenDigitSum(int num){
        if(num>=0){
        int n=num;
        int sum=0;
        while(n>0){
            if(n%2==0){
                sum=sum + n%10;
                
            }
            n=n/10;
        }
        return sum;
    }
    return -1;
    }
    
    
}