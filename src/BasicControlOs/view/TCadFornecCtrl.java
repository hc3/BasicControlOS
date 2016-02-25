/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import BasicControlOs.ctrl.FornecedorController;
import BasicControlOs.model.Fornecedor;
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
public class TCadFornecCtrl {

    @FXML
    private AnchorPane achorListFornec;
    @FXML
    private Pane paneBtnFornec;
    @FXML
    private Button btnCadFornec;
    @FXML
    private Button btnEditFornec;
    @FXML
    private Button btnDelFornec;
    @FXML
    private Button btnCadSairFornec;
    @FXML
    private TextField txtBuscaFornec;
    @FXML
    private Button btnBuscaFornec;
    @FXML
    private Pane paneListFornec;
    @FXML
    private TableView<Fornecedor> tbvFornec;
    @FXML
    private TableColumn<Fornecedor, Integer> tcIdFornec;
    @FXML
    private TableColumn<Fornecedor, String> tcRazaoFornec;
    @FXML
    private TableColumn<Fornecedor, String> tcSiglaFornec;
    @FXML
    private TableColumn<Fornecedor, String> tcCnpjFornec;

    private Run applicationRun;

    private Collection<Fornecedor> listaFornecedores;

    private Fornecedor fornecedor;

    private FornecedorController fornecedorController;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        atualizaTable();
    }

    public void getApplicationRun(Run app) {
        this.applicationRun = app;
    }
    
    @FXML
    private void btnShowTelaCadFornecedor() {
       this.applicationRun.showDisplayAddFornecedor();
    }

    @FXML
    private void btnDeletaFornecedor() {
        this.fornecedor = getFornecedorClicked();
        try {
            getController().removeFornecedor(this.fornecedor);
            criaAlerta("Fornecedor excluido com sucesso");
            atualizaTable();
        } catch (Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao Fornecedor "+e.getMessage());
        }
    }

    private Collection<Fornecedor> carregaLista() {
        listaFornecedores = getController().listaFornecedor();
        return listaFornecedores;
    }

    private void initCellsTableView() {
        this.tcIdFornec.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
        this.tcRazaoFornec.setCellValueFactory(new PropertyValueFactory<>("razaoFornecedor"));
        this.tcSiglaFornec.setCellValueFactory(new PropertyValueFactory<>("siglaFornecedor"));
        this.tcCnpjFornec.setCellValueFactory(new PropertyValueFactory<>("cnpjFornecedor"));
    }

    public void atualizaTable() {
        ObservableList<Fornecedor> lista = FXCollections.observableArrayList(carregaLista());
        tbvFornec.setItems(lista);
        initCellsTableView();
    }

    private Fornecedor getFornecedorClicked() {
        this.fornecedor = new Fornecedor();
        this.fornecedor = tbvFornec.getSelectionModel().getSelectedItem();
        return this.fornecedor;
    }

    private FornecedorController getController() {
        if (this.fornecedorController == null) {
            fornecedorController = new FornecedorController();
            return fornecedorController;
        } else {
            return fornecedorController;
        }
    }

    private void criaAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setContentText(mensagem);
        alert.setTitle("Sucesso");
        alert.show();
    }

}
