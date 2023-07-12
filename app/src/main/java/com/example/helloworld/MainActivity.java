package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView username;
    private TextView password;
    private Button loginbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= (TextView)findViewById(R.id.username);
        password= (TextView) findViewById(R.id.password);
        loginbut= (Button) findViewById(R.id.loginbutton);

        loginbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("aayush24")&& password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this,"LOGIN",Toast.LENGTH_SHORT).show();
                        openActivity2();
                }
                else{
                    Toast.makeText(MainActivity.this,"Failed To Login",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void openActivity2(){
        Intent intent= new Intent(this,Activity2.class);
        startActivity(intent);
    }
}