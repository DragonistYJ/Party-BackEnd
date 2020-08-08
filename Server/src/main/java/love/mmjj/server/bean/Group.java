package love.mmjj.server.bean;

/**
 * @ClassName Group
 * @Author 11214
 * @Date 2020/3/17
 * @Description TODO
 */
public class Group {
    private String account;
    private int groupID;
    private String groupName;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
