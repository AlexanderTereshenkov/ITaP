public class Game extends App{
    private String engine;
    private String platform;
    private String userName;

    public Game(String engine){
        super("Maze", "v1.0.5", 50);
        this.engine = engine;
    }

    @Override
    public void sendNotification(String userName){
        System.out.println(userName + ", Вы давно не заходили в " + super.name);
    }

    public void setPlatform(String platform){
        this.platform = platform;
    }
    public String getPlatform(){
        return platform;
    }
    public String getEngine(){
        return engine;
    }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserName() { return userName; }

}
