import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        //match "I want a bike."
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        System.out.println(challenge1.matches("I want a bike."));

        //match strings starting with "I want a"
        String regExp1 = "I want a \\w+.";
        System.out.println(challenge1.matches(regExp1));
        System.out.println(challenge2.matches(regExp1));

        //Use Matcher.matches for above
        String regExpPattern = "(I want a \\w+.)";
        Pattern pattern = Pattern.compile(regExpPattern);
        Matcher matcher1 = pattern.matcher(challenge1);
        System.out.println(matcher1.matches());
        Matcher matcher2 = pattern.matcher(challenge2);
        System.out.println(matcher2.matches());

        //Replace all blanks with underscores
        String challenge3 = "Replace all blanks with underscores.";
        System.out.println(challenge3.replaceAll("\\s","_"));

        //match the string
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[abcdefg]+"));

        //Match the string exactly
        String regExp6 = "^a{3}bc{8}d{3}ef{3}g$";
        System.out.println(challenge5.matches(regExp6));

        //Match a string which starts with a series of letters. letters must be followed by a period. After the period, there must be a series of digits
        String challenge7 = "Bbcd.135";
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+"));

        //pattern to find the occurences of digits in a string
        String challenge8 = "abcd.135uvqz.7tzik.999";
        String regExp8 = "(\\d+)";
        Pattern pattern8 = Pattern.compile(regExp8);
        Matcher matcher8= pattern8.matcher(challenge8);
        int count=0;
        while(matcher8.find()){
            count++;
            System.out.println("Occurence "+count+": "+matcher8.group(1));
        }

        //pattern to find the occurences of digits in a string
        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
        String regExp10 = "(\\d+)";
        Pattern pattern10 = Pattern.compile(regExp10);
        Matcher matcher10= pattern8.matcher(challenge10);
        count=0;
        while(matcher10.find()){
            count++;
            System.out.println("Occurence "+count+" starts at "+matcher10.start(1) +" and ends at "+(matcher10.end(1)-1)+": "+matcher10.group(1));
        }

        //Extract what is in curly braces
        String challenge11= "{0, 2}, {0, 5}, {1, 3}, {x, y}, {2, 4} ";
        String regExp11 = "\\{(\\d\\, \\d)(\\})(\\,*\\s*)";

        Pattern pattern11 = Pattern.compile(regExp11);
        String regExp11_2 = "\\d";
        System.out.println("==========================");
        Matcher matcher11 = pattern11.matcher(challenge11);
        while(matcher11.find()){
            System.out.println("Occurence: "+matcher11.group(1));
        }

        //match a 5 digit zip code
        String challenge12 = "11111";
        String regExp12 = "^[\\d]{5}$";
        System.out.println(challenge12.matches(regExp12));

        //match zipcode with 5 digits then "-" then again 4 digits
        String challenge13 = "11111-1111";
        String regExp13 = "^[\\d]{5}\\-[\\d]{4}$";
        System.out.println(challenge13.matches(regExp13));

        //match zipcode with 5 digits then OPTIONAL "-" then again 4 digits
        String challenge14_1 = "11111";
        String challenge14_2 = "11111-1111";
        String regExp14 = "^[\\d]{5}(-\\d{4})?$";
        System.out.println(challenge14_1.matches(regExp14));
        System.out.println(challenge14_2.matches(regExp14));






    }
}
