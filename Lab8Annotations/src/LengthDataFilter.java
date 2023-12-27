import java.util.ArrayList;

@DataProcessor
 class LengthDataFilter {
    @DataProcessor
    public ArrayList<String> callable(ArrayList<String> data){
        return new ArrayList<>(data.stream()
                .filter(x -> x.length() > 8)
                .sorted()
                .toList());
    }

}
