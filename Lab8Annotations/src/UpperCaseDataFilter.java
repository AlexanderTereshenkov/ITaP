import java.util.ArrayList;

@DataProcessor
public class UpperCaseDataFilter {
    @DataProcessor
    public ArrayList<String> filterData(ArrayList<String> data){
        return new ArrayList<>(data.stream()
                .map(String::toUpperCase)
                .toList());
    }
}
