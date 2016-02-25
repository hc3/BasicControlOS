/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.dao;

import BasicControlOs.model.OrdemServico;
import BasicControlOs.model.Usuario;
import BasicControlOs.model.Veiculo;

/**
 * @date Jan 30, 2016
 * @author hc3
 */
public class OrdemServicoDAO extends GenericDAO<OrdemServico> {

    public OrdemServicoDAO() {
        super(OrdemServico.class);
    }
    
    public void removerOS(OrdemServico ordemServico) {
        super.delete(ordemServico.getIdOs(),OrdemServico.class);
    }
    
}
