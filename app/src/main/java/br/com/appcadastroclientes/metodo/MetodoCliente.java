package br.com.appcadastroclientes.metodo;

import java.util.List;

import br.com.appcadastroclientes.model.ModelCliente;

public interface MetodoCliente {
    //metodos que serao implementados de forma automatica no DaoCliente
    //Assim que a classe for implmentada
    public boolean cadastroCliente(ModelCliente mCliente);
    public boolean alterarCliente(ModelCliente mCliente);
    public boolean deleteCliente(ModelCliente mCliente);
    public List<ModelCliente> listarCliente();
}
