package com.example.reactnative_task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UpdateInfo extends AppCompatActivity {

    DatabaseReference databaseReference ;
    Button updateinfo ;
    EditText catname , catbreed , catdes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        catname = findViewById(R.id.name);
        catdes = findViewById(R.id.breed);
        catbreed = findViewById(R.id.des);
        updateinfo=findViewById(R.id.updateinfo);

        updateinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Catname = catname.getText().toString();
                String CatBreed = catbreed.getText().toString();
                String CatDes = catdes.getText().toString();

                UpdateData(Catname,CatBreed,CatDes);


            }
        });


    }

    private void UpdateData(String catname, String catBreed, String catDes) {

        HashMap user = new HashMap();
        user.put("catname",catname);
        user.put("catDes",catBreed);
        user.put("catBreed",catDes);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(catname).updateChildren(user).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {

                if (task.isSuccessful()){



                }

            }
        });

    }
}