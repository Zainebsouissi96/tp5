package com.example.esb_2025;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private TextView txtUsernameErr, txtPwdErr;
    private Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        txtUsernameErr = findViewById(R.id.txtusername);
        txtPwdErr = findViewById(R.id.txtpwd);
        btnConnect = findViewById(R.id.btnconnect1);

        btnConnect.setOnClickListener(v -> login());
    }

    private void login() {

        txtUsernameErr.setVisibility(View.GONE);
        txtPwdErr.setVisibility(View.GONE);

        String userStr = editTextUsername.getText().toString().trim();
        String pwdStr = editTextPassword.getText().toString().trim();

        boolean valid = true;

        if (userStr.isEmpty()) {
            txtUsernameErr.setText(getString(R.string.log_err_requis));
            txtUsernameErr.setVisibility(View.VISIBLE);
            valid = false;
        }

        if (pwdStr.isEmpty()) {
            txtPwdErr.setText(getString(R.string.log_err_requis));
            txtPwdErr.setVisibility(View.VISIBLE);
            valid = false;
        }

        if (!valid) return;

        // -------- TP5 : VÉRIFICATION DANS LA BASE --------
        UserDB userDB = new UserDB(MainActivity.this);
        userDB.open();

        boolean exists = userDB.checkUser(userStr, pwdStr);

        userDB.close();

        if (exists) {
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            intent.putExtra("USERNAME", userStr);
            startActivity(intent);
            finish();
        } else {
            txtPwdErr.setText(getString(R.string.log_err_cnx));
            txtPwdErr.setVisibility(View.VISIBLE);
        }
    }
}

