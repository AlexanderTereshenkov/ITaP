import java.util.*;
import java.util.regex.Pattern;

public class Problems6 {
    public static void main(String[] args) {
        System.out.println("----- #1");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        System.out.println("----- #2");
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));

        System.out.println("----- #3");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345") );

        System.out.println("----- #4");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));

        System.out.println("----- #5");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println("----- #6");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println("----- #7");
        System.out.println(pilishString("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(pilishString("FORALOOP"));
        System.out.println(pilishString("CANIMAKEAGUESSNOW"));
        System.out.println(pilishString("33314444"));
        System.out.println(pilishString("TOP"));
        System.out.println(pilishString("X"));

        System.out.println("----- #8");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));

        System.out.println("----- #9");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println("----- #10");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
        System.out.println(findLCS("HABRAHABR", "HARBOUR"));

    }

    public static String hiddenAnagram(String input, String anagram){
        input = input.replaceAll(" ", "");
        anagram = anagram.replaceAll(" ", "");
        input = removeSymbols(input).toLowerCase();
        anagram = removeSymbols(anagram).toLowerCase();
        int sliceLen = anagram.length();
        for (int i = 0; i < input.length() - sliceLen + 1; i++) {
            String checkSubString = input.substring(i, i + sliceLen);
            if(checkBothStrings(checkSubString, anagram)) return checkSubString;
        }
        return "notfound";
    }

    private static String removeSymbols(String input){
        String possibleAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String answer = "";
        for(int i = 0; i < input.length(); i++){
            if(possibleAlphabet.indexOf(input.toLowerCase().charAt(i)) != -1) answer += input.charAt(i);
        }
        return answer;
    }

    private static boolean checkBothStrings(String test, String anagram){
        HashMap<Character, Integer> first = getWordsLetters(test);
        HashMap<Character, Integer> second = getWordsLetters(anagram);
        for(Character key : first.keySet()){
            if(!(second.get(key) != null && second.get(key).equals(first.get(key)))) return false;
        }
        return true;
    }

    private static HashMap<Character, Integer> getWordsLetters(String word){
        HashMap<Character, Integer> letters = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            if(letters.get(word.charAt(i)) == null){
                letters.put(word.charAt(i), 1);
            }
            else{
                letters.put(word.charAt(i), letters.get(word.charAt(i)) + 1);
            }
        }
        return letters;
    }

    public static String[] collect(String input, int len){
        ArrayList<String> answer = new ArrayList<>();
        return recursionAdd(answer, len, input).toArray(new String[0]);
    }

    private static ArrayList<String> recursionAdd(ArrayList<String> answer, int len, String input){
        if(input.length() / len == 0){
            Collections.sort(answer);
            return answer;
        }
        answer.add(input.substring(0, len));
        return recursionAdd(answer, len, input.substring(len));
    }

    //3
    public static String nicoCipher(String message, String key){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] keyIndexes = makeKeys(key);
        int lenX = message.length() % keyIndexes.length == 0 ? message.length() / keyIndexes.length : message.length() / keyIndexes.length + 1;
        String[][] hidenWord = new String[lenX][keyIndexes.length];
        int wordIndex = 0;
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < keyIndexes.length; j++) {
                if(wordIndex < message.length()){
                    hidenWord[i][keyIndexes[j] % keyIndexes.length] = String.valueOf(message.charAt(wordIndex));
                    wordIndex++;
                }
                else{
                    hidenWord[i][keyIndexes[j] % keyIndexes.length] = " ";
                }
            }
        }
        String answer = "";
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < keyIndexes.length; j++) {
                answer += hidenWord[i][j];
            }
        }
        return answer;
    }

    public static int[] makeKeys(String key){
        String val = "";
        for(int i = 0; i < key.length() - 1; i++){
            if(key.charAt(i) != key.charAt(i + 1)) val += key.charAt(i);
        }
        val += key.charAt(key.length() - 1);
        char[] letters = val.toCharArray();
        int[] keyIndexes = new int[val.length()];
        Arrays.sort(letters);
        for(int i = 0; i < keyIndexes.length; i++){
            keyIndexes[(key.indexOf(letters[i]))] = i;
        }
        return keyIndexes;
    }
    //4

    public static int[] twoProduct(int[] nums, int result){
        HashSet<Integer> d = new HashSet<>();
        for(Integer elem : nums){
            if(!(d.contains(result / elem) & result % elem == 0)){
                d.add(elem);
            }
            else{
                return new int[]{result / elem, elem};
            }
        }
        return new int[]{};
    }

    public static int[] isExact(int num){
        for (int i = 0; i < 10; i++) {
            if(factorial(i, 1) == num){
                return new int[]{num, i};
            }
        }
        return new int[]{};
    }

    private static int factorial(int n, int tempAnswer){
        if(n == 0) return tempAnswer;
        tempAnswer *= n;
        n--;
        return factorial(n, tempAnswer);
    }

    public static String fractions(String num){
        String[] parts = num.split("\\.");
        String answer;
        int integerPart = Integer.parseInt(parts[0]);
        int ch;
        int zn;
        if(parts[1].charAt(0) == '('){
            ch = Integer.parseInt(parts[1].substring(1, parts[1].length() - 1));
            zn = Integer.parseInt("9".repeat(parts[1].length() - 2));
        }
        else{
            String beforeBracs = "";
            String insideBracs = "";
            int startIndex = parts[1].indexOf('(');
            insideBracs = parts[1].substring(startIndex + 1, parts[1].length() - 1);
            beforeBracs = parts[1].substring(0, startIndex);
            ch = Integer.parseInt(beforeBracs + insideBracs) - Integer.parseInt(beforeBracs);
            zn = Integer.parseInt("9".repeat(insideBracs.length())+"0".repeat(beforeBracs.length()));
        }
        if(integerPart != 0){
            ch = (integerPart * zn) + ch;
        }
        int nod = gcd(ch, zn);
        answer = (ch / nod) + "/" + (zn / nod);
        return answer;
    }

    private static int gcd(int a, int b){
        if(a == 0 || b == 0){
            return a + b;
        }
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        while(max % min != 0){
            int t = max - min;
            max = Math.max(t, min);
            min = Math.min(t, min);
        }
        return min;
    }

    public static String pilishString(String input){
        String pi = "314159265358979";
        int index = 0;
        String answer = "";
        while (input != ""){
            int len = Integer.parseInt(String.valueOf(pi.charAt(index)));
            String temp = superSubString(input, len);
            if(len > input.length()){
                len = input.length();
            }
            input = len == input.length() - 1 ? "" : input.substring(len);
            answer += temp + " ";
            index++;
            if(index == 15) break;
        }
        return answer;
    }

    private static String superSubString(String intputString, int len){
        String ans = "";
        int extraLettersCount = 0;
        if(len > intputString.length()){
            extraLettersCount = len - intputString.length() + 1;
            ans = intputString.substring(0, intputString.length() - 1) + String.valueOf(intputString.charAt(intputString.length() - 1)).repeat(extraLettersCount);
        }
        else{
            ans = intputString.substring(0, len);
        }
        return ans;
    }

    public static String generateNonconsecutive(String input){
        Pattern pattern = Pattern.compile("(\\(*-?\\d+(\\.\\d+)?\\)* [+\\-*/] )*\\(*-?\\d+(\\.\\d+)?\\)*");
        if (!pattern.matcher(input).matches()) {
            return "Ошибка при записи выражения";
        }
        if(!checkBracks(input)) return "Ошибка при записи выражения";

        input = input.replaceAll("\\(", "( ");
        input = input.replaceAll("\\)", " )");
        String[] values = input.split(" ");

        HashMap<String, Integer> ops = new HashMap<>();
        ops.put("+", 1);
        ops.put("-", 1);
        ops.put("*", 2);
        ops.put("/", 2);
        ops.put("(", 3);
        ops.put(")", 3);

        Stack<String> opStack = new Stack<>();
        Stack<Float> nums = new Stack<>();

        String num = "";
        String operations = "(+-/*)";

        for(int i = 0; i < values.length; i++){
            String temp = String.valueOf(values[i]);
            if(temp.equals(")")){
                    if(!num.isEmpty()){
                        nums.push(Float.parseFloat(num));
                        num = "";
                    }
                    String o = opStack.pop();
                    switch (o){
                            case "+":
                                nums.push(nums.pop() + nums.pop());
                                break;
                            case "-":
                                nums.push(-nums.pop() + nums.pop());
                                break;
                            case "*":
                                nums.push(nums.pop() * nums.pop());
                                break;
                            case "/":
                                float num2 = nums.pop();
                                float num1 = nums.pop();
                                if (num2 == 0){
                                    return "Деление на 0";
                                }
                                else{
                                    nums.push(num1 / num2);
                                }
                                break;
                        }
                        opStack.pop();
            }
            if(!operations.contains(temp)) {
                num += temp;
            }
            else{
                if(!num.isEmpty()){
                    nums.push(Float.parseFloat(num));
                    num = "";
                }
                if(opStack.isEmpty() || ops.get(opStack.peek()) < ops.get(temp)){
                    opStack.push(temp);
                }
                else if (!opStack.isEmpty() && ops.get(opStack.peek()) >= ops.get(temp)) {
                    if(opStack.peek().equals("(")){
                        opStack.push(temp);
                        continue;
                    }
                    String o = opStack.pop();
                    switch (o){
                        case "+":
                            nums.push(nums.pop() + nums.pop());
                            break;
                        case "-":
                            nums.push(nums.pop() - nums.pop());
                            break;
                        case "*":
                            nums.push(nums.pop() * nums.pop());
                            break;
                        case "/":
                            float num2 = nums.pop();
                            float num1 = nums.pop();
                            if (num2 == 0){
                                return "Деление на 0";
                            }
                            else{
                                nums.push(num1 / num2);
                            }
                            break;
                    }
                    opStack.push(temp);
                }
            }
            if(i == input.length() - 1){
                if(!num.isEmpty()) nums.push(Float.parseFloat(num));
            }
        }
        while (!opStack.isEmpty()){
            String o = opStack.pop();
            switch (o){
                case "+":
                    nums.push(nums.pop() + nums.pop());
                    break;
                case "-":
                    nums.push(-nums.pop() + nums.pop());
                    break;
                case "*":
                    nums.push(nums.pop() * nums.pop());
                    break;
                case "/":
                    float num2 = nums.pop();
                    float num1 = nums.pop();
                    if (num2 == 0){
                        return "Деление на 0";
                    }
                    else{
                        nums.push(num1 / num2);
                    }
                    break;
            }
        }
        return String.valueOf(nums.pop());
    }

    public static boolean checkBracks(String input){
        int s = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '(') s++;
            if(input.charAt(i) == ')') s--;
        }
        return s == 0;
    }

    public static String isValid(String input){
        HashMap<Character, Integer> letters = getWordsLetters(input);
        int errorsCount = 0;
        ArrayList<Integer> letCount = new ArrayList<>();
        for(Character key : letters.keySet()){
            letCount.add(letters.get(key));
        }
        int maxCount = Collections.min(letCount);
        for (int i = 0; i < letCount.size(); i++) {
            if(letCount.get(i) != maxCount){
                if(Math.abs(letCount.get(i) - maxCount) == 1){
                    errorsCount++;
                }
                else{
                    return "NO";
                }
            }
        }
        return errorsCount > 1 ? "NO" : "YES";
    }

    public static String findLCS(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] matrix = new int[len1 + 1][len2 + 1];
        for(int i = 1; i < len1 + 1; i++){
            for (int j = 1; j < len2 + 1; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                }
                else{
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        ArrayList<String> answer = new ArrayList<>();
        String ans = "";
        while (len1 >= 0 & len2 >= 0){
            if(len1 - 1 >= 0 & len2 - 1 >= 0){
                if(s1.charAt(Math.max(len1 - 1, 0)) == s2.charAt(Math.max(len2 - 1, 0))){
                    answer.add(String.valueOf(s1.charAt(len1 - 1)));
                    len1--;
                    len2--;
                }
                else if(matrix[len1-1][len2] > matrix[len1][len2-1]){
                    len1--;
                }
                else{
                    len2--;
                }
            }
            else{
                break;
            }
        }
        Collections.reverse(answer);
        for(var elem : answer){
            ans += elem;
        }
        return ans;
    }
}
