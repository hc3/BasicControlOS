/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import BasicControlOs.ctrl.VeiculoController;
import BasicControlOs.model.Veiculo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hc3
 */
public class TAddVeiculoCtrl {
    @FXML
    private AnchorPane achoInsertVeic;
    @FXML
    private Pane paneInsertVeic;
    @FXML
    private TextField txtNomeDono;
    @FXML
    private TextField txtCpfDonoVeic;
    @FXML
    private TextField txtModeloVeic;
    @FXML
    private TextField txtCorVeic;
    @FXML
    private TextField txtKmVeiculo;
    @FXML
    private TextField txtMarcaVeic;
    @FXML
    private TextField txtPlacaVeic;
    @FXML
    private ComboBox<?> comboUfVeic;
    @FXML
    private TextField txtAnoVeic;
    @FXML
    private Button btnCadVeic;
    @FXML
    private Button btnSairVeic;
    
    private Run runApplication;
    
    private TCadVeiculoCtrl telaVeiculoCtrl;

    
    @FXML
    private void initialize() {
        
    }
    
    public void getApplication(Run app , TCadVeiculoCtrl ctrl) {
        this.runApplication = app;
        this.telaVeiculoCtrl = ctrl;
    }
    
    @FXML
    private void btnSairAddVeiculoAction() {
        
    }
    
    
    @FXML
    private void btnAddVeiculoAction() {
        Veiculo veiculo = new Veiculo();
        VeiculoController controller = new VeiculoController();
        veiculo.setAnoVeiculo(Integer.parseInt(txtAnoVeic.getText()));
        veiculo.setCorVeiculo(txtCorVeic.getText());
        veiculo.setCpfDonoVeiculo(txtCpfDonoVeic.getText());
        veiculo.setMarcaVeiculo(txtMarcaVeic.getText());
        veiculo.setModeloVeiculo(txtModeloVeic.getText());
        veiculo.setNomeDonoVeiculo(txtNomeDono.getText());
        veiculo.setPlacaVeiculo(txtPlacaVeic.getText());
        veiculo.setKmVeiculo(Double.valueOf(txtKmVeiculo.getText()));
        veiculo.setUfVeiculo("BAHIA");
        try{
            controller.criarVeiculo(veiculo);
            criaAlerta("Veiculo Cadastrado com sucesso");
            this.telaVeiculoCtrl.atualizaTabela();
            limparTextFields();
        }catch(Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao cadastrar veiculo "+e.getMessage());
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
    
    @FXML
    private void limparTextFields() {
       txtAnoVeic.setText("");
       txtCorVeic.setText("");
       txtCpfDonoVeic.setText("");
       txtKmVeiculo.setText("");
       txtMarcaVeic.setText("");
       txtModeloVeic.setText("");
       txtNomeDono.setText("");
       txtPlacaVeic.setText("");
    }
}
