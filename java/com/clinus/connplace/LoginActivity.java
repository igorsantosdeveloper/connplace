package com.clinus.connplace;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity{

    private Button btnRegister;
    private Button btnLogin;
    private EditText editName;
    private EditText editPassword;
    private Message msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ToLocate locate = new ToLocate(this);
        createElements();
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Controller action = new Controller();
                if (action.authenticateUser(LoginActivity.this,
                        editName.getText().toString(), editPassword.getText().toString()) > -1) {

                    loginInto();
                } else {

                    showInvalid();
                }

            }
        });
    }

    public void showInvalid() {

        AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
        alert.setTitle(msg.getAttentionMessage());
        alert.setMessage(msg.getInvalidLogin());
        alert.setPositiveButton(msg.getOk(), null);
        alert.create();
        alert.show();
    }

    public void createElements() {

        btnRegister = (Button) findViewById(R.id.login_btnregister);
        btnLogin = (Button) findViewById(R.id.login_btnlogin);
        editName = (EditText) findViewById(R.id.login_editname);
        editPassword = (EditText) findViewById(R.id.login_editpassword);
        msg = new Message();
    }

    public void loginInto() {

        ToLocate locate = new ToLocate(this);
        locate.bringLocation();
        HomeActivity.setLoggingIn(true);
        Intent home = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(home);
    }
}












