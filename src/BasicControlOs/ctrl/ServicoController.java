/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.ctrl;

import BasicControlOs.dao.ServicoDAO;
import BasicControlOs.model.Servico;
import java.util.Collection;

/**
 * @date Jan 27, 2016
 * @author hc3
 */
public class ServicoController {

    private final ServicoDAO servicoDAO;
    private Collection<Servico> listaServicos;
    
    public ServicoController() {
        servicoDAO = new ServicoDAO();
    }
    
    public void deletarServico(Servico servico) {
        servicoDAO.beginTransaction();
        servicoDAO.deletar(servico);
        servicoDAO.commitAndCloseTransaction();
    }
    
    public void criarServico(Servico servico) {
        servicoDAO.beginTransaction();
        servicoDAO.save(servico);
        servicoDAO.commitAndCloseTransaction();
    }
    
    public Collection<Servico> listaServicos() {
        servicoDAO.beginTransaction();
        listaServicos = servicoDAO.findAll();
        servicoDAO.closeTransaction();
        return listaServicos;
    }
    
    public Servico buscaServico(int servicoId) {
        servicoDAO.beginTransaction();
        Servico servico = servicoDAO.find(servicoId);
        servicoDAO.closeTransaction();
        return servico;
    }
}
