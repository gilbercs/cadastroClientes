package br.com.appcadastroclientes.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import br.com.appcadastroclientes.R;
import br.com.appcadastroclientes.model.ModelCliente;

public class ClienteDetalhesActivity extends AppCompatActivity {
    //Classe java p/ exibir detalhes do cliente
    private TextView txtCliNome, txtCliCelular, txtCliEmail, txtCliEndereco, txtCliObsercao;
    private ModelCliente detalhesClientes = new ModelCliente();
    /*Componentes Inicialização*/
    public void inicializarComponentes(){
        txtCliNome = (TextView)findViewById(R.id.idNome);
        txtCliCelular = (TextView)findViewById(R.id.idCelular);
        txtCliEmail = (TextView)findViewById(R.id.idEmail);
        txtCliEndereco = (TextView)findViewById(R.id.idEndereco);
        txtCliObsercao = (TextView)findViewById(R.id.idObservacao);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_detalhes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //inicializar Componentes
        inicializarComponentes();
        detalhesClientes = (ModelCliente)getIntent().getSerializableExtra("keyDetalhes");
        if (detalhesClientes!=null) {
            txtCliNome.setText("Nome: " + detalhesClientes.getCliNome());
            txtCliCelular.setText("Celular: " + detalhesClientes.getCliCelular());
            txtCliEmail.setText("Email: " + detalhesClientes.getCliEmail());
            txtCliEndereco.setText("Endereço: " + detalhesClientes.getCliEndereco());
            txtCliObsercao.setText("Observação: " + detalhesClientes.getCliObservacao());
        }else{
            Toast.makeText(ClienteDetalhesActivity.this,
                    "Vazio",Toast.LENGTH_LONG).show();
        }

    }
}