public class WeatherApp extends App{
    private String city;
    private float temperature;
    private String userName;

    WeatherApp(String city, float temperature, String userName){
        super("WeatherApp", "v0.0.1", 1350);
        this.city = city;
        this.temperature = temperature;
        this.userName = userName;
    }

    @Override
    public void showInfo(String userName){
        System.out.println("Здравствуйте, " + userName + ". Сегодня в " + city + " температура " + temperature
        + " градусов" + "\nВерсия приложения " + super.version);
    }

    public String getUserName(){
        return userName;
    }

}
