package com.example.esb_2025;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername, editPwd;
    TextView txtUsernameErr, txtPwdErr;
    Button btnLogin, btnGoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id.editUsername);
        editPwd = findViewById(R.id.editPwd);

        txtUsernameErr = findViewById(R.id.txtUsernameErr);
        txtPwdErr = findViewById(R.id.txtPwdErr);

        btnLogin = findViewById(R.id.btnLogin);
        btnGoRegister = findViewById(R.id.btnGoRegister);

        btnLogin.setOnClickListener(v -> loginUser());
        btnGoRegister.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class))
        );
    }

    private void loginUser() {

        String user = editUsername.getText().toString().trim();
        String pwd = editPwd.getText().toString().trim();

        txtUsernameErr.setVisibility(View.GONE);
        txtPwdErr.setVisibility(View.GONE);

        if (user.isEmpty()) {
            txtUsernameErr.setText("Nom d'utilisateur requis");
            txtUsernameErr.setVisibility(View.VISIBLE);
            return;
        }

        if (pwd.isEmpty()) {
            txtPwdErr.setText("Mot de passe requis");
            txtPwdErr.setVisibility(View.VISIBLE);
            return;
        }

        UserDB userDB = new UserDB(this);
        userDB.open();

        boolean exists = userDB.checkUser(user, pwd);

        if (exists) {
            Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, DashboardActivity.class));
        } else {
            Toast.makeText(this, "Utilisateur introuvable", Toast.LENGTH_LONG).show();
        }

        userDB.close();
    }
}
