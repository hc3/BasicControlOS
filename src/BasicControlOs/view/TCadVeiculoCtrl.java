/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import BasicControlOs.ctrl.VeiculoController;
import BasicControlOs.model.Veiculo;
import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
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
public class TCadVeiculoCtrl {

    @FXML
    private TableView<Veiculo> tbvVeiculos;
    @FXML
    private TableColumn<Veiculo, Integer> tcIdVeic;
    @FXML
    private TableColumn<Veiculo, String> tcPlacaVeic;
    @FXML
    private TableColumn<Veiculo, String> tcMarcaVEic;
    @FXML
    private TableColumn<Veiculo, String> tcModeloVeic;
    @FXML
    private TableColumn<Veiculo,String> tcPropVeiculo;
    
    private Run runApplication;

    private Collection<Veiculo> listaDeVeiculos;
    
    private Veiculo veiculo;

    private VeiculoController controller = null;
    @FXML
    private AnchorPane achorListVeic;
    @FXML
    private Pane paneBtnVeic;
    @FXML
    private Button btnCadVeic;
    @FXML
    private Button btnEditVeic;
    @FXML
    private Button btnDelVeic;
    @FXML
    private Button btnCadSair;
    @FXML
    private TextField txtBuscaVeic;
    @FXML
    private Button btnBuscaVeic;
    @FXML
    private MenuButton mbSelectTypeBusca;
    @FXML
    private Pane paneListVeic;
    
    private TEditVeiculoCtrl telaEditveiculoCtrl;

    @FXML
    private void initialize() {
        atualizaTabela();
    }
    


    public void getRunApplication(Run app) {
        this.runApplication = app;
    }

    @FXML
    private void btnShowDisplayAddVeiculo() {
        this.runApplication.showDisplayAddVeiculo();
    }

    private Collection<Veiculo> carregaListaVeiculos() {
        controller = getVeiculoController();
        listaDeVeiculos =  controller.listaVeiculo();
        return listaDeVeiculos;
    }

    public void atualizaTabela() {
        ObservableList<Veiculo> lista = FXCollections.observableArrayList(carregaListaVeiculos());
        tbvVeiculos.setItems(lista);
        initCellsTableView();
    }

    private void initCellsTableView() {
        this.tcIdVeic.setCellValueFactory(new PropertyValueFactory<>("idVeiculo"));
        this.tcPlacaVeic.setCellValueFactory(new PropertyValueFactory<>("placaVeiculo"));
        this.tcMarcaVEic.setCellValueFactory(new PropertyValueFactory<>("marcaVeiculo"));
        this.tcModeloVeic.setCellValueFactory(new PropertyValueFactory<>("modeloVeiculo"));
        this.tcPropVeiculo.setCellValueFactory(new PropertyValueFactory<>("nomeDonoVeiculo"));
    }
    
    public void btnEditarVeiculo() {
        this.runApplication.showDisplayEditVeiculo();
    }
    
    public Veiculo getClickInTableView() {
        veiculo = tbvVeiculos.getSelectionModel().getSelectedItem();
        return veiculo;
    }
    
    
    public void btnExcluiVeiculo() {
        veiculo = tbvVeiculos.getSelectionModel().getSelectedItem();
        controller = getVeiculoController();
        controller.removerVeiculo(veiculo);
        criaAlerta("Veiculo removido com sucesso!");
        atualizaTabela();
    }

    public Collection<Veiculo> getLista() {
       
        return this.listaDeVeiculos;
   
    }
    
    private VeiculoController getVeiculoController() {
       
        if(controller == null) {
           controller = new VeiculoController();
       }else {
           return controller;
       }
       return controller;
       
    }
    
      private void criaAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setContentText(mensagem);
        alert.setTitle("Sucesso");
        alert.show();
    }
}
