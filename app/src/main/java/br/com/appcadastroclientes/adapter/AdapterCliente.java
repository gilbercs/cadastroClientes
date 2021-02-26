package br.com.appcadastroclientes.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.appcadastroclientes.R;
import br.com.appcadastroclientes.dao.DaoCliente;
import br.com.appcadastroclientes.model.ModelCliente;
import br.com.appcadastroclientes.telas.ClienteDetalhesActivity;
import br.com.appcadastroclientes.telas.ClientesActivity;

public class AdapterCliente extends RecyclerView.Adapter<AdapterCliente.MyViewHolder>{
    private List<ModelCliente> listCliente;
    private Context context;
    //Metodo Construtor
    public AdapterCliente(List<ModelCliente> listar, Context context) {
        this.listCliente =listar;
        this.context = context;
    }
    /*
    * Método que deverá retornar layout criado pelo ViewHolder já inflado em uma view.
    * */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemListaCliente = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.adapter_cliente, viewGroup, false);
        return new MyViewHolder(itemListaCliente);
    }
    /*
    /*Método que recebe o ViewHolder e a posição da lista. Aqui é recuperado o objeto da lista
    /*de Objetos pela posição e associado à ViewHolder. É onde a mágica acontece!  */
    @Override
    public  void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final ModelCliente cliente = listCliente.get(i);
        //retorna o nome do cliente
        myViewHolder.nomeCliente.setText(cliente.getCliNome());
        //evento para setar detalhes clientes
        myViewHolder.detalheCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Chama Detalhes",Toast.LENGTH_LONG).show();
                ModelCliente getDetalhe = listCliente.get(i);
                Intent intent = new Intent(context.getApplicationContext(), ClienteDetalhesActivity.class);
                intent.putExtra("keyDetalhes",getDetalhe);
                context.startActivity(intent);
            }
        });
        //evento para alterar cliente
        myViewHolder.alterarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Chama Alterar",Toast.LENGTH_LONG).show();
                ModelCliente getAlterar = listCliente.get(i);
                Intent intent = new Intent(context.getApplicationContext(), ClientesActivity.class);
                intent.putExtra("idCliente", getAlterar);
                context.startActivity(intent);
            }
        });
        //excluir cliente
        myViewHolder.excluirCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(myViewHolder.activity);
                builder.setCancelable(false);
                builder.setTitle("Excluir");
                builder.setPositiveButton("Confirma!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DaoCliente daoCliente = new DaoCliente(context);
                        Toast.makeText(context, "Delete", Toast.LENGTH_LONG).show();
                        ModelCliente deleteCliente = listCliente.get(i);
                        deleteCliente.getCliCodigo();
                        daoCliente.deleteCliente(deleteCliente);
                        listCliente.remove(i);
                        notifyItemRemoved(i);
                        notifyItemRangeChanged(i, getItemCount());
                    }
                });
                builder.setNegativeButton("Cancelar!", null);
                builder.create().show();
            }
        });

    }
    //metodo para verificar quantos item a na lista
    @Override
    public int getItemCount() {
            return this.listCliente.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        Context activity;
        TextView nomeCliente;
        TextView alterarCliente;
        TextView excluirCliente;
        TextView detalheCliente;
        //
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            activity = itemView.getContext();
            nomeCliente = itemView.findViewById(R.id.idTxtCliente);
            detalheCliente = itemView.findViewById(R.id.idTxtDetalheCliente);
            alterarCliente = itemView.findViewById(R.id.idTxtAlterarCliente);
            excluirCliente = itemView.findViewById(R.id.idTxtExcluirCliente);
        }
    }

}
