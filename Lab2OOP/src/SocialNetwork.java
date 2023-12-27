
public class SocialNetwork extends App{
    private boolean isDarkModeOn;
    private String ui;
    public static int copiesOfClass;

    public SocialNetwork(){
        copiesOfClass++;
    }

    @Override
    public void showInfo(){
        ui = isDarkModeOn ? "DARK_MODE_UI" : "LIGHT_MODE_UI";
        System.out.println("Включена " + (isDarkModeOn ? "теманя" : "светлая") + " тема");
    }

    public void setDarkModeOn(boolean value){
        isDarkModeOn = value;
    }
    public String getUi() { return ui; }

    public void showSecretData(){
        System.out.println(super.name + " " + super.version + " " + super.numberOfUsers);
    }

    public int getCounter(){
        return copiesOfClass;
    }
}
