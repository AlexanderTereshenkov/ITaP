import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String s = "e23 43o434 asdsad 12321.213213.";
        Pattern p = Pattern.compile("\\b\\d+(\\.\\d+)?\\b");
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}