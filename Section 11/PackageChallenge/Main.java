import com.CoreJava.PackageDemo.Series;

public class Main {

    public static void main(String[] args){
        //Series series=new Series();
        System.out.println("********SUM********");
        for(int i=0;i<10;i++){
            System.out.println(Series.nSum(i));
        }
        System.out.println("********FACTORIAL********");
        for(int i=0;i<10;i++){
            System.out.println(Series.factorial(i));
        }
        System.out.println("********FIBONACCI********");
        for(int i=0;i<10;i++){
            System.out.println(Series.fibonacci(i));
        }


    }

}
