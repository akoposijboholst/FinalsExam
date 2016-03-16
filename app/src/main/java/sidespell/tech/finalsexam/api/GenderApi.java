package sidespell.tech.finalsexam.api;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONObject;

import sidespell.tech.finalsexam.utils.HttpUtils;

public class GenderApi {

    public static final String BASE_URL = "https://api.genderize.io/";

    public static String getGender(String name) {
        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter("name", name)
                .build();

        String jsonStr = HttpUtils.GET(uri);
        String gender = null;

        if (!TextUtils.isEmpty(jsonStr)) {
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                gender = jsonObject.getString("gender");
                // TODO: Implement JSON Parsing here..
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return gender;
    }
}
