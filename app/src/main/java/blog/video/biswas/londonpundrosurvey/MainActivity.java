package blog.video.biswas.londonpundrosurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PundroFrom pundroFrom = new PundroFrom();

                try {
                    if (binding.edtFirstName.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please Type Your First Name");
                        DiaOK.show();
                        binding.edtFirstName.requestFocus();
                        return;
                    }
                    else if (binding.edtLastName.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please Type Your Last Name");
                        DiaOK.show();
                        binding.edtLastName.requestFocus();
                        return;
                    }
                    else if (binding.editEmail.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please Type Your Email");
                        DiaOK.show();
                        binding.editEmail.requestFocus();
                        return;
                    }
                    else if (binding.edtComment.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please Type Your Comment");
                        DiaOK.show();
                        binding.edtComment.requestFocus();
                        return;
                    }
                    else
                        pundroFrom.setFristName(binding.edtFirstName.getText().toString());
                    pundroFrom.setLastName(binding.edtLastName.getText().toString());
                    pundroFrom.setMail(binding.editEmail.getText().toString());
                    pundroFrom.setComment(binding.edtComment.getText().toString());

                    pundroFrom.setId(databaseReference.child("PundroFromList").push().getKey());
                    databaseReference.child("PundroFromList")
                            .child(pundroFrom.getId())
                            .setValue(pundroFrom);

                } catch (Exception e) {
                    AlertDialog DiaOK = DialogOK();
                    DiaOK.setMessage(e.toString() + " Submit button click");
                    DiaOK.show();
                }


            }
        });

    }

    private AlertDialog DialogOK() {
        AlertDialog DialogBox = new AlertDialog.Builder(this)
                .setTitle("Uncompleted From")
                .setMessage("")
                .setIcon(R.drawable.ic_event_note_black_24dp)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                })
                .create();
        return DialogBox;
    }
}
