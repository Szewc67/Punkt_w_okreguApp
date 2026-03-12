package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputX, inputY, inputR, inputPx, inputPy;
    Button wyczysc, sprawdz, informacje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputX = findViewById(R.id.inputX);
        inputY = findViewById(R.id.inputY);
        inputR = findViewById(R.id.inputR);
        inputPx = findViewById(R.id.inputXPoit);
        inputPy = findViewById(R.id.inputYPoit);

        wyczysc = findViewById(R.id.btnClear);
        sprawdz = findViewById(R.id.btnSprawdz);
        informacje = findViewById(R.id.btnInfo);


        wyczysc.setOnClickListener(v ->{
            clearEditText();
        });

        sprawdz.setOnClickListener(v ->{
            insieCicrle();
        });

        informacje.setOnClickListener(v ->{
            openInfoActivity();
        });

    }

    private void openInfoActivity() {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    //metoda do spr czy pkt lezy w okregu czy poza
    private void insieCicrle() {
        double x = Double.parseDouble(inputX.getText().toString());
        double y = Double.parseDouble(inputY.getText().toString());
        double r = Double.parseDouble(inputR.getText().toString());
        double px = Double.parseDouble(inputPx.getText().toString());
        double py = Double.parseDouble(inputPy.getText().toString());

        double distance = Math.sqrt(Math.pow(px - x,2) + Math.pow(py - y,2));

        if (distance <=r) showToast("Punkt znajduje się w okręgu");
        else showToast("Punkt znajduje się poza okręgiem");

    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //metoda do czyszczenia
    private void clearEditText(){
        inputX.setText("");
        inputY.setText("");
        inputR.setText("");
        inputPx.setText("");
        inputPy.setText("");
    }
}