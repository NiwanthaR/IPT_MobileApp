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
import android.widget.TextView;

import java.io.IOException;

public class ProfileEditActivity extends AppCompatActivity {

    private TextView user_tvname,user_tvemail,alertbox;
    private EditText user_name,user_nic,user_email,user_contact;
    private Button update_data;
    private ImageView user_img,add_img;

    //imagepart
    private static final int RESULT_CODE_REQUEST =101;
    private Uri imageuri;
    private Boolean isImageAdded=false;

    private String name,nic,email,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        //UI Declare
        ui_declare();

        //select Image
        add_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,RESULT_CODE_REQUEST);
            }
        });

        //update data
        update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = user_name.getText().toString().trim();
                nic = user_nic.getText().toString().trim();
                email = user_email.getText().toString().trim();
                contact = user_contact.getText().toString().trim();

                if (ValidationData.update_profile_validate(name,nic,email,contact))
                {
                    if (ValidationData.isValidmail(email))
                    {
                        if (ValidationData.isValidNic(nic))
                        {
                            if (ValidationData.iscontact(contact))
                            {
                                //complete
                                alertbox.setText("Complete");
                            }else {
                                alertbox.setText("Please check your Contact Number");
                            }
                        }else{
                            alertbox.setText("Please check your NIC");
                        }
                    }else{
                        alertbox.setText("Please check your email");
                    }
                }else{
                    alertbox.setText("Please All Details");
                }
            }
        });
    }

    private void ui_declare() {
        user_tvname = findViewById(R.id.profile_edit_tv_owner_name1);
        user_tvemail = findViewById(R.id.profile_edit_tv_owner_email1);

        user_name = findViewById(R.id.profile_edit_owner_name2);
        user_nic = findViewById(R.id.profile_edit_owner_nic);
        user_email = findViewById(R.id.profile_edit_owner_email);
        user_contact = findViewById(R.id.profile_edit_owner_contact);

        update_data = findViewById(R.id.profile_edit_update_profile);
        alertbox = findViewById(R.id.profile_edit_alert_box);

        user_img = findViewById(R.id.profile_edite_user_img);
        add_img = findViewById(R.id.profile_edite_add_img);

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
                user_img.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
