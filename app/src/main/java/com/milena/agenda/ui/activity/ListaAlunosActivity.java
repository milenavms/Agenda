package com.milena.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.milena.agenda.DAO.AlunoDAO;
import com.milena.agenda.R;

//Listando os alunos
public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    private final AlunoDAO dao = new AlunoDAO(); //pegando a lista de Alunos

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);

        configuraFabNovoAluno();

    }

    private void configuraFabNovoAluno() {
        //botaoNovoAluno
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFomrularioAluno();
            }
        });
    }

    private void abreFomrularioAluno() {
        //Navendo para a tela de Formulario
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    //ciclo de vida onResume
    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();

    }

    private void configuraLista() {
        //Pego os id da lista de aluno estática no layout
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        //pegando os dados da lista( dao.todos()) e add / renderizando em uma View desejada
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, //com o adapter podemos criar uma lista de acordo com o numero de dados da nossa lista
                dao.todos()));
    }
}
