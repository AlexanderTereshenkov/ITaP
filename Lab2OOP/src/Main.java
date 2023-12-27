public class Main {
    public static void main(String[] args) {
        Game game = new Game("Unity");
        game.setPlatform("Android");
        System.out.println(game.getPlatform() + " " + game.getEngine() + " " + game.numberOfUsers);
        game.setUserName("Player1111");
        game.sendNotification(game.getUserName());
        System.out.println();

        SocialNetwork socialNetwork1 = new SocialNetwork();
        SocialNetwork socialNetwork2 = new SocialNetwork();
        SocialNetwork socialNetwork3 = new SocialNetwork();
        System.out.println(socialNetwork3.getCounter());
        socialNetwork2.setDarkModeOn(true);
        socialNetwork2.showInfo();
        System.out.println(socialNetwork2.getUi());
        socialNetwork2.showSecretData();
        System.out.println();

        Messenger messenger = new Messenger(5);
        messenger.showInfo();
        messenger.addFriend();
        System.out.println(messenger.getFriendsCount());
        System.out.println();

        WeatherApp weatherApp = new WeatherApp("Москва", 15.5f, "Владимир");
        weatherApp.showInfo(weatherApp.getUserName());
    }
}