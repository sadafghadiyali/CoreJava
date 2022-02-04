package com.CoreJava.PackageDemo;

public class Series {

    public static int nSum(int n){
        int sum = (n * (n+1))/2;
        return sum;
    }
    public static int fibonacci(int n){

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int firstPrev=0;
        int secondPrev=1;
        int i=0;
        int temp;
        while(i<n){
            temp = firstPrev;
            firstPrev = secondPrev;
            secondPrev += temp ;
            i++;
        }
        return secondPrev;
    }
    public static int factorial(int n){
        int fact = 1;
        int i=0;
        for (i = n; i>0 ; i--){
            fact = fact*i;
        }
        return fact;
    }

}
