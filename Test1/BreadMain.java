package Test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BreadMain {

    private static final String JSON_URL = "https://drive.google.com/uc?export=download&id=1CPt0YMDN6mOZR9NlwDZ-NdgCOZSGNiiM";

    public static void main(String[] args) {
    	
    	//json과 java 객체 변환 선언
        Gson gson = new Gson();
        List<Bread> breadList = new ArrayList<>();

        try {
            // json 데이터 읽기
        	// url 객체 만들기
            URL url = new URL(JSON_URL);
            
            // url 연결
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            //데이터 읽기
            while ((line = in.readLine()) != null) {
                jsonBuilder.append(line);
            }
            in.close();

            
            String jsonResponse = jsonBuilder.toString();
            Type breadListType = new TypeToken<List<Bread>>() {}.getType();
            breadList = gson.fromJson(jsonResponse, breadListType);

            
            for (Bread bread : breadList) {
                System.out.println(bread);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
