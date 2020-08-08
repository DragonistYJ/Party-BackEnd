import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName NewsSpider
 * @Author 11214
 * @Date 2020/3/12
 * @Description TODO
 */
public class NewsSpider implements PageProcessor {
    private Connection connection;

    public NewsSpider() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://121.43.160.139:3306/party?useSSL=false", "mmjj", "02080328");
    }

    @Override
    public void process(Page page) {
        Selectable selectable = page.getHtml().css("body > div.p2j_con02.clearfix.w1000 > div.fl").$("ul > li");
        Selectable href = selectable.$("a", "href");
        page.addTargetRequests(href.all());

        if (page.getRequest().getUrl().startsWith("http://dangjian.people.com.cn/n1")) {
            Html html = page.getHtml();
            String title = html.css("body > div.p2j_con03.clearfix.w1000 > div.text_con.text_con01 > div > h1").get();
            title = title.substring(4, title.length() - 5);
            title = title.replaceAll("&nbsp", "").replaceAll("<br>", "");
            System.out.println(title);

            String time = html.css("body > div.p2j_con03.clearfix.w1000 > div.text_con.text_con01 > div > p.sou").get();
            time = time.split("&nbsp")[0].substring(15);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
            long timestamp = 0;
            try {
                Date parse = dateFormat.parse(time);
                timestamp = parse.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(timestamp);

            String img = html.css("body > div.p2j_con03.clearfix.w1000 > div.text_con.text_con01 > div > div.show_text").css("img", "src").get();
            System.out.println(img);

            try {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO news VALUES (?,?,?,?)");
                statement.setString(2, title);
                statement.setLong(3, timestamp);
                statement.setString(1, page.getRequest().getUrl());
                statement.setString(4, img);
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Site getSite() {
        return Site.me().setRetryTimes(2).setSleepTime(1000);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Spider.create(new NewsSpider())
                .addUrl("http://dangjian.people.com.cn/GB/394443/index1.html")
                .thread(1)
                .run();
    }
}
