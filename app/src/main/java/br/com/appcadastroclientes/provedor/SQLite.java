package br.com.appcadastroclientes.provedor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLite extends SQLiteOpenHelper {
    //declaração de variaveis static
    public  static final String BASEDADOS = "baseDados.db";
    //declara de variavis static tabela
    public static final String TABELA_CLIENTE = "tb_cliente";
    //METODO CONSTRUTOR DA CLASSE SQLITE;
    public SQLite(Context context) {
        super(context, BASEDADOS, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //criando tabela cliente
        String sqlClinte = "create table if not exists " + TABELA_CLIENTE + "(cliCodigo integer primary key autoincrement," +
                "cliNome text not null," +
                "cliCelular text not null," +
                "cliEmail text not null," +
                "cliEndereco text not null," +
                "cliObservacao text)";
        try {
            //executar comando sqlite do cliente
            db.execSQL(sqlClinte);
        }catch (Exception erro){
            erro.printStackTrace();
            Log.i("Erro","Banco de dados: ");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table if not exists "+ TABELA_CLIENTE);
        onCreate(db);
    }
}
