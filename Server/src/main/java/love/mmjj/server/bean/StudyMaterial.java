package love.mmjj.server.bean;

/**
 * @ClassName StudyMaterial
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
public class StudyMaterial {
    private String url;
    private String title;
    private String demand;
    private String tags;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
