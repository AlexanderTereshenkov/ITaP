import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String password = "123wfwf";
        Pattern p = Pattern.compile("(?=\\w*124)\\w+");
        Matcher m = p.matcher(password);
        boolean isCorrect = false;
        while(m.find()){
            isCorrect = true;
            System.out.println(m.group());
        }
        if(!isCorrect) System.out.println("Введен некорретный пароль");
    }
}
