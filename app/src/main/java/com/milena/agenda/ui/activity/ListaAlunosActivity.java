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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Listando os alunos
public class ListaAlunosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de Alunos"); //Título da AppBar



        //Botão
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navendo para a tela de Formulario
                startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
            }
        });





    }

    //ciclo de vida onResume
    @Override
    protected void onResume() {
        super.onResume();

        //pegando a lista de Alunos
        AlunoDAO dao = new AlunoDAO();

        //Pego os id da lista de aluno estática no layout
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        //pegando os dados da lista( dao.todos()) e add / renderizando em uma View desejada
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, //com o adapter podemos criar uma lista de acordo com o numero de dados da nossa lista
                dao.todos()));

    }
}
