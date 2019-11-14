package blog.video.biswas.londonpundrosurvey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import blog.video.biswas.londonpundrosurvey.databinding.ActivitySingupBinding;

public class Singup extends AppCompatActivity {

    private ActivitySingupBinding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_singup);

        firebaseAuth = FirebaseAuth.getInstance();



        binding.tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Singup.this, Login.class);
                startActivity(intent);
                finish();
            }
        });



        binding.btnsingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    if (binding.edtpaswordsingup.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please enter your password");
                        DiaOK.show();
                        binding.edtpaswordsingup.requestFocus();
                        return;
                    } else if (binding.edtemailsingup.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please select the TAB ID");
                        DiaOK.show();
                        binding.edtemailsingup.requestFocus();
                        return;
                    } else
                        signup(binding.edtemailsingup.getText().toString(), binding.edtpaswordsingup.getText().toString());

                } catch (Exception e) {
                    AlertDialog DiaOK = DialogOK();
                    DiaOK.setMessage(e.toString() + " SignIn button click");
                    DiaOK.show();
                }

            }
        });



    }

    private void signup(String email, String password){

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Singup.this, Login.class);
                    startActivity(intent);
                    finish();
                }else {
                    //Log.i("registrationLog", "Fail to create account");
                    Toast.makeText(Singup.this, "Fail to create account !",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private AlertDialog DialogOK() {
        AlertDialog DialogBox = new AlertDialog.Builder(this)
                .setTitle("Login")
                .setMessage("")
                .setIcon(R.drawable.name)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                })
                .create();
        return DialogBox;
    }

}
