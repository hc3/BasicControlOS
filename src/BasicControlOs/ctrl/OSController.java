/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.ctrl;

import BasicControlOs.dao.ItemDAO;
import BasicControlOs.dao.OrdemServicoDAO;
import BasicControlOs.dao.ServicoDAO;
import BasicControlOs.dao.VeiculoDAO;
import BasicControlOs.model.Item;
import BasicControlOs.model.OrdemServico;
import BasicControlOs.model.Servico;
import BasicControlOs.model.Veiculo;
import java.util.Collection;
import java.util.List;

/**
 * @date Jan 30, 2016
 * @author hc3
 */
public class OSController {

    private VeiculoDAO veiculoDAO;
    private OrdemServicoDAO osDAO;
    private ItemDAO itemDAO;
    private ServicoDAO servicoDAO;
    
    public OSController() {
        this.veiculoDAO = new VeiculoDAO();
        this.osDAO = new OrdemServicoDAO();
    }
    
    public void criarOS(OrdemServico os , Veiculo veiculo) {
        osDAO.beginTransaction();
        veiculoDAO.joinTransaction();
        veiculo = veiculoDAO.find(veiculo.getIdVeiculo());
        os.setIdVeiculo(veiculo);
        osDAO.save(os);
        osDAO.commitAndCloseTransaction();
    }
    
    public void criaOSCompleta() {
        
    }
    
    public void atualizaOS(OrdemServico os) {
        osDAO.beginTransaction();
        osDAO.update(os);
        osDAO.commitAndCloseTransaction();
    }
    
    public void deleteOS(OrdemServico os) {
        osDAO.beginTransaction();
        osDAO.removerOS(os);
        osDAO.commitAndCloseTransaction();
    }
    
    public OrdemServico buscaOS(int osId) {
        osDAO.beginTransaction();
        OrdemServico os = osDAO.find(osId);
        osDAO.closeTransaction();
        return os;
    }
    
    public Collection<OrdemServico> listaOS() {
        osDAO.beginTransaction();
        Collection<OrdemServico> listaOS = osDAO.findAll();
        osDAO.closeTransaction();
        return listaOS;
    }

}
