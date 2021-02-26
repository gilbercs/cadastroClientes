package br.com.appcadastroclientes.telas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import br.com.appcadastroclientes.R;

public class MainActivity extends AppCompatActivity {
    //Classe Java Principal do App
    //declaração de camponentes do tipo linearLayout
    private LinearLayout linearCadastro;
    private LinearLayout linearListar;
    private LinearLayout linearAlterar;
    private LinearLayout linearExcluir;
    private void inicializarComponentes(){
        linearCadastro = (LinearLayout)findViewById(R.id.idLinearLayout01);
        linearListar = (LinearLayout)findViewById(R.id.idLinearLayout02);
        linearAlterar = (LinearLayout)findViewById(R.id.idLinearLayout03);
        linearExcluir = (LinearLayout)findViewById(R.id.idLinearLayout04);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //iniciar componentes
        inicializarComponentes();
        //evento de clique adicionar
        linearCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClientesActivity.class));
            }
        });
        //evento de clique encaminha para Lista
        linearListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListarClienteActivity.class));
            }
        });
        //evento de clique encaminha para Lista para o user escolher um user cadastro pra atualizar
        linearAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListarClienteActivity.class));
            }
        });
        ////evento de clique encaminha para Lista para o user escolher um user cadastrado para deletar
        linearExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListarClienteActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.idMainMenuSobre:
                startActivity(new Intent(MainActivity.this, SobreActivity.class));
                break;
            case R.id.idSairApp:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}