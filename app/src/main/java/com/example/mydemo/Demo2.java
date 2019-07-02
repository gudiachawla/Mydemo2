package com.example.mydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Demo2 extends AppCompatActivity {
    EditText username, uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        username = findViewById(R.id.username);
        uid = findViewById(R.id.uid);

    }

    public void submit(View view) {
        String name = username.getText().toString();
        String id = uid.getText().toString();

        //firebase working start
        Map<String, String> data = new HashMap<>();
        data.put("username", name);
        data.put("uid", id);
        FirebaseFirestore ref = FirebaseFirestore.getInstance();
        ref.collection("User")

                .document(id)
                .set(data);
    }
}
