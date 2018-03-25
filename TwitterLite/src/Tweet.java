public class Tweet {
    private String userId;
    private String msg;


    public Tweet(String userId, String msg) {
        this.userId = userId;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
