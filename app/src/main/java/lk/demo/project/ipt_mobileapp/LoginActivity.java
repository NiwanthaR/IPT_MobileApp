package lk.demo.project.ipt_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText login_email,login_password;
    private Button btn_login,btn_signup;
    private TextView go_fogot_dash;
    private CheckBox remember_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Ui Declare
        ui_declare();

        //go to signup dashboard
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignupActivity.class));
            }
        });

        //go to forget password
        go_fogot_dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ForgotPasswordActivity.class));
            }
        });
    }

    private void ui_declare() {
        login_email = findViewById(R.id.login_et_email);
        login_password = findViewById(R.id.login_et_password);
        btn_login = findViewById(R.id.login_btn_login);
        btn_signup = findViewById(R.id.login_btn_signup);
        go_fogot_dash = findViewById(R.id.login_tv_forgot_pw);
        remember_me = findViewById(R.id.login_cb_remember);
    }
}
