/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import BasicControlOs.ctrl.ItemController;
import BasicControlOs.model.Item;
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
public class TAddItemCtrl {

    @FXML
    private AnchorPane achoInsertItem;
    @FXML
    private Pane paneInsertItem;
    @FXML
    private TextField txtDescItem;
    @FXML
    private TextField txtMarcaItem;
    @FXML
    private TextField txtQntItem;
    @FXML
    private TextField txtPreItem;
    @FXML
    private TextField txtCodItem;
    @FXML
    private Button btnCadItem;
    @FXML
    private Button btnSairItem;

    private ItemController itemController;

    private Item item;

    private TCadItemCtrl telaCadItemCtrl;
    
    private Run applicationRun;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        // TODO
    }

    @FXML
    private void btnAddItemAction() {
        item = new Item();
        item.setDescItem(txtDescItem.getText());
        item.setMarcaItem(txtMarcaItem.getText());
        item.setPriceItem(Double.valueOf(txtPreItem.getText()));
        item.setQntItem(Integer.valueOf(txtQntItem.getText()));
        item.setCodItem(txtCodItem.getText());
        itemController = getController();
        try {
            itemController.criarItem(item);
            criaAlerta("Peça cadastrada com sucesso!");
            this.telaCadItemCtrl.atualizaTable();
        } catch (Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao cadastrar Peça");

        }
    }

    private ItemController getController() {
        if (itemController == null) {
            itemController = new ItemController();
            return itemController;
        } else {
            return itemController;
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
        txtCodItem.setText("");
        txtDescItem.setText("");
        txtMarcaItem.setText("");
        txtPreItem.setText("");
        txtQntItem.setText("");
    }
    
    private void getTextFields() {
        
    }
    
    public void getApplicationRun(Run r , TCadItemCtrl tela) {
        this.applicationRun = r;
        this.telaCadItemCtrl = tela;
    }

}
