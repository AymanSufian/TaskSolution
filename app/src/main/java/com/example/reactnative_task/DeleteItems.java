package com.example.reactnative_task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reactnative_task.databinding.ActivityDeleteItemsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteItems extends AppCompatActivity {

    ActivityDeleteItemsBinding binding ;
    DatabaseReference reference ;

    EditText catid ;
    Button delitem ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_items);

        delitem = findViewById(R.id.delitem);

        catid = findViewById(R.id.catid);


      delitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String catname = catid.getText().toString();
                if (!catname.isEmpty()){

                    deleteData(catname);
                }
                else {


                    Toast.makeText(DeleteItems.this,"Please Write A Name",Toast.LENGTH_SHORT).show();


                }
            }
        });
    }

    private void deleteData(String Catname) {

        reference = FirebaseDatabase.getInstance().getReference().child("Users");
        reference.child(Catname).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){

                    Toast.makeText(DeleteItems.this,"Successfully Deleted",Toast.LENGTH_SHORT).show();
                    catid.setText("");
                }
                else {

                    Toast.makeText(DeleteItems.this,"Failed to delete",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}