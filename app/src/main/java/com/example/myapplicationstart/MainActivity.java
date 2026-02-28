package com.example.myapplicationstart;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText telefone;

    private AlunoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editTextNome);
        cpf = findViewById(R.id.editTextCpf);
        telefone = findViewById(R.id.editTextTelefone);

        dao = new AlunoDAO(this);
    }

    // Método para botão salvar
    public void salvar(View view){
        Aluno a = new Aluno();
        a.setNome(nome.getText().toString());
        a.setCpf(cpf.getText().toString());
        a.setTelefone(Integer.parseInt(telefone.getText().toString()));
        long id = dao.inserir(a); // inserir aluno
        Toast.makeText(this, "Aluno inserido com id: ", +id, Toast.LENGTH_SHORT).show();
    }

}