package interactionsatisfaction.communiface;
/*import java.net.URI;
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
//import android.util.Log;*/

public class EmotionAnalysis {


           /* // Replace <Subscription Key> with your valid subscription key.
            private static final String subscriptionKey = "89b3f8da6f01447aa4179e88ac363af1";

            // NOTE: You must use the same region in your REST call as you used to
            // obtain your subscription keys. For example, if you obtained your
            // subscription keys from westus, replace "westcentralus" in the URL
            // below with "westus".
            //
            // Free trial subscription keys are generated in the westcentralus region. If you
            // use a free trial subscription key, you shouldn't need to change this region.
            private static final String uriBase =
                    "https://canadacentral.api.cognitive.microsoft.com/face/v1.0";
            private static final String imageWithFaces =
                    "{\"url\":\"https://upload.wikimedia.org/wikipedia/commons/c/c3/RH_Louise_Lillian_Gish.jpg\"}";

            private static final String faceAttributes =
                    "age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise";

            public static void main(String[] args)
            {
                System.out.println("shitfuck");
                HttpClient httpclient = new DefaultHttpClient();

                try
                {
                    URIBuilder builder = new URIBuilder(uriBase);

                    System.out.println("shitfuck2");

                    // Request parameters. All of them are optional.
                    builder.setParameter("returnFaceId", "true");
                    builder.setParameter("returnFaceLandmarks", "false");
                    builder.setParameter("returnFaceAttributes", faceAttributes);

                    System.out.println("shitfuck3");

                    // Prepare the URI for the REST API call.
                    URI uri = builder.build();
                    HttpPost request = new HttpPost(uri);

                    System.out.println("shitfuck4");

                    // Request headers.
                    request.setHeader("Content-Type", "application/json");
                    request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

                    System.out.println("shitfuck5");

                    // Request body.
                    StringEntity reqEntity = new StringEntity(imageWithFaces);
                    request.setEntity(reqEntity);

                    System.out.println("shitfuck6");
                    System.out.println(request);
                    // Execute the REST API call and get the response entity.
                    HttpResponse response = httpclient.execute(request);
                    System.out.println("shitfuck7");
                    HttpEntity entity = response.getEntity();

                    System.out.println("shitfuck8");

                    if (entity != null)
                    {
                        // Format and display the JSON response.
                        System.out.println("REST Response:\n");

                        System.out.println("shitfuck9");

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
                }
                catch (Exception e)
                {
                    // Display error message.
                    System.out.println(e.getMessage());
                }
            }

*/

}
