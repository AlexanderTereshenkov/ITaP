import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        Pattern p = Pattern.compile("(?=[a-zA-Z0-9]*[0-9])(?=[a-zA-Z0-9]*[A-Z])[a-zA-Z0-9]{8,16}");
        Matcher m = p.matcher(password);
        boolean isCorrect = false;
        while(m.find()){
            isCorrect = true;
            System.out.println("Пароль корректен");
        }
        if(!isCorrect) System.out.println("Введен некорретный пароль");
    }
}
