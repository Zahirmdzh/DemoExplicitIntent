package sg.edu.rp.webservices.p03_classjournal;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddInfoActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button btnSub;
    TextView tvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);

        btnSub = findViewById(R.id.buttonSubmit);
        Intent i = getIntent();

        int weeknumber = i.getIntExtra("weeknum",1);
        tvWeek = findViewById(R.id.textViewWeek);
        tvWeek.setText("Week " + weeknumber);

        rg = findViewById(R.id.radioGroupGrade);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();

                int selectedButtonId = rg.getCheckedRadioButtonId();

                RadioButton rb = findViewById(selectedButtonId);


                i.putExtra("radioGroup",rb.getText().toString());

                setResult(RESULT_OK,i);
                finish();
            }
        });

    }
}
