import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @ClassName Tets
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.NOVEMBER, 10, 13, 50, 0);
        System.out.println(calendar.getTimeInMillis());
    }
}
