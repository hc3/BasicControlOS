/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.ctrl;

import BasicControlOs.dao.FornecedorDAO;
import BasicControlOs.model.Fornecedor;
import java.util.Collection;

/**
 * @date Jan 28, 2016
 * @author hc3
 */
public class FornecedorController {

    private FornecedorDAO fornecedorDAO;
    private Collection<Fornecedor> listaFornecedores;
    
    public FornecedorController() {
        this.fornecedorDAO = new FornecedorDAO();
    }
    
    public void criaFornecedor(Fornecedor fornecedor) {
        fornecedorDAO.beginTransaction();
        fornecedorDAO.save(fornecedor);
        fornecedorDAO.commitAndCloseTransaction();
    }
    
    public Collection<Fornecedor> listaFornecedor() {
        fornecedorDAO.beginTransaction();
        this.listaFornecedores = fornecedorDAO.findAll();
        return this.listaFornecedores; 
    }
    
    public void EditarFornecedor(Fornecedor fornecedor) {
        fornecedorDAO.beginTransaction();
        fornecedorDAO.update(fornecedor);
        fornecedorDAO.commitAndCloseTransaction();
    }
    
    public void removeFornecedor(Fornecedor fornecedor) {
        fornecedorDAO.beginTransaction();
        fornecedorDAO.delete(fornecedor);
        fornecedorDAO.commitAndCloseTransaction();
    }
}
