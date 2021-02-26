package br.com.appcadastroclientes.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.appcadastroclientes.metodo.MetodoCliente;
import br.com.appcadastroclientes.model.ModelCliente;
import br.com.appcadastroclientes.provedor.SQLite;

public class DaoCliente implements MetodoCliente {
    //declaração de variaveis para conectar ao banco de dados sqlite
    SQLiteDatabase sqlEscrever;
    SQLiteDatabase sqlLeitura;
    //metodo construtor da classe DaoCliente
    public DaoCliente(Context context) {
        SQLite base = new SQLite(context);
        //inserir dados da tabela
        sqlEscrever = base.getWritableDatabase();
        //realizar leitura na base de dados
        sqlLeitura = base.getReadableDatabase();
    }
    //metodo dao cadastro de cliente
    @Override
    public boolean cadastroCliente(ModelCliente mCliente) {
        //Classe Instancia para inserir dados na base de dados
        ContentValues valores = new ContentValues();
        //passar String key para inserir nos campos na tabela clientes
        //key declarada ao cria a tabela cliente: campos da tabela clientes
        valores.put("cliNome", mCliente.getCliNome());
        valores.put("cliCelular", mCliente.getCliCelular());
        valores.put("cliEmail", mCliente.getCliEmail());
        valores.put("cliEndereco", mCliente.getCliEndereco());
        valores.put("cliObservacao", mCliente.getCliObservacao());
        //lanchar um try caso returno false lance uma excption para tratar o erro
        try {
            //gravar na tabela clientes
            //passando no paramentro o nome da tabela e os valores
            sqlEscrever.insert(SQLite.TABELA_CLIENTE, null, valores);
            //retorna verdadeiro caso a inserir seja realizado com sucesso
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //metodo dao alterar cliente
    @Override
    public boolean alterarCliente(ModelCliente mCliente) {
        //Classe Instancia para inserir dados na base de dados
        ContentValues valores = new ContentValues();
        //passar String key para inserir nos campos na tabela clientes
        //key declarada ao cria a tabela cliente: campos da tabela clientes
        valores.put("cliNome", mCliente.getCliNome());
        valores.put("cliCelular", mCliente.getCliCelular());
        valores.put("cliEmail", mCliente.getCliEmail());
        valores.put("cliEndereco", mCliente.getCliEndereco());
        valores.put("cliObservacao", mCliente.getCliObservacao());
        //lançar o try para verificar se o bloco de codigo estao correto
        try {
            String[] codigo = {mCliente.getCliCodigo().toString()};
            //atualizar os dados na tabela clientes
            sqlEscrever.update(SQLite.TABELA_CLIENTE, valores, "cliCodigo = ?", codigo );
            //retorna verdadeiro caso a inserir seja realizado com sucesso
            return true;
        }catch (Exception e){
            Log.i("Informação: ","Erro ao atualizar dados: "+e.getMessage());
            return false;
        }
    }
    //metodo dao excluir cliente
    @Override
    public boolean deleteCliente(ModelCliente mCliente) {
        try {
            String[] codigo = {mCliente.getCliCodigo().toString()};
            sqlEscrever.delete(SQLite.TABELA_CLIENTE,"cliCodigo = ?", codigo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //metodo dao lista cliente
    @Override
    public List<ModelCliente> listarCliente() {
        //declarar variaveis para realizar a operação de listar
        //Vamos precisar:
        List<ModelCliente> clientes = new ArrayList<>();
        //vamos para o camando sqlite e atributo a uma strindo
        String sqlSelect = "select *from "+ SQLite.TABELA_CLIENTE+";";
        Cursor cursor = sqlLeitura.rawQuery(sqlSelect, null);

        //iniciar um while para percorrer os campos da tabela
        while (cursor.moveToNext()){
            //instanciar um cliente model
            ModelCliente cliente = new ModelCliente();

            Long codigo = cursor.getLong(cursor.getColumnIndex("cliCodigo"));
            //declarar variaves para receber os atributos da classe cliente
            String txtNome, txtCelular, txtEmail, txtEndereco, txtObservacao;
            txtNome = cursor.getString(cursor.getColumnIndex("cliNome"));
            txtCelular = cursor.getString(cursor.getColumnIndex("cliCelular"));
            txtEmail = cursor.getString(cursor.getColumnIndex("cliEmail"));
            txtEndereco = cursor.getString(cursor.getColumnIndex("cliEndereco"));
            txtObservacao = cursor.getString(cursor.getColumnIndex("cliObservacao"));

            cliente.setCliCodigo(codigo);
            cliente.setCliNome(txtNome);
            cliente.setCliCelular(txtCelular);
            cliente.setCliEmail(txtEmail);
            cliente.setCliEndereco(txtEndereco);
            cliente.setCliObservacao(txtObservacao);

            clientes.add(cliente);
        }

        return clientes;
    }
}
