package br.com.appcadastroclientes.telas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import br.com.appcadastroclientes.R;
import br.com.appcadastroclientes.dao.DaoCliente;
import br.com.appcadastroclientes.model.ModelCliente;

public class ClientesActivity extends AppCompatActivity {
    //Classe java para entrada de dados: cadastro de cliente
    //declaração dos componentes
    private EditText campoNome, campoCelular, campoEmail, campoEndereco, campoObservacao;
    private String idCodigo;
    private Button botaoAdicionarCliente, botaoAlterarCliente;
    ModelCliente clienteAtual;
    //metodo para incializar componentes
    public void inicializarComponentes(){
        campoNome = (EditText)findViewById(R.id.idNome);
        campoCelular = (EditText)findViewById(R.id.idCelular);
        campoEmail = (EditText)findViewById(R.id.idEmail);
        campoEndereco = (EditText)findViewById(R.id.idEndereco);
        campoObservacao = (EditText)findViewById(R.id.idObservacao);
        botaoAdicionarCliente = (Button)findViewById(R.id.idBtnCadastro);
        botaoAlterarCliente =(Button)findViewById(R.id.idBtnAlterar);
    }
    //metodo para limpar campos EdiText
    public void limparCampos(){
        campoNome.setText("");
        campoCelular.setText("");
        campoEmail.setText("");
        campoEndereco.setText("");
        campoObservacao.setText("");
    }
    //metodo para cadastro de  cliente na base de dados: Tabela cliente
    public void cadastroCliente(View view){
        //declarar variaveis do tipos string para receber os atributos do cliente
        String txtNome, txtCelular, txtEmail, txtEndereco, txtObservacao;
        txtNome = campoNome.getText().toString();
        txtCelular = campoCelular.getText().toString();
        txtEmail = campoEmail.getText().toString();
        txtEndereco = campoEndereco.getText().toString();
        txtObservacao = campoObservacao.getText().toString();
        //realizar teste para verificar se os campos não estao vazio
        //se vazio retorna mensagens na tela para preencher o campo
        //Execeto campo observação
        if (!txtNome.isEmpty()){
            if (!txtCelular.isEmpty()){
                if (!txtEmail.isEmpty()){
                    if (!txtEndereco.isEmpty()){
                        //Instancia classe Dao cliente para chamar metodo de salvar na base de dados
                        DaoCliente escreverCliente = new DaoCliente(getBaseContext());
                        //instancia classe cliente do pacote model para atribuir o valores nos
                        //atributos da classe
                        ModelCliente setCliente = new ModelCliente();
                        //passando nos parametros os valores de entreda digitado pelo usuario
                        setCliente.setCliNome(txtNome);
                        setCliente.setCliCelular(txtCelular);
                        setCliente.setCliEmail(txtEmail);
                        setCliente.setCliEndereco(txtEndereco);
                        setCliente.setCliObservacao(txtObservacao);
                        //declarar variavel para receber um valor false o true
                        //que retorna da DaoCliente.salvar() que e boolean
                        boolean resultado;
                        //chamar o metodo salvar da classe DaoCliente para setar os atributos
                        //passar por paramentro os atributos do tipo cliente
                        resultado = escreverCliente.cadastroCliente(setCliente);
                        //verifica qual foi o tipo de retorno true ou false
                        if (resultado==true){
                            //Avisar para usuario na tela que os dados foram gravados com sucesso
                            //na base de dados: tabela cliente
                            //Aplicar Toas personalizado
                            Toast toast = Toast.makeText(ClientesActivity.this,"Cliente: "+txtNome+
                                            "\n"+"Adicionado com sucesso",
                                    Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER,0, 0);
                            LinearLayout toastContentView = (LinearLayout) toast.getView ();
                            ImageView imageView = new ImageView(getApplicationContext());
                            imageView.setImageResource(R.drawable.ic_positivo_24dp);
                            toastContentView.addView(imageView, 0);
                            toast.show();
                            //chamar metodo para limpar os campos, caso o usuario deseja cadastrar
                            //mais clientes
                            limparCampos();
                        }else {
                            //caso nao retornar true, Lançar Mensagens na tela
                            Toast.makeText(ClientesActivity.this,"Erro ao Adicionar cliente: "+txtNome,
                                    Toast.LENGTH_LONG).show();

                        }

                    }else {
                        Toast.makeText(ClientesActivity.this,"Preencha o campo Endereço!",
                                Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(ClientesActivity.this,"Preencha o campo Email!",
                            Toast.LENGTH_LONG).show();
                }

            }else {
                Toast.makeText(ClientesActivity.this,"Preencha o campo Celular!",
                        Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(ClientesActivity.this,"Preencha o campo nome!",
                    Toast.LENGTH_LONG).show();
        }
    }
    //metodo recuperar dados da lista de cliente passando dados entre activity listar e Cliente
    public void recebendoDadosAlterar(){
        clienteAtual =(ModelCliente) getIntent().getSerializableExtra("idCliente");
        //configurar valores na caixa de texto
        if (clienteAtual!=null){
            campoNome.setText(clienteAtual.getCliNome());
            campoCelular.setText(clienteAtual.getCliCelular());
            campoEmail.setText(clienteAtual.getCliEmail());
            campoEndereco.setText(clienteAtual.getCliEndereco());
            campoObservacao.setText(clienteAtual.getCliObservacao());
            botaoAdicionarCliente.setVisibility(View.GONE);
            botaoAlterarCliente.setVisibility(View.VISIBLE);
        }

    }
    //metodo para alterar dados: Tabela cliente
    public void alterarCliente(View view){
        String setNovoNome, setNovoCelular, setNovoEmail, setNovoEndereco, setNovoObservacao;
        setNovoNome = campoNome.getText().toString();
        setNovoCelular = campoCelular.getText().toString();
        setNovoEmail = campoEmail.getText().toString();
        setNovoEndereco = campoEndereco.getText().toString();
        setNovoObservacao = campoObservacao.getText().toString();
        if(!setNovoNome.isEmpty()){
            if(!setNovoCelular.isEmpty()){
                if(!setNovoEmail.isEmpty()){
                    if(!setNovoEndereco.isEmpty()){
                        DaoCliente rescreverCliente = new DaoCliente(getBaseContext());
                        ModelCliente setAlteracao = new ModelCliente();
                        setAlteracao.setCliNome(setNovoNome);
                        setAlteracao.setCliCelular(setNovoCelular);
                        setAlteracao.setCliEmail(setNovoEmail);
                        setAlteracao.setCliEndereco(setNovoEndereco);
                        setAlteracao.setCliObservacao(setNovoObservacao);
                        setAlteracao.setCliCodigo(clienteAtual.getCliCodigo());
                        Boolean resultado = rescreverCliente.alterarCliente(setAlteracao);
                        if (resultado==true){
                            Toast.makeText(ClientesActivity.this, "Dados atualizado com sucesso!", Toast.LENGTH_LONG).show();
                            limparCampos();
                            botaoAdicionarCliente.setVisibility(View.VISIBLE);
                            botaoAlterarCliente.setVisibility(View.GONE);
                        }

                    }else {
                        Toast.makeText(ClientesActivity.this, "Preencha o campo endereço", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(ClientesActivity.this, "Preencha o campo Email", Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(ClientesActivity.this, "Preencha o campo Celular", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(ClientesActivity.this, "Preencha o campo", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Inicializar Componentes
        inicializarComponentes();
        recebendoDadosAlterar();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cliente,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.idMenuLista:
                startActivity(new Intent(ClientesActivity.this,
                        ListarClienteActivity.class));
                break;
            case R.id.idMenuAlterar:
                startActivity(new Intent(ClientesActivity.this,
                        ListarClienteActivity.class));
                break;
            case R.id.idMenuExcluir:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}