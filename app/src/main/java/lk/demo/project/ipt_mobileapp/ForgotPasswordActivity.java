package lk.demo.project.ipt_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText reset_email;
    private Button submit_reset;
    private TextView alert_box,complete_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //UI Declare
        ui_declare();


    }

    private void ui_declare() {
        reset_email = findViewById(R.id.resetpassword_et_email);
        submit_reset = findViewById(R.id.resetpassword_btn_reset);
        alert_box = findViewById(R.id.resetpassword_tv_alertbox);
        complete_box =findViewById(R.id.resetpassword_tv_complete);
    }
}
