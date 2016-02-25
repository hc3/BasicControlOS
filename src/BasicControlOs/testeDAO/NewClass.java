/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.testeDAO;

import BasicControlOs.ctrl.ItemController;
import BasicControlOs.ctrl.OSController;
import BasicControlOs.ctrl.ServicoController;
import BasicControlOs.ctrl.VeiculoController;
import BasicControlOs.dao.VeiculoDAO;
import BasicControlOs.model.Item;
import BasicControlOs.model.OrdemServico;
import BasicControlOs.model.Servico;
import BasicControlOs.model.Veiculo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @date Jan 26, 2016
 * @author hc3
 */
public class NewClass {

    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo();
        VeiculoController controller = new VeiculoController();
        veiculo = controller.buscaServico(2);
        List<Servico> servico = new LinkedList<>();
        ServicoController controllerServico = new ServicoController();
        servico.add(controllerServico.buscaServico(1));
        List<Item> item = new LinkedList<>();
        ItemController itemController = new ItemController();
        item.add(itemController.buscaItem(1)); 
        OrdemServico os = new OrdemServico();
        OSController osController = new OSController();
        os.setDataOs(new Date());
        os.setIdVeiculo(veiculo);
        os.setItemList(item);
        os.setServicoList(servico);
        os.setValorOs(2000.40);
        osController.criarOS(os, veiculo);

    }

    public void addVeiculo() {
        Veiculo veiculo = new Veiculo();
        VeiculoController controller = new VeiculoController();

        veiculo.setNomeDonoVeiculo("Raul");
        veiculo.setModeloVeiculo("Civic");
        veiculo.setMarcaVeiculo("Honda");
        veiculo.setCorVeiculo("Preto");
        veiculo.setAnoVeiculo(2010);
        veiculo.setCpfDonoVeiculo("44988766809");
        veiculo.setPlacaVeiculo("PUE8902");
        veiculo.setUfVeiculo("BAHIA");

        try {
            controller.criarVeiculo(veiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editaVeiculo() {
        Veiculo veiculo = new Veiculo();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculo = veiculoDAO.find(10);
        veiculo.setNomeDonoVeiculo("editado agora");
        veiculoDAO.update(veiculo);
        System.out.println(veiculo.getNomeDonoVeiculo());

    }

    private void listaVeiculo() {
        Collection<Veiculo> veiculos = new ArrayList<>();
        VeiculoController controller = new VeiculoController();
        veiculos = controller.listaVeiculo();
        for (Veiculo v : veiculos) {
            System.out.println(v.getNomeDonoVeiculo());
        }
    }
}
