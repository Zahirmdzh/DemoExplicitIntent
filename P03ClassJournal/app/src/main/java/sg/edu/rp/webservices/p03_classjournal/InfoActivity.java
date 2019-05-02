package sg.edu.rp.webservices.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    int requestCodeForAddData = 1;

    ListView lv;
    ArrayList<DailyCA> alDailyCA;

    ArrayAdapter aa;
    TextView tvDG;
    Button btnInfo,btnAdd,btnEmail;
    int weeknumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvDG = findViewById(R.id.textViewDG);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);


        lv = findViewById(R.id.lvDG);
        alDailyCA = new ArrayList<>();
        aa = new InfoAdapter(this,R.layout.info_row,alDailyCA);

        alDailyCA.add(new DailyCA("B","c347",1));
        lv.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this, AddInfoActivity.class);

                weeknumber = alDailyCA.size() + 1;

                i.putExtra("weeknum",weeknumber);


                startActivityForResult(i,requestCodeForAddData);
            }
        });




        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);

                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "");
                email.putExtra(Intent.EXTRA_TEXT,
                        "week 1 : ...");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                String choice = data.getStringExtra("radioGroup");


               alDailyCA.add(new DailyCA(choice,"c347",weeknumber));
               aa.notifyDataSetChanged();
            }
        }

    }
}
