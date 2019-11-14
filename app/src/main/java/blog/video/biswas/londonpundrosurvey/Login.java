package blog.video.biswas.londonpundrosurvey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import blog.video.biswas.londonpundrosurvey.databinding.ActivityLoginBinding;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    DateTimeHandler TimeHandler;
    CAdapter DatabaseHelper;

    Globals Global;
    Cursor cursor;


    private ActivityLoginBinding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        TimeHandler = new DateTimeHandler();


        binding.tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //login(binding.edtemail.getText().toString(), binding.edtpassword.getText().toString());


                //************************************************
                try {
                    if (binding.edtpassword.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please enter your password");
                        DiaOK.show();
                        binding.edtpassword.requestFocus();
                        return;
                    } else if (binding.edtemail.getText().toString().trim().length() == 0) {
                        AlertDialog DiaOK = DialogOK();
                        DiaOK.setMessage("Please select the TAB ID");
                        DiaOK.show();
                        binding.edtemail.requestFocus();
                        return;
                    } else
                        login(binding.edtemail.getText().toString(),binding.edtpassword.getText().toString());

                } catch (Exception e) {
                    AlertDialog DiaOK = DialogOK();
                    DiaOK.setMessage(e.toString() + " SignIn button click");
                    DiaOK.show();
                }

            }
        });

        binding.tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Singup.class);
                startActivity(intent);
                finish();
            }
        });


    }

    //        });
//                }
    private void login(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    //Log.i("registrationLog", "Fail to login");
                    Toast.makeText(Login.this, "Please Input Correct Email or Password !",Toast.LENGTH_LONG).show();
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
