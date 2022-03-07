package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import sv.com.udb.dsm.R;

public class LoginActivity extends AppCompatActivity {

//    private final EditText txtA;
//
//    private final EditText txtB;
//
//    public LoginActivity() {
//        super();
//        txtA = findViewById(R.id.userText);
//        txtB = findViewById(R.id.password);
//    }
    EditText userText, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userText = (EditText) findViewById(R.id.userText);
        password = (EditText) findViewById(R.id.password);
    }

    public void onClick(View View){
        savePreferences();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void savePreferences(){
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuario = userText.getText().toString();
        String pass = password.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", usuario);
        editor.putString("pass", pass);

        editor.commit();
    }
}