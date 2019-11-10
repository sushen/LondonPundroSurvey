package blog.video.biswas.londonpundrosurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import blog.video.biswas.londonpundrosurvey.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private ActivityMainBinding binding;

    Cursor cursor;
    Cursor CursorPre;
    Cursor CursorCur;


    CAdapter DatabaseHelper;
    DateTimeHandler TimeHandler;
    Globals Global;


    String q1Value = "";
    String CBq1Value = "";
    String CBq2Value = "";
    String CBq3Value = "";
    String CBq4Value = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        TimeHandler = new DateTimeHandler();
        Global = Globals.getInstance();

        q1Value = (Global.GetValueFromRadioButton4(binding.rbq11, binding.rbq12, binding.rbq13, binding.rbq14));

        CBq1Value =(Global.GetValueFromCheckButton1(binding.CBq1));

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (binding.edtFirstName.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please Type Your First Name");
                        DiaOK.show();
                        binding.edtFirstName.requestFocus();
                        return;
                    } else if (binding.edtLastName.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please Type Your Last Name");
                        DiaOK.show();
                        binding.edtLastName.requestFocus();
                        return;
                    } else if (binding.editEmail.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please Type Your Email");
                        DiaOK.show();
                        binding.editEmail.requestFocus();
                        return;
                    } else if (binding.edtComment.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please Type Your Comment");
                        DiaOK.show();
                        binding.edtComment.requestFocus();
                        return;
                    } else
                        savedata();
                    FieldInitialize();



                } catch (Exception e) {
                    AlertDialog DiaOK = DialogOK();
                    DiaOK.setMessage(e.toString() + " Submit button click");
                    DiaOK.show();
                }


            }
        });

        binding.btnSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowData.class);
                startActivity(intent);
                finish();
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

    private AlertDialog DialogYesNo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Check");
        builder.setMessage("");
        builder.setIcon(R.drawable.ic_event_note_black_24dp);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        return builder.create();
    }


    public String Q1V() {
        q1Value = (Global.GetValueFromRadioButton4(binding.rbq11, binding.rbq12, binding.rbq13, binding.rbq14));
        return q1Value;
    }
    public String Cb1V() {
        CBq1Value = (Global.GetValueFromCheckButton1(binding.CBq1));
        return CBq1Value;
    }

    public void savedata() {
        PundroFrom pundroFrom = new PundroFrom();

        pundroFrom.setFristName(binding.edtFirstName.getText().toString());
        pundroFrom.setLastName(binding.edtLastName.getText().toString());
        pundroFrom.setMail(binding.editEmail.getText().toString());
        pundroFrom.setComment(binding.edtComment.getText().toString());
        pundroFrom.setDate(TimeHandler.getSystemDate());
        pundroFrom.setTime(TimeHandler.getSystemTime());
        pundroFrom.setRgq1(Q1V());
        pundroFrom.setCBq1(Cb1V());

        pundroFrom.setId(databaseReference.child(binding.spicountry.getSelectedItem().toString()).push().getKey());
        databaseReference.child(binding.spicountry.getSelectedItem().toString())
                .child(pundroFrom.getId())
                .setValue(pundroFrom);


//        String fristName = binding.edtFirstName.getText().toString();
//        String LastName = binding.edtLastName.getText().toString();
//        String mail = binding.editEmail.getText().toString();
//        String Comment = binding.edtComment.getText().toString();
//        String rgq1 = DataSaveSQL();
//
//        String kye = DatabaseReference.push().getKey();
//
//        PundroFrom pundroFrom = new PundroFrom(fristName,LastName,mail,Comment,rgq1);
//
//        databaseReference.child(kye).push().setValue(pundroFrom);
    }

    private void FieldInitialize() {
        try {
            binding.edtFirstName.setText("");
            binding.edtLastName.setText("");
            binding.editEmail.setText("");
            binding.edtComment.setText("");
            binding.rgq1.clearCheck();
            binding.CBq1.setChecked(false);
            binding.CBq2.setChecked(false);
            binding.CBq3.setChecked(false);
            binding.CBq4.setChecked(false);
            binding.spicountry.setSelected(false);

        } catch (NumberFormatException e) {
            return;
        }
    }
}
