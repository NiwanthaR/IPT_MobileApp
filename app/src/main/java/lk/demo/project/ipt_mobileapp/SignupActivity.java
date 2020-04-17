package lk.demo.project.ipt_mobileapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;

public class SignupActivity extends AppCompatActivity {

    private EditText user_name,user_nic,user_email,user_contact,user_password,user_repassword;
    private RadioGroup Radio_gender,Radio_worksate;
    private RadioButton select_gender,select_workstate;
    private TextView alert_box,alredy_signin;
    private Button create_account;
    private ImageView user_image,add_image;

    private String name,nic,contact,email,password,repassword,gender,workstate;

    //imagepart
    private static final int RESULT_CODE_REQUEST =101;
    private Uri imageuri;
    private Boolean isImageAdded=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //UI Declare
        ui_declare();

        //go back login screen
        alredy_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        //upload Image
        add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,RESULT_CODE_REQUEST);
            }
        });

        //submit button click
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = user_name.getText().toString().trim();
                nic = user_nic.getText().toString().trim();
                contact = user_contact.getText().toString();
                email = user_email.getText().toString().trim();
                password = user_password.getText().toString().trim();
                repassword = user_repassword.getText().toString().trim();

                //Read Gender
                Read_Gender();
                //Read Working State
                Read_Working_State();

                if (ValidationData.signup_validate(name,nic,contact,email,password,repassword))
                {
                    if (ValidationData.isValidmail(email))
                    {
                        if (ValidationData.check_password_validate(password,repassword))
                        {
                            if (ValidationData.iscontact(contact))
                            {
                                if (ValidationData.isValidNic(nic)){
                                    //Registration code
                                    //send database name,gender,nic,contact,email,password,working_state
                                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                    finish();

                                }else{
                                    alert_box.setText("Check Your NIC");
                                }
                            }else{
                                alert_box.setText("Check Your Contact Number");
                            }
                        }else{
                            alert_box.setText("Check Your Password is Not Same");
                        }
                    }else {
                        alert_box.setText("Check Your Email is Incorrect");
                    }
                }else {
                    alert_box.setText("Please Fill All Details");
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==RESULT_CODE_REQUEST && data!=null)
        {
            imageuri=data.getData();
            isImageAdded=true;

            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageuri);
                user_image.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void ui_declare() {
        user_name = findViewById(R.id.user_signup_et_name);
        user_nic = findViewById(R.id.user_signup_et_nic);
        user_email = findViewById(R.id.user_signup_et_email);
        user_contact = findViewById(R.id.user_signup_et_contact);
        user_password = findViewById(R.id.user_signup_et_password);
        user_repassword = findViewById(R.id.user_signup_et_re_password);

        alert_box = findViewById(R.id.user_signup_alert_box);
        alredy_signin = findViewById(R.id.user_signup_tv_login);
        create_account = findViewById(R.id.user_signup_btn_signup);

        Radio_worksate = findViewById(R.id.radio_registration_current_status);
        Radio_gender= findViewById(R.id.radio_registration_gender);

        user_image = findViewById(R.id.user_signup_image_view);
        add_image = findViewById(R.id.user_signup_image_add);

    }

    public void Read_Gender() {

        // get selected radio button from radioGroup
        int selectedId = Radio_gender.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        select_gender = (RadioButton) findViewById(selectedId);

        gender = String.valueOf(select_gender.getText());
        //Toast.makeText(Post_Add_Home_Dash.this,h_kitchen,Toast.LENGTH_SHORT).show();
    }

    public void Read_Working_State() {

        // get selected radio button from radioGroup
        int selectedId = Radio_worksate.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        select_workstate = (RadioButton) findViewById(selectedId);

        workstate = String.valueOf(select_workstate.getText());
        //Toast.makeText(Post_Add_Home_Dash.this,h_kitchen,Toast.LENGTH_SHORT).show();
    }
}
