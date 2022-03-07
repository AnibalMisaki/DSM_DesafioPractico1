package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sv.com.udb.dsm.R;

public class MainActivity extends AppCompatActivity {

    TextView saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saludo = (TextView) findViewById(R.id.saludo);
        getUser();
    }

    private void getUser(){
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user = preferences.getString("user","No hay usuario");
        saludo.setText("Bienvenido " + user);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.ejercicio1:
                viewExercise1();
                break;
            case R.id.ejercicio2:
                viewExercise2();
                break;
            case R.id.logOut:
                logOut();
        }
    }

    private void viewExercise1(){
        Intent i = new Intent(this, EcuacionActivity.class);
        startActivity(i);
    }

    private void viewExercise2(){
        Intent i = new Intent(this, EcuacionActivity.class);
        startActivity(i);
    }

    private void logOut(){
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("credenciales");
        editor.commit();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}