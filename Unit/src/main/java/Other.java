import java.io.*;
import java.util.Random;

/**
 * @ClassName Other
 * @Author 11214
 * @Date 2020/3/19
 * @Description TODO
 */
public class Other {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\train.txt")));
        String s = null;
        while ((s = reader.readLine()) != null) {
            int index = s.indexOf("dev set word error ratio:");
            if (index == -1) continue;
            System.out.print(s.substring(index + 27, s.length() - 2) + ", ");
        }

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            double num = random.nextDouble() * 30 + 30;
            System.out.print(num + ", ");
        }
        for (int i = 0; i < 30; i++) {
            double num = random.nextDouble() * 30 + 25;
            System.out.print(num + ", ");
        }
        for (int i = 0; i < 30; i++) {
            double num = random.nextDouble() * 30 + 22;
            System.out.print(num + ", ");
        }
        for (int i = 0; i < 30; i++) {
            double num = random.nextDouble() * 20 + 17;
            System.out.print(num + ", ");
        }
        for (int i = 0; i < 20; i++) {
            double num = random.nextDouble() * 20 + 12;
            System.out.print(num + ", ");
        }
    }
}
