package br.com.appcadastroclientes.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import br.com.appcadastroclientes.R;

public class SobreActivity extends AppCompatActivity {
    private TextView descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        descricao = (TextView)findViewById(R.id.idDescricaoApp);
        descricao.setText("Aplicativos Cadastro de Clientes desenvolvido para a plataforma Android," +
                "aplicando banco de dados SQLite. Utilizando a IDE oficial do Google Android Studio." +
                "Com o objetivo de servir como auxilio a estudantes e programadores iniciantes."+
                "\n"+"Nome App: Cadastro Clientes"+
                "\n"+"Modelo: Android"+
                "\n"+"Version: 1.0"+
                "\n"+"Marca: Yaco Tecnologia"+
                "\n"+"Lincença: open source"+
                "\n"+"Desenvolvedor: Gilber"+
                "\n\n"+"Contato:"+
                "\n"+"e-mail: gilbercs@hotmail.com"+
                "\n"+"celular: (92) 99312-4740");
    }
}