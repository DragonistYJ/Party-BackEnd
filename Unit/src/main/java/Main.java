import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import util.HttpUtil;

import java.io.IOException;

/**
 * @ClassName Main
 * @Author 11214
 * @Date 2020/3/14
 * @Description TODO
 */
public class Main {
    private static String utterance() {
        // 请求URL
        String talkUrl = "https://aip.baidubce.com/rpc/2.0/unit/bot/chat";
        try {
            JSONObject query_info = new JSONObject();
            query_info.put("source", "KEYBOARD");
            query_info.put("type", "TEXT");

            JSONObject request = new JSONObject();
            request.put("bernard_level", 1);
            request.put("user_id", "888888");
            request.put("query_info", query_info);
            request.put("query", "三个代表重要思想是谁提出的");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("bot_session", "");
            jsonObject.put("log_id", "123456789");
            jsonObject.put("bot_id", "1020606");
            jsonObject.put("version", "2.0");
            jsonObject.put("request", request);

            // 请求参数
            String accessToken = "24.c678347a051b5a690c7ba706f20daf52.2592000.1586780896.282335-18801960";
            String answer = HttpUtil.post(talkUrl, accessToken, "application/json", jsonObject.toString());
            JSONObject result = new JSONObject(answer);
            int error_code = result.getInt("error_code");
            System.out.println(error_code);
            return result.getJSONObject("result").getJSONObject("response").getJSONArray("action_list").getJSONObject(0).getString("say");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String ask() {
        JSONObject query_info = new JSONObject();
        query_info.put("source", "KEYBOARD");
        query_info.put("type", "TEXT");

        JSONObject request = new JSONObject();
        request.put("bernard_level", 1);
        request.put("user_id", "888888");
        request.put("query_info", query_info);
        request.put("query", "三个代表重要思想是谁提出的");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bot_session", "");
        jsonObject.put("log_id", "123456789");
        jsonObject.put("bot_id", "1020606");
        jsonObject.put("version", "2.0");
        jsonObject.put("request", request);

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Request request1 = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/unit/bot/chat?access_token=24.c678347a051b5a690c7ba706f20daf52.2592000.1586780896.282335-18801960")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        client.newCall(request1).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                JSONObject result = new JSONObject(response.body().string());
                int error_code = result.getInt("error_code");
                System.out.println(error_code);
                System.out.println(result.getJSONObject("result").getJSONObject("response").getJSONArray("action_list").getJSONObject(0).getString("say"));
            }
        });
        return "";
    }

    public static void main(String[] args) {
        //System.out.println(utterance());
        ask();
    }

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
}
