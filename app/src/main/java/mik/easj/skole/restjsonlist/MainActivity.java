package mik.easj.skole.restjsonlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ReadTask task = new ReadTask();
        task.execute("http://mikrestservice.azurewebsites.net/Service1.svc/passager/");
    }


    private class ReadTask extends ReadHttpTask{
        @Override
        protected void onPostExecute(CharSequence jsonString) {
            TextView textView = findViewById(R.id.main_message_textview);
            final List<Passager> passagerList = new ArrayList<>();
            try{
                JSONArray array = new JSONArray(jsonString.toString());
                for (int i = 0; i < array.length(); i++)
                {
                    JSONObject obj = array.getJSONObject(i);
                    int Id = obj.getInt("Id");
                    String Navn = obj.getString("Navn");
                    double BagageVaegt = obj.getDouble("BagageVaegt");
                    String Efternavn = obj.getString("Efternavn");
                    int BagageAntal = obj.getInt("BagageAntal");
                    int FlyNummer = obj.getInt("FlyNummer");
                    Passager _passager = new Passager(Id,Navn,BagageVaegt,Efternavn,BagageAntal,FlyNummer);
                    passagerList.add(_passager);
                }
                ListView listView =findViewById(R.id.main_passager_listview);
                ArrayAdapter<Passager> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1,passagerList);
                listView.setAdapter(adapter);
            }
            catch (JSONException x)
            {
                textView.setText("Error: " + x.getMessage());
            }

        }

        @Override
        protected void onCancelled(CharSequence message) {
            TextView messagetextView = findViewById(R.id.main_message_textview);
            messagetextView.setText(message);
        }
    }
}
