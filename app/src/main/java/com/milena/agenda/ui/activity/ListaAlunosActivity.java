package com.milena.agenda.ui.activity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.milena.agenda.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de Alunos"); //Título da AppBar

        //criando a lista de alunos
        List<String> alunos = new ArrayList<>(
                Arrays.asList("Ana", "Maria", "Júlia", "João","Ana", "Maria", "Júlia", "João", "João","Ana", "Maria", "Júlia", "João")
                );

        //Pego os id da lista de aluno estática no layout
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        //pegando os dados da lista e add / renderizando em uma View desejada
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, //com o adapter podemos criar uma lista de acordo com o numero de dados da nossa lista
                alunos));




    }


}
