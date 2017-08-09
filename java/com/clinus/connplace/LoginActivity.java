package com.clinus.connplace;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                ServiceController controller = new ServiceController();
                if (controller.authenticateUser(editName.getText().toString(), editPassword.getText().toString())) {

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
        ServiceController controller = new ServiceController();
        HomeActivity.setNameUser(editName.getText().toString());
        HomeActivity.setIdUser(controller.getUserId(HomeActivity.getNameUser()));
        locate.overlapLocation();
        Intent home = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(home);
    }
}












