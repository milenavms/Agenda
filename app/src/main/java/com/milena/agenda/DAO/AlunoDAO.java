package com.milena.agenda.DAO;

import com.milena.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    //Criando uma lista estática para salvar os dados dos alunos pois ainda não estamos utilizando banco de dados.
    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> todos() {
        //O retorno será uma nova lista de alunos.
        return  new ArrayList<>(alunos);
    }
}
