/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.dao;

import BasicControlOs.model.Servico;

/**
 * @date Jan 27, 2016
 * @author hc3
 */
public class ServicoDAO extends GenericDAO<Servico>{

    public ServicoDAO() {
        super(Servico.class);
    }
    
    public void deletar(Servico servico) {
        super.delete(servico.getIdServico(), Servico.class);
    }

}
