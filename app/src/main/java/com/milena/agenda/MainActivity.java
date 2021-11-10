package com.milena.agenda;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de Alunos"); //Título da AppBar

        //criando a lista de alunos
        List<String> alunos = new ArrayList<>(
                Arrays.asList("Ana", "Maria", "Júlia", "João","Ana", "Maria", "Júlia", "João", "João","Ana", "Maria", "Júlia", "João")
                );

        //Pego os id da lista de aluno estática no layout
        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);
        //pegando os dados da lista e add / renderizando em uma View desejada
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, //com o adapter podemos criar uma lista de acordo com o numero de dados da nossa lista
                alunos));




    }


}
