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
public class TEditVeiculoCtrl {
    @FXML
    private AnchorPane achoEditVeic;
    @FXML
    private Pane paneEditVeic;
    @FXML
    private TextField txtNomeDonoEdit;
    @FXML
    private TextField txtCpfDonoVeicEdit;
    @FXML
    private TextField txtModeloVeicEdit;
    @FXML
    private TextField txtCorVeicEdit;
    @FXML
    private TextField txtMarcaVeicEdit;
    @FXML
    private TextField txtPlacaVeicEdit;
    @FXML
    private ComboBox<?> comboUfVeicEdit;
    @FXML
    private TextField txtAnoVeicEdit;
    @FXML
    private Button btnCadVeicEdit;
    @FXML
    private Button btnSairVeicEdit;
    @FXML
    private TextField txtKmVeiculoEdit;
    
    private Veiculo veiculo;
    
    private VeiculoController controller;
    
    private Run applicationRun;
    
    private TCadVeiculoCtrl telaCadVeiculoCtrl;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        initTextFields();
    }    
    
    private void initTextFields() {
        veiculo = telaCadVeiculoCtrl.getClickInTableView();
        txtAnoVeicEdit.setText(String.valueOf(veiculo.getAnoVeiculo()));
        txtCorVeicEdit.setText(veiculo.getCorVeiculo());
        txtCpfDonoVeicEdit.setText(veiculo.getCpfDonoVeiculo());
        txtKmVeiculoEdit.setText(String.valueOf(veiculo.getKmVeiculo()));
        txtMarcaVeicEdit.setText(veiculo.getMarcaVeiculo());
        txtModeloVeicEdit.setText(veiculo.getModeloVeiculo());
        txtNomeDonoEdit.setText(veiculo.getNomeDonoVeiculo());
        txtPlacaVeicEdit.setText(veiculo.getPlacaVeiculo());
    }
    
    public void getApplicationRun(Run run , TCadVeiculoCtrl tela) {
        this.applicationRun = run;
        this.telaCadVeiculoCtrl = tela;
    }
    
    public void getTCadVeiculo(Veiculo v) {
        this.veiculo = v;
    }
    
}
