package love.mmjj.server.bean;

/**
 * @ClassName SolveHistory
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
public class SolveHistory {
    private String account;
    private int questionID;
    private int type;

    public static final int SOLVED = 1;
    public static final int ERROR = 2;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
