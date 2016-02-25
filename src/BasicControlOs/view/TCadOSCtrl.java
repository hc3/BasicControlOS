/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
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
public class TCadOSCtrl{
    @FXML
    private AnchorPane achorListOS;
    @FXML
    private Pane paneBtnOS;
    @FXML
    private Button btnCadOS;
    @FXML
    private Button btnEditOS;
    @FXML
    private Button btnDelOS;
    @FXML
    private Button btnCadSairOS;
    @FXML
    private TextField txtBuscaOs;
    @FXML
    private Button btnBuscaOS;
    @FXML
    private Pane paneListOS;
    @FXML
    private TableView<?> tbvOrdemServico;
    @FXML
    private TableColumn<?, ?> tcIdOS;
    @FXML
    private TableColumn<?, ?> tcDataOs;
    @FXML
    private TableColumn<?, ?> tcValorOs;
    @FXML
    private TableColumn<?, ?> tcUsuarioOS;
    @FXML
    private TableColumn<?, ?> tcVeicOs;

    private Run applicationRun;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        // TODO
    }    
    
    public void getApplicationRun(Run app) {
        this.applicationRun = app;
    }
}
