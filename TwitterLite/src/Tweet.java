/**
 * This class models a Tweet. Tweet has a user ID of its creator and the massage as a String.
 * Tweet can only be created by calling static createTweet method
 * by sending a user id and a massage as parameters.
 *
 * @author Yuki Yamada
 * @author Aleix Molla
 * @version 2018/03/30
 */
public class Tweet {
    private String userId;
    private String msg;

    private Tweet(String userId, String msg) {
        this.userId = userId;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param userId
     * @param msg
     * @return
     */
    public static Tweet createTweet (String userId, String msg){
        return new Tweet(userId, msg);
    }

    public String toString(){
        return userId + ":  " + msg;
    }

}
