import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.next();
        String text = "Sample text for testing regular expression";
        Pattern p = Pattern.compile("\\b" +"[" + letter.toUpperCase() + letter.toLowerCase() + "]" + "\\w*\\b");
        Matcher m = p.matcher(text);
        while(m.find()){
            System.out.println(m.group());
        }
    }
}
