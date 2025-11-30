package com.example.esb_2025;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText editUser, editPwd, editCin, editFirstname, editLastname;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editUser = findViewById(R.id.editUser);
        editPwd = findViewById(R.id.editPwd);
        editCin = findViewById(R.id.editCin);
        editFirstname = findViewById(R.id.editFirstname);
        editLastname = findViewById(R.id.editLastname);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {

        String username = editUser.getText().toString().trim();
        String pwd = editPwd.getText().toString().trim();
        String cin = editCin.getText().toString().trim();
        String firstname = editFirstname.getText().toString().trim();
        String lastname = editLastname.getText().toString().trim();

        if (username.isEmpty() || pwd.isEmpty() || cin.isEmpty() ||
                firstname.isEmpty() || lastname.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(username, pwd, cin, firstname, lastname);

        UserDB db = new UserDB(this);
        db.open();
        long id = db.insertUser(user);
        db.close();

        if (id != -1) {
            Toast.makeText(this, "Inscription réussie", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Erreur lors de l'inscription", Toast.LENGTH_SHORT).show();
        }
    }
}

