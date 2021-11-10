package com.milena.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.milena.agenda.R;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle("Formulário de Alunos"); //Título da AppBar
    }
}