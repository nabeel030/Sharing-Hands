package com.example.sharinghands.ui.NGO;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharinghands.EmailRegex.EmailRegex;
import com.example.sharinghands.NGODashboard;
import com.example.sharinghands.R;

public class NGORegistration extends AppCompatActivity {

    Button ngo_register;
    EditText name, reg_no, email, address, password, confirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoregistration);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final String emailRegex = EmailRegex.getInstance().getEmailRegex();

        ngo_register = findViewById(R.id.ngo_register);
        name = findViewById(R.id.ngo_name);
        reg_no = findViewById(R.id.reg_no);
        email = findViewById(R.id.ngo_email_address);
        address = findViewById(R.id.address);
        password = findViewById(R.id.ngo_passcode);
        confirm_password = findViewById(R.id.ngo_confirm_password);

        ngo_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ngo_name = name.getText().toString();
                String reg_number = reg_no.getText().toString();
                String emailAddress = email.getText().toString();
                String ngoAddress = address.getText().toString();
                String ngoPassword = password.getText().toString();
                String confirmPassword = confirm_password.getText().toString();

                if (ngo_name.isEmpty() || reg_number.isEmpty() || emailAddress.isEmpty()
                        || ngoAddress.isEmpty() || ngoPassword.isEmpty() || confirmPassword.isEmpty()){

                    Toast.makeText(getApplicationContext(),"All Fields Are Required!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (emailAddress.matches(emailRegex)){
                        if (ngoPassword.equals(confirmPassword))
                        {
                            Intent intent = new Intent(NGORegistration.this, NGODashboard.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Password Did not Match!", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Invalid Email Address!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
