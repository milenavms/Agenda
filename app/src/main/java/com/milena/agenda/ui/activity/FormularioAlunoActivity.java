package com.milena.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.milena.agenda.DAO.AlunoDAO;
import com.milena.agenda.R;
import com.milena.agenda.model.Aluno;

//Criandoo o aluno
public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        //DAO
        final AlunoDAO dao = new AlunoDAO();

        setTitle("Formulário de Alunos"); //Título da AppBar

        //Pego os id
        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);

        //Pego os id da button
        Button butaoSalvar = findViewById(R.id.activity_fomulario_aluno_button_salvar_aluno);

        butaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = campoNome.getText().toString();
                String telefone =  campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                //Salvando o aluno
                Aluno alunoCriado = new Aluno(nome, telefone, email);
                dao.salva(alunoCriado);


                //Indo para a Activity ListaAlunosActivity
                startActivity( new Intent(FormularioAlunoActivity.this, ListaAlunosActivity.class));


            }
        });

    }
}