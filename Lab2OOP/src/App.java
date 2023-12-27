public abstract class App {
    protected String name;
    protected String version;
    protected int numberOfUsers;

    public App(String name, String version, int numberOfUsers){
        this.name = name;
        this.version = version;
        this.numberOfUsers = numberOfUsers;
    }

    public App(){
        name = "untitled";
        version = "none";
        numberOfUsers = 0;
    }


    public void sendNotification(String userName){
        System.out.println("Hello, " + userName);
    }

    public void showInfo(){
        System.out.println("info");
    }

    public void showInfo(String userName){
        System.out.println("info for " + userName);
    }

}
