package com.milena.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.milena.agenda.DAO.AlunoDAO;
import com.milena.agenda.R;
import com.milena.agenda.model.Aluno;

import org.jetbrains.annotations.NotNull;

//Criandoo o aluno
public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo Aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    //DAO
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);
        inicializacaoDosCampos();
        configuraBotaoSalvar();

    }

    private void configuraBotaoSalvar() {
        //Pego os id da button
        Button butaoSalvar = findViewById(R.id.activity_fomulario_aluno_button_salvar_aluno);

        butaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno alunoCriado = criaAluno();
                salvaAluno(alunoCriado);
            }
        });
    }

    private void inicializacaoDosCampos() {
        //Pego os id da activity
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }


    @NotNull
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        //Salvando o aluno
        Aluno alunoCriado = new Aluno(nome, telefone, email);

        return alunoCriado;
    }

    private void salvaAluno(Aluno aluno) {
        dao.salva(aluno);
        finish();
    }
}