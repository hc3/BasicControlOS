/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.view;

import BasicControlOs.app.Run;
import BasicControlOs.ctrl.ItemController;
import BasicControlOs.model.Item;
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
public class TCadItemCtrl{
    @FXML
    private AnchorPane achorListItem;
    @FXML
    private Pane paneBtnItem;
    @FXML
    private Button btnCadItem;
    @FXML
    private Button btnEditItem;
    @FXML
    private Button btnDelItem;
    @FXML
    private Button btnCadSairItem;
    @FXML
    private TextField txtBuscaItem;
    @FXML
    private Button btnBuscaItem;
    @FXML
    private Pane paneListItem;
    @FXML
    private TableView<Item> tbvItens;
    @FXML
    private TableColumn<Item,String> tcCodItem;
    @FXML
    private TableColumn<Item,String> tcDescItem;
    @FXML
    private TableColumn<Item,Double> tcPrecoItem;
    @FXML
    private TableColumn<Item,Integer> tcQntItem;
    @FXML
    private TableColumn<Item,String> tcMarcaItem;
    
    private Run applicationRun;
    
    private Item item;
    
    private Collection<Item> itens;
    
    private ItemController itemController = null;
    

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        atualizaTable();
    }    
    
    @FXML
    private void btnSairTelaItem() {
        
    }
    
    public void getRunApplication(Run app) {
        this.applicationRun = app;
    }
    
    @FXML
    private void btnShowDisplayAddItemAction() {
        this.applicationRun.showDisplayAddItem();
    }
    
    @FXML
    private void btnExcluirItemAction() {
        itemController = getController();
        item = new Item();
        item = tbvItens.getSelectionModel().getSelectedItem();
        try{
            itemController.deletaItem(item);
            criaAlerta("Item excluido com sucesso!");
            atualizaTable();
        }catch(Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao excluir item!");
        }
    }
    
    private Collection<Item> carregaListaItens() {
        itens = getController().listarItens();
        return itens;
    }
    
    
    public void atualizaTable() {
        ObservableList<Item> lista = FXCollections.observableArrayList(carregaListaItens());
        tbvItens.setItems(lista);
        initCellsTableView();
    }
    
    private void initCellsTableView() {
        this.tcCodItem.setCellValueFactory(new PropertyValueFactory<>("codItem"));
        this.tcDescItem.setCellValueFactory(new PropertyValueFactory<>("descItem"));
        this.tcMarcaItem.setCellValueFactory(new PropertyValueFactory<>("marcaItem"));
        this.tcPrecoItem.setCellValueFactory(new PropertyValueFactory<>("priceItem"));
        this.tcQntItem.setCellValueFactory(new PropertyValueFactory<>("qntItem"));
    }
    
    private ItemController getController() {
      
        if(itemController == null) {
            itemController = new ItemController();
            return itemController;
        }else{
            return itemController;
        }
        
    }
    
    public Collection<Item> getItens() {
        
        return this.itens;
    
    }
    
        private void criaAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setContentText(mensagem);
        alert.setTitle("Sucesso");
        alert.show();
    }
    
}
