/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.dao;

import BasicControlOs.model.Fornecedor;

/**
 * @date Jan 28, 2016
 * @author hc3
 */
public class FornecedorDAO extends GenericDAO<Fornecedor>{

    public FornecedorDAO() {
        super(Fornecedor.class);
    }
    
    public void delete(Fornecedor fornecedor) {
        super.delete(fornecedor.getIdFornecedor(), Fornecedor.class);
    }

}
