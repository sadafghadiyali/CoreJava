/*
Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.

You are given  lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in  position of  line.

Take your input from System.in.

Input Format
The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. In the next line there will be an integer  denoting number of queries. Each query will consist of two integers  and .

Constraints

Each number will fit in signed integer.
Total number of integers in  lines will not cross .

Output Format
In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"

Sample Input

5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
Sample Output

74
52
37
ERROR!
ERROR!
 */
import java.util.*;

public class ArrayListChallengeMain {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> s = new ArrayList<>();
        sc.nextLine();
        for(int i = 0;i<n;i++){

            int size = sc.nextInt();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j =0 ;j<size;j++){
                temp.add(sc.nextInt());
            }
            sc.nextLine();
            s.add(temp);
        }
        int q = sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>() ;
        for(int i=0;i<q;i++){
            ArrayList<Integer> temp2 = new ArrayList<>();
            for(int j=0; j<2; j++){
                temp2.add(sc.nextInt());
            }
            sc.nextLine();
            queries.add(temp2);
        }

//        System.out.println("+++++++NUMBERS+++++++\n"+s);
//        System.out.println("\n+++++++++QUERIES++++++\n"+queries);

        for(int k=0; k<queries.size();k++){
            int x= queries.get(k).get(0) -1 ;
            int y= queries.get(k).get(1) -1;

//            System.out.println( "\n x = "+x +" y = "+y +
//                    " ;\n s size = "+s.size() +" s x size() = "+s.get(x).size());
            if(x<s.size() && y<s.get(x).size() ){
                System.out.println(s.get(x).get(y));
            }
            else{
                System.out.println("ERROR !!");
            }
        }



    }
}
