/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import BasicControlOs.ctrl.ServicoController;
import BasicControlOs.model.Servico;
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
public class TAddServCtrl {

    @FXML
    private AnchorPane achoInsertServico;
    @FXML
    private Pane paneInsertServico;
    @FXML
    private TextField txtDescServico;
    @FXML
    private TextField txtValorServico;
    @FXML
    private Button btnCadServico;
    @FXML
    private Button btnSairServico;

    private Run applicationRun;

    private TCadServicoCtrl telaCadServico;

    private Servico servico;

    private ServicoController servicoController;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        // TODO
    }

    @FXML
    private void btnCadServicoAction() {
        servico = new Servico();
        servico.setDescServico(txtDescServico.getText());
        servico.setValorServico(Double.parseDouble(txtValorServico.getText()));
        try {
            getController().criarServico(servico);
            criaAlerta("Servico cadastrado com sucesso!");
            this.telaCadServico.atualizaTableView();
        } catch (Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao cadastrar servico "+e.getMessage() );
        }
    }

    @FXML
    private void btnSairCadServicoAction() {

    }

    public void getApplicationRun(Run r, TCadServicoCtrl tela) {
        this.applicationRun = r;
        this.telaCadServico = tela;
    }

    private ServicoController getController() {
        if (servicoController == null) {
            servicoController = new ServicoController();
            return servicoController;
        } else {
            return servicoController;
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
    
    private void limparTextFields() {
        txtDescServico.setText("");
        txtValorServico.setText("");
    }

}
