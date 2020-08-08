import java.sql.*;

/**
 * @ClassName Personas
 * @Author 11214
 * @Date 2020/3/15
 * @Description TODO
 */
public class Personas {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://121.43.160.139:3306/party?useSSL=false", "mmjj", "02080328");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Personas VALUES (?,?,?)");
            PreparedStatement statement = connection.prepareStatement("SELECT MAX() FROM Personas WHERE tag=?");
            String values = "106 创新  68 科技  62 中心  55 黑龙江省  48 经济  48 发展  46 哈尔滨市  45 协同  44 高校  43 平台  253 教育  242 活动  226 问题  218 实践  168 建设  148 群众路线  145 意见  136 发展  120 党  117 开展  263 教育  246 活动  239 问题  218 实践  215 建设  171 发展  152 意见  148 群众路线  126 进行  123 开展  351 月  347 活动  340 教育  327 日  266 建设  265 学生  255 东北  254 问题  246 实践  209 中  360 月  347 活动  340 教育  336 日  277 学生  270 建设  267 东北  254 问题  248 实践  218 发展";
            String[] strings = values.split("  ");
            System.out.println(strings.length);
            for (String string : strings) {
                String[] split = string.split(" ");
                statement.setString(1,split[1]);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) continue;

                preparedStatement.setString(1, "2017141463212");
                preparedStatement.setString(2, split[1]);
                preparedStatement.setInt(3, Integer.parseInt(split[0]));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
