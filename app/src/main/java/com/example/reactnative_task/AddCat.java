package com.example.reactnative_task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCat extends AppCompatActivity {

    String Catname , CatBreed , CatDes ;
    FirebaseDatabase db ;
    DatabaseReference reference ;

    Button uploadcat ;
    EditText catname , catbreed , catdes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cat);


        catname = findViewById(R.id.addcatname);
        catdes = findViewById(R.id.addcatbreed);
        catbreed = findViewById(R.id.addcatdes);




        uploadcat= findViewById(R.id.uploadcat);
        uploadcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Catname = catname.getText().toString();
                CatBreed = catbreed.getText().toString();
                CatDes = catdes.getText().toString();


                if (!Catname.isEmpty() && !CatBreed.isEmpty() && !CatDes.isEmpty()){


                    Users users = new Users(Catname,CatBreed,CatDes);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");
                    reference.child(Catname).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            catname.setText("");
                            catbreed.setText("");
                            catdes.setText("");
                            Toast.makeText(AddCat.this,"Successfully Update",Toast.LENGTH_SHORT).show();                        }
                    });

                }
            }
        });



        }

    }


