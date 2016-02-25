/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import BasicControlOs.ctrl.FornecedorController;
import BasicControlOs.model.Fornecedor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hc3
 */
public class TAddFornecCtrl {

    @FXML
    private AnchorPane achoInsertFornec;
    @FXML
    private Pane paneInsertFornec;
    @FXML
    private TextField txtRazaoFornec;
    @FXML
    private TextField txtSiglaFornec;
    @FXML
    private TextField txtCpnjFornec;
    @FXML
    private Button btnCadFornec;
    @FXML
    private Button btnSairFornec;

    private FornecedorController fornecedorController;

    private Run applicationRun;

    private Fornecedor fornecedor;
    
    private TCadFornecCtrl telaCadFornecedor;

    /**
     * Initializes the controller class.
     */

    @FXML
    private void initialize() {
        // TODO
    }

    @FXML
    private void btnCadFornecedorAction() {
        fornecedorController = getController();
        fornecedor = new Fornecedor();
        fornecedor.setRazaoFornecedor(txtRazaoFornec.getText());
        fornecedor.setSiglaFornecedor(txtSiglaFornec.getText());
        fornecedor.setCnpjFornecedor(Integer.parseInt(txtCpnjFornec.getText()));
        try {
            fornecedorController.criaFornecedor(fornecedor);
            criaAlerta("Fornecedor cadastrado com sucesso!");
            this.telaCadFornecedor.atualizaTable();
        } catch (Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao cadastrar fornecedor! "+e.getMessage());

        }
    }

    private void criaAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setContentText(mensagem);
        alert.setTitle("Sucesso");
        alert.show();
        limparTextFields();
    }

    private FornecedorController getController() {
        if (fornecedorController == null) {
            fornecedorController = new FornecedorController();
            return fornecedorController;
        } else {
            return fornecedorController;
        }
    }

    private void limparTextFields() {
        txtCpnjFornec.setText("");
        txtRazaoFornec.setText("");
        txtSiglaFornec.setText("");

    }

    public void getApplicationRun(Run r , TCadFornecCtrl tela) {
        this.applicationRun = r;
        this.telaCadFornecedor = tela;
    }
}
