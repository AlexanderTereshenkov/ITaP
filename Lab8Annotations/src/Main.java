
public class Main {
    public static void main(String[] args){
        LengthDataFilter lengthDataFilter = new LengthDataFilter();
        UpperCaseDataFilter upperCaseDataFilter = new UpperCaseDataFilter();
        DataManager dataManager = new DataManager("Output.txt");
        dataManager.registerDataProcessor(lengthDataFilter);
        dataManager.registerDataProcessor(upperCaseDataFilter);
        dataManager.loadData("Data.txt");
        dataManager.processData();
    }
}