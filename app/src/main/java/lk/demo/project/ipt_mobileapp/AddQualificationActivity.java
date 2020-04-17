package lk.demo.project.ipt_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddQualificationActivity extends AppCompatActivity {

    private Spinner job_category,language,ide_use;
    private EditText user_name,user_age,user_faculty,user_interrest;
    private Button submit_data;
    private TextView alert_box;

    private String name,age,faculty,job,languages,ides,interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_qualification);

        //UI Declare
        ui_declare();


        //Submit Data
        submit_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = user_name.getText().toString().trim();
                age = user_age.getText().toString().trim();
                faculty = user_faculty.getText().toString().trim();
                job = job_category.getSelectedItem().toString().trim();
                languages = language.getSelectedItem().toString().trim();
                ides = ide_use.getSelectedItem().toString().trim();
                interest = user_interrest.getText().toString();

                if (ValidationData.add_qualification_validate(name,age,faculty,interest) && ValidationData.check_sprinner(job,languages,ides))
                {
                    //database code
                    alert_box.setText("");
                }else{
                    alert_box.setText("Pleas Fill All Data...!!");
                }
            }
        });
    }

    private void ui_declare() {

        //read category
        job_category = findViewById(R.id.add_qualification_job_category);

        ArrayAdapter <String> jobadapter = new ArrayAdapter<String>(AddQualificationActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.job_category));

        jobadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        job_category.setAdapter(jobadapter);


        //read language
        language = findViewById(R.id.add_qualification_language);

        ArrayAdapter <String> languageadapter = new ArrayAdapter<String>(AddQualificationActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.language_category));

        languageadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language.setAdapter(languageadapter);


        //read ide
        ide_use = findViewById(R.id.add_qualification_ide);

        ArrayAdapter <String> ideadapter = new ArrayAdapter<String>(AddQualificationActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ide_category));

        ideadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ide_use.setAdapter(ideadapter);


        user_name = findViewById(R.id.qualification_et_name);
        user_age = findViewById(R.id.qualification_et_age);
        user_faculty = findViewById(R.id.qualification_et_faculty);
        user_interrest = findViewById(R.id.qualification_et_interest);
        submit_data = findViewById(R.id.qualification_et_btn_submit);
        alert_box = findViewById(R.id.qualification_alert_box);
    }
}
