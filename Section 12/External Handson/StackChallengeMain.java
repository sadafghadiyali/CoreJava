/*
A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input

{}()
({()})
{}(
[]
Sample Output

true
true
false
true
Welco
 */

import java.util.*;
class StackChallengeMain{

    public static void main(String []argh) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        List<Character> braces;

        while (sc.hasNext()) {
            braces = new ArrayList<>();
            String input=sc.next();
            boolean op =true;
            //System.out.println(input);
            //Complete the code
            for(int i =0; i<input.length();i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                    braces.add(input.charAt(i));
                }
                    if (input.charAt(i) == ')') {
                        //System.out.println("input = "+input);
                        if(braces.size()>0){
                        if (braces.get(braces.size() - 1) == '(') {
                            braces.remove(braces.size() - 1);
                        }else{
                            op=false;
                            //System.out.println("false");
                            //break;
                        }
                        }else op = false;
                    }
                    if (input.charAt(i) == ']') {
                        //System.out.println("input = "+input);
                        if(braces.size()>0){
                        if (braces.get(braces.size() - 1) == '[') {
                            braces.remove(braces.size() - 1);
                        }else{
                            op=false;
                            //System.out.println("false");
                            break;
                        }}else op = false;
                    }
                    if (input.charAt(i) == '}') {
                        //System.out.println("input = "+input);
                        if(braces.size()>0){
                        if (braces.get(braces.size() - 1) == '{') {
                            braces.remove(braces.size() - 1);
                        }
                        else{
                            op=false;
                            //System.out.println("false");
                            break;
                        }}else op = false;
                }
            }if(braces.size()==0 && op!=false){
                System.out.println("true");
            }else if(braces.size()>0 || op == false){
                System.out.println("false");
            }

        }
    }
}




