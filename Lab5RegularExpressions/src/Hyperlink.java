import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hyperlink {
    public static void main(String[] args) {
        String linksText = "www.vk.com best site in the world. But i prefer telegram.org/secrets/secrets.txt";
        Pattern p = Pattern.compile("\\b([a-z]{2,}\\.)?[a-z0-9]{2,}\\.[a-z0-9]{2,}(\\/[a-z0-9\\-]*(\\.[a-z]{2,})*)*\\b");
        Matcher m = p.matcher(linksText);
        while(m.find()){
            linksText = linksText.replaceAll(m.group(), "https://" + m.group());
        }
        System.out.println(linksText);
    }
}
