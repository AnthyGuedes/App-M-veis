package com.example.myapplicationstart;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;

public class AlunoDAO {

    private Conexao conexao;

    private SQLiteDatabase banco;

    //Context é usado para conexão

    public AlunoDAO(Context context){
        conexao = new Conexao(context); // cria conexão
        banco =  conexao.getWritableDatabase(); // inicia banco de dados para escrita
    }

    //Método para inserir

    public long Inserir(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("Nome",aluno.getNome());
        values.put("CPF",aluno.getCpf());
        values.put("Telefone",aluno.getTelefone());
        values.put("Endereco",aluno.getEndereco());
        values.put("Curso",aluno.getCurso());
        return banco.insert("aluno", null, values); //Tabela aluno não tera colunas vazias, valores values
    }

}
