import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAdress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Pattern p = Pattern.compile("^(2[0-5][0-5]\\.|1[0-9][0-9]\\.|[1-9][0-9]\\.|[0-9]\\.){3}(2[0-5][0-5]|1[0-9][0-9]|[1-9][0-9]|[0-9]){1}$");
        Matcher m = p.matcher(s);
        boolean isCorrect = false;
        while (m.find()) {
            isCorrect = true;
            System.out.println("Введен корректный ip адресс: " + s);
        }
        if(!isCorrect) System.out.println("Введен неверный ip адресс");
    }
}
