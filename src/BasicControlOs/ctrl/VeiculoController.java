/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.ctrl;

import BasicControlOs.dao.VeiculoDAO;
import BasicControlOs.model.Veiculo;
import java.util.Collection;

/**
 * @date Jan 26, 2016
 * @author hc3
 */
public class VeiculoController {

    private final VeiculoDAO veiculoDAO;
    private Collection<Veiculo> listaVeiculos;

    public VeiculoController() {
        veiculoDAO = new VeiculoDAO();
      }
    
    public void criarVeiculo(Veiculo veiculo) {
        try{
            veiculoDAO.beginTransaction();
            veiculoDAO.save(veiculo);
            veiculoDAO.commitAndCloseTransaction();
        }catch(Exception e) {
            e.printStackTrace();
        }
    } 
    
    public void editarVeiculo(Veiculo veiculo) {
        veiculoDAO.beginTransaction();
        veiculoDAO.update(veiculo);
        veiculoDAO.commitAndCloseTransaction();
    }
    
    public void removerVeiculo(Veiculo veiculo) {
        veiculoDAO.beginTransaction();
        veiculoDAO.delete(veiculo);
        veiculoDAO.commitAndCloseTransaction();
    }
    
    public Veiculo buscaServico(int servicoId) {
        veiculoDAO.beginTransaction();
        Veiculo veiculo = veiculoDAO.find(servicoId);
        veiculoDAO.closeTransaction();
        return veiculo;
    }
    
    public Collection<Veiculo> listaVeiculo() {
        veiculoDAO.beginTransaction();
        listaVeiculos = veiculoDAO.findAll();
        veiculoDAO.closeTransaction();
        return listaVeiculos;
    }
    
    
}
