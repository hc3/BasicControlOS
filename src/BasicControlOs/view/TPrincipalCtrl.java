/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author hc3
 */
public class TPrincipalCtrl {
    @FXML
    private BorderPane panePrincipal;
    @FXML
    private Menu menuCadGeral;
    @FXML
    private MenuItem miCadVeiculo;
    @FXML
    private MenuItem miCadItem;
    @FXML
    private MenuItem miCadForec;
    @FXML
    private MenuItem miCadServico;
    @FXML
    private MenuItem miCadOs;
    
    private Run runApplication;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        // TODO
    }
    
    @FXML
    private void miCadVeiculoAction() {
       this.runApplication.showDisplayVeiculo();
    }
    
    // está como botão fechar por enquanto , rs
    @FXML
    private void miCadItemAction() {
        this.runApplication.showDisplayItem();
    }
    
    @FXML
    private void miCadFornecAction() {
        this.runApplication.showDisplayFornecedor();
    }
    
    @FXML 
    private void miCadServicoAction() {
        this.runApplication.showDisplayServico();
    }
    
    @FXML
    private void miCadOSAction() {
        this.runApplication.showDisplayOrdemServico();
    }
    
    public void getRunApplication(Run r) {
        this.runApplication = r;
    }
    
    
}
