public class Messenger extends SocialNetwork{
    private String message;
    private boolean isUserOnline;
    private int friendsCount;
    public Messenger(int friendsCount){
        this.friendsCount = friendsCount;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public int getFriendsCount(){
        return friendsCount;
    }
    public void deleteFriend(){
        friendsCount--;
    }
    public void addFriend(){
        friendsCount++;
    }
}
