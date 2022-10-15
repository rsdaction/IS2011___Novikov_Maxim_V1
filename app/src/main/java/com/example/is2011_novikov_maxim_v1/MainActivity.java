package com.example.is2011_novikov_maxim_v1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private final static String FILE_NAME = "save.txt";
    String[] countries = { "Россия", "Казахстан", "Беларусь", "Китай", "Япония"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public EditText imya, familiya, email, password, twopassword, strana;
    private void init(){
        imya = findViewById(R.id.editTextTextPersonName);
        familiya = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        twopassword = findViewById(R.id.editTextTextPassword2);
    }
    public void ss(View view){
        String Pass = password.getText().toString();
        String sPass = twopassword.getText().toString();
        String username = imya.getText().toString();
        String Familiya = familiya.getText().toString();
        String poch = email.getText().toString();
        if (username.length() == 0 || Familiya.length() == 0 || poch.length() == 0){
            Toast.makeText(getApplicationContext(),"Заполните обязательные поля", Toast.LENGTH_SHORT).show();
        }else {
            if (Pass.equals(sPass) & Pass.length() != 0 & sPass.length() != 0) {
            } else {
                Toast.makeText(getApplicationContext(), "Данные пароли не совпадают", Toast.LENGTH_SHORT).show();
            }
        }
        FileOutputStream sohranenie = null;
        try {
            String text = username + "\n" + Familiya + "\n" + Pass +  "\n" + sPass + "\n" + poch + "\n";
            sohranenie = openFileOutput(FILE_NAME, MODE_PRIVATE);
            sohranenie.write(text.getBytes());
            Toast.makeText(this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
}
