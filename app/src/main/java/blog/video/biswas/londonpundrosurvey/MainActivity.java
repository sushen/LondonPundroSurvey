package blog.video.biswas.londonpundrosurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import blog.video.biswas.londonpundrosurvey.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PundroFrom pundroFrom = new PundroFrom();

                pundroFrom.setFristName(binding.edtFirstName.getText().toString());
                pundroFrom.setLastName(binding.edtLastName.getText().toString());
                pundroFrom.setMail(binding.editEmail.getText().toString());
                pundroFrom.setComment(binding.edtComment.getText().toString());

                pundroFrom.setId(databaseReference.child("PundroFromList").push().getKey());
                databaseReference.child("PundroFromList")
                        .child(pundroFrom.getId())
                        .setValue(pundroFrom);


                Intent intent = new Intent (MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

    }
}
