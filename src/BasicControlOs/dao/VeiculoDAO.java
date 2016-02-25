/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.dao;

import BasicControlOs.model.Veiculo;

/**
 * @date Jan 26, 2016
 * @author hc3
 */
public class VeiculoDAO extends GenericDAO<Veiculo>{

    public VeiculoDAO() {
        super(Veiculo.class);
    }

    public void delete(Veiculo veiculo) {
        super.delete(veiculo.getIdVeiculo(), Veiculo.class);
    }
    
}
