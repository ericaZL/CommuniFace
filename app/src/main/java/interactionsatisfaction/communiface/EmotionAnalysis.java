package interactionsatisfaction.communiface;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;
//import android.util.Log;

public class EmotionAnalysis {


    // Replace <Subscription Key> with your valid subscription key.
    private static final String subscriptionKey = "89b3f8da6f01447aa4179e88ac363af1";

    // NOTE: You must use the same region in your REST call as you used to
    // obtain your subscription keys. For example, if you obtained your
    // subscription keys from westus, replace "westcentralus" in the URL
    // below with "westus".
    //
    // Free trial subscription keys are generated in the westcentralus region. If you
    // use a free trial subscription key, you shouldn't need to change this region.
    private static final String uriBase =
            "https://canadacentral.api.cognitive.microsoft.com/face/v1.0/detect?returnfaceId=false&returnFaceAttributes=emotion";
    private static final String imageWithFaces = "{\"url\":\"https://upload.wikimedia.org/wikipedia/commons/c/c3/RH_Louise_Lillian_Gish.jpg\"}";

    private static final String faceAttributes = "age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise";
    public static void Happy(char a_char, char c_char){
        if((a_char =='1')||(c_char =='9')||(c_char =='8')) {
        MainActivity.ReturnPic(true);
        }
        else {
        MainActivity.ReturnPic(false);
    }

}
    public static void main(String[] args) throws Exception {


        URIBuilder builder = new URIBuilder(uriBase);

        // Prepare the URI for the REST API call.
        URI uri = builder.build();
        //request.setHeader("Content-Type", "application/json");
        //request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

        URL url = new URL(uriBase);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/octet-stream");
        con.setRequestProperty("Ocp-Apim-Subscription-Key",subscriptionKey);
        //con.setFixedLengthStreamingMode(0);
        con.setDoOutput(true); // if it's PUT or POST
        con.setRequestMethod("POST");
        FileChannel picture = new FileInputStream("C:\\Users\\Rio Wong\\Desktop\\happy.jpg").getChannel();
        WritableByteChannel out = Channels.newChannel(con.getOutputStream());

        picture.transferTo(0,picture.size(),out);


        //String query = "{\"url\": \"https://upload.wikimedia.org/wikipedia/commons/c/c3/RH_Louise_Lillian_Gish.jpg\"}";
        //con.setRequestProperty("Content-Length", Integer.toString(query.length()));
        //con.getOutputStream().write(query.getBytes("UTF8"));

        con.getOutputStream().close(); // send a zero length request body


        //con.setDoOutput(true);
        //con.setRequestProperty("Content-Length", "0");
        //int contentlength = "0".getBytes("UTF-8").length;
        //con.setRequestProperty("Content-Length", "0");



        //int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while((inputLine =in.readLine())!=null)

        {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        String response = content.toString();
        response =response.substring(1,response.length()-2);
        //Double d=Double.parseDouble(response);
        //if()
        /*
        JSONArray Arr = new JSONArray(content);
        JSONObject Obj = Arr.getJSONObject(0);
        System.out.println(Obj);
        */
        //response= response.substring(response.indexOf("emotion")+10, response.length()-6);
        //System.out.println(response.toString());
        //System.out.println(response);
        //System.out.println(response);
        int i = response.indexOf("happiness");
        //System.out.println(i);
        char a_char = response.charAt(i + 11);
        //char b_char = response.charAt(159);
        char c_char = response.charAt(i + 13);
        //System.out.println(a_char);
        //System.out.println(b_char);
        //System.out.println(c_char);
        String answer = "";
        answer +=a_char;
        //answer +=  b_char;
        answer +=c_char;
        //answer = (int)(answer);
        //int resultFinal = Integer.parseInt(answer);
        //System.out.println(resultFinal);
        Happy(a_char, c_char);
    }



        /*for (int i = 0; i < arr.length(); ++i) {
            JSONObject obj = arr.getJSONObject(i)
        }*/
        //JSONObject res = obj.getJSONObject(0).getJSONObject("faceAttributes").getJSONObject("emotion");
        /*int currMax = 0;
        String emoType = "";
        for (int i = 0; i < res.names().length(); i++) {
            int val = Integer.parseInt(res.get(res.names().getString(i)));
            if (res.get(res.names()).getInt(i) > currMax) {
                currMax = val;
                emoType = res.names().getString(i);
            }
        }

        System.out.println(emoType);*/
        //String s = res.toString();
        //System.out.println(s);


        //int a = content.indexOf("happiness");  // a is 5
        //System.out.println(content[a:a+2]);

    }












           /*
            if (entity != null)
            {
                // Format and display the JSON response.
                System.out.println("REST Response:\n");


                String jsonString = EntityUtils.toString(entity).trim();
                if (jsonString.charAt(0) == '[') {
                    JSONArray jsonArray = new JSONArray(jsonString);
                    System.out.println(jsonArray.toString(2));
                }
                else if (jsonString.charAt(0) == '{') {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    System.out.println(jsonObject.toString(2));
                } else {
                    System.out.println(jsonString);
                }
            }
            //System.out.println(e.getClass().getName());
        }
       /* catch (Exception e)
        {
            // Display error message.
            //System.out.println(e.getMessage());
            System.out.println(e.getClass().getName());
        }
        */
