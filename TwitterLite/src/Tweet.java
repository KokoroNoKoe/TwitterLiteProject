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
