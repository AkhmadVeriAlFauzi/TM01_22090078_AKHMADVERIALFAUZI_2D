package Materi1;

import TM1.ConnectURI2;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI2 koneksisaya = new ConnectURI2();
        URL myAddress = koneksisaya.buildURl("https://harber.mimoapps.xyz/api/getaccess.php");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
//        System.out.println(response);

        //decoding JSON
        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponModel> responModels =
                new ArrayList<>();
        for (int i = 0; i< responseJSON.length();i++){  //kenapa .length? , karena itu Array
            ResponModel resModel = new ResponModel();
            JSONObject myJSONObject =
                    responseJSON.getJSONObject(i);
            resModel.setMsg(myJSONObject.getString("message"));
            resModel.setStatus(myJSONObject.getString("status"));
            resModel.setComment(myJSONObject.getString("comment"));
            responModels.add(resModel);
        }
        System.out.println("Response are: ");
        for(int index=0; index<responModels.size();index++){
            System.out.println("MESSAGE : " + responModels.get(index).getMsg());
            System.out.println("STATUS : " + responModels.get(index).getStatus());
            System.out.println("Comment : " + responModels.get(index).getComment());
        }
    }
}
