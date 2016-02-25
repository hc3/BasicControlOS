/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import BasicControlOs.ctrl.OSController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hc3
 */
public class TAddOSCtrl {
    @FXML
    private AnchorPane achoInsertOS;
    @FXML
    private Pane paneInsertOS;
    @FXML
    private Pane paneIncVeicOS;
    @FXML
    private TextField txtNomeVeicOS;
    @FXML
    private TextField txtIncPlacaVeicOS;
    @FXML
    private TextField txtMarcaVeicOS;
    @FXML
    private TextField txtModVeicOS;
    @FXML
    private Button btnBuscaVeicOS;
    @FXML
    private Pane paneListServOS;
    @FXML
    private Button btnIncludeServOS;
    @FXML
    private TableView<?> tbvListServOS;
    @FXML
    private TableColumn<?, ?> tcCodServOS;
    @FXML
    private TableColumn<?, ?> tcDescServOS;
    @FXML
    private TableColumn<?, ?> tcValorServOS;
    @FXML
    private Button btnRemoveServOS;
    @FXML
    private Button btnIncludeItem;
    @FXML
    private TableView<?> tbvListItemOS;
    @FXML
    private TableColumn<?, ?> tcCodItemOS;
    @FXML
    private TableColumn<?, ?> tcDescItemOS;
    @FXML
    private TableColumn<?, ?> tcPrecoItemOS;
    @FXML
    private TableColumn<?, ?> tcMarcaItemOS;
    @FXML
    private Button btnRemoveItemOS;
    @FXML
    private Button btnIncludeOS;
    @FXML
    private Button btnLimparOS;
    @FXML
    private Button btnSairIncOS;
    
    private OSController osController;
    
    private TCadOSCtrl telaCadOS;
    
    private Run application;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        // TODO
    }
    
    @FXML
    private void btnBuscaVeiculo() {
        
    }

    
    public void getApplicationRun(Run r , TCadOSCtrl tela) {
        this.telaCadOS = tela;
        this.application = r;
    }
}
