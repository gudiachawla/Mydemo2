package com.example.mydemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
    }

    public void click(View view) {
        String e = email.getText().toString();
        String p = password.getText().toString();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(e, p)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //go to login activity or
                            //go to home activity
                            //Toast.makeText(MainActivity.this."Successfully",Toast.LENGTH_LONG).show();                      }
                            Toast.makeText(MainActivity.this, "Successfully Register", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
