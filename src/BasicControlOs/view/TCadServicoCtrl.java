/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import BasicControlOs.ctrl.ServicoController;
import BasicControlOs.model.Servico;
import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hc3
 */
public class TCadServicoCtrl {

    @FXML
    private AnchorPane achorListServico;
    @FXML
    private Pane paneBtnServico;
    @FXML
    private Button btnCadServico;
    @FXML
    private Button btnEditServico;
    @FXML
    private Button btnDelServico;
    @FXML
    private Button btnCadSairServ;
    @FXML
    private TextField txtBuscaServico;
    @FXML
    private Button btnBuscaServico;
    @FXML
    private Pane paneListServ;
    @FXML
    private TableView<Servico> tbvServico;
    @FXML
    private TableColumn<Servico, Integer> tcIdServico;
    @FXML
    private TableColumn<Servico, String> tcDescServ;
    @FXML
    private TableColumn<Servico, Double> tcValorServ;

    private Run applicationRun;

    private Collection<Servico> listaServicos;

    private Servico servico;

    private ServicoController servicoController;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        atualizaTableView();
    }
    
    @FXML
    private void brtnCadServicoAction() {
        this.applicationRun.showDisplayAddServico();
    }

    @FXML
    private void btnExcluirServicoAction() {
        this.servico = getClickedServico();
        try {
            getController().deletarServico(this.servico);
            criaAlerta("Servico excluido com sucesso!");
            atualizaTableView();
        } catch (Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao excluir Servico");
        }
    }

    private Servico getClickedServico() {
        this.servico = new Servico();
        this.servico = tbvServico.getSelectionModel().getSelectedItem();
        return this.servico;
    }

    public void getApplicationRun(Run app) {
        this.applicationRun = app;
    }

    private ServicoController getController() {
        if (servicoController == null) {
            servicoController = new ServicoController();
            return servicoController;
        } else {
            return servicoController;
        }
    }

    private Collection<Servico> carregaLista() {
        listaServicos = getController().listaServicos();
        return listaServicos;
    }

    private void initCellsTableView() {
        tcIdServico.setCellValueFactory(new PropertyValueFactory<>("idServico"));
        tcDescServ.setCellValueFactory(new PropertyValueFactory<>("descServico"));
        tcValorServ.setCellValueFactory(new PropertyValueFactory<>("valorServico"));
    }

    public void atualizaTableView() {
        ObservableList<Servico> lista = FXCollections.observableArrayList(carregaLista());
        tbvServico.setItems(lista);
        initCellsTableView();
    }

    private void criaAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setContentText(mensagem);
        alert.setTitle("Sucesso");
        alert.show();
    }


}
