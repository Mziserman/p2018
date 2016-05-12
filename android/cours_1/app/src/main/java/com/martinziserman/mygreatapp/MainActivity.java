package com.martinziserman.mygreatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextLogin;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Charge le fichier layout.activity_main.xml et genere la vue associée
        int customColor = R.color.colorCustom;

        editTextLogin = (EditText)findViewById(R.id.edittext_login);
        editTextPassword = (EditText)findViewById(R.id.edittext_password1);

        String login = editTextLogin.getText().toString();

        findViewById(R.id.button_signin).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_signin:

                break;
            case R.id.button_signup:

                break;
        }

    }
    
    private void checkLogin() {
        
        String 
        
    }
}
