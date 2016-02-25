/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicControlOs.app;

import BasicControlOs.view.TAddFornecCtrl;
import BasicControlOs.view.TAddItemCtrl;
import BasicControlOs.view.TAddServCtrl;
import BasicControlOs.view.TCadVeiculoCtrl;
import BasicControlOs.view.TAddVeiculoCtrl;
import BasicControlOs.view.TCadFornecCtrl;
import BasicControlOs.view.TCadItemCtrl;
import BasicControlOs.view.TCadOSCtrl;
import BasicControlOs.view.TCadServicoCtrl;
import BasicControlOs.view.TEditVeiculoCtrl;
import BasicControlOs.view.TPrincipalCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @date Jan 25, 2016
 * @author hc3
 */
public class Run extends Application {

    private Stage stagePrincipal;
    private TPrincipalCtrl telaPrincipalCtrl;

    private Stage stageVeiculo;
    private TCadVeiculoCtrl telaCadVeiculo;

    private Stage stageAddVeiculo;
    private TAddVeiculoCtrl telaAddVeiculoCtrl;

    private Stage stageItem;
    private TCadItemCtrl telaCadItemCtrl;
    
    private Stage stageFornecedor;
    private TCadFornecCtrl telaCadFornecCtrl;
    
    private Stage stageServico;
    private TCadServicoCtrl telaCadServicoCtrl;
    
    private Stage stageOS;
    private TCadOSCtrl telaCadOrdemServicoCtrl;
    
    private Stage stageEditVeiculo;
    private TEditVeiculoCtrl telaEditVeiculo;
    
    private Stage stageAddItem;
    private TAddItemCtrl telaAddItemCtrl;
    
    private Stage stageAddFornecedor;
    private TAddFornecCtrl telaAddFornecCtrl;
    
    private Stage stageAddServico;
    private TAddServCtrl telaAddServicoCtrl;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        this.stagePrincipal.setTitle("Gerenciador de Oficina - OSM - version basic 001");
        this.stagePrincipal.setMaximized(true);
        initializeDisplay();
    }

    private void initializeDisplay() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaPrincipal.fxml"));
        try {
            BorderPane display = (BorderPane) leitor.load();
            Scene cena = new Scene(display);
            this.stagePrincipal.setScene(cena);
            this.telaPrincipalCtrl = leitor.getController();
            this.telaPrincipalCtrl.getRunApplication(this);

            this.stagePrincipal.show();
        } catch (Exception e) {
            e.getStackTrace();
            criaAlerta("Erro ao inicializar Display principal!");
        }
    }

    public void showDisplayVeiculo() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaCadVeiculo.fxml"));
        try {
            AnchorPane display = (AnchorPane) leitor.load();
            Scene cena = new Scene(display);
            this.stageVeiculo = new Stage();
            this.stageVeiculo.initModality(Modality.WINDOW_MODAL);
            this.telaCadVeiculo = leitor.getController();
            this.telaCadVeiculo.getRunApplication(this);
            this.stageVeiculo.setScene(cena);
            this.stageVeiculo.show();
        } catch (Exception e) {
            e.getStackTrace();
            criaAlerta("Erro ao inicializar Display de veiculos");
        }
    }
    

    public void showDisplayItem() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaCadItem.fxml"));
        try {
            AnchorPane display = (AnchorPane) leitor.load();
            Scene cena = new Scene(display);
            this.stageItem = new Stage();
            this.stageItem.initModality(Modality.WINDOW_MODAL);
            this.telaCadItemCtrl = leitor.getController();
            this.telaCadItemCtrl.getRunApplication(this);
            this.stageItem.setScene(cena);
            this.stageItem.show();
        } catch (Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao abrir tela de Peças");
        }
    }

    public void showDisplayFornecedor() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaCadFornecedor.fxml"));
        try{
            AnchorPane display = (AnchorPane) leitor.load();
            Scene cena = new Scene(display);
            this.stageFornecedor = new Stage();
            stageFornecedor.initModality(Modality.WINDOW_MODAL);
            this.telaCadFornecCtrl = leitor.getController();
            this.telaCadFornecCtrl.getApplicationRun(this);
            this.stageFornecedor.setScene(cena);
            this.stageFornecedor.show();
        }catch(Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao abrir tela de Fornecedor");
        }
    }
    
    public void showDisplayServico() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaCadServico.fxml"));
        try{
            AnchorPane display = (AnchorPane) leitor.load();
            Scene cena = new Scene(display);
            this.stageServico = new Stage();
            this.stageServico.initModality(Modality.WINDOW_MODAL);
            this.telaCadServicoCtrl = leitor.getController();
            this.telaCadServicoCtrl.getApplicationRun(this);
            this.stageServico.setScene(cena);
            this.stageServico.show();
        }catch(Exception e){
            e.printStackTrace();
            criaAlerta("Erro ao abrir tela de Servico");
        }
    }
    
    public void showDisplayOrdemServico() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaCadOrdemServico.fxml"));
        try{
            AnchorPane display = (AnchorPane) leitor.load();
            Scene cena = new Scene(display);
            this.stageOS = new Stage();
            this.stageOS.initModality(Modality.WINDOW_MODAL);
            this.telaCadOrdemServicoCtrl = leitor.getController();
            this.telaCadOrdemServicoCtrl.getApplicationRun(this);
            this.stageOS.setScene(cena);
            this.stageOS.show();
        }catch(Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao abrir tela de Ordem de Servico");
        }
    }
    
    public void showDisplayAddVeiculo() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaAddVeiculo.fxml"));
        try {
            AnchorPane display = (AnchorPane) leitor.load();
            Scene cena = new Scene(display);
            this.stageAddVeiculo = new Stage();
            this.stageAddVeiculo.initModality(Modality.WINDOW_MODAL);
            this.telaAddVeiculoCtrl = leitor.getController();
            this.telaAddVeiculoCtrl.getApplication(this, telaCadVeiculo);
            this.stageAddVeiculo.setScene(cena);
            this.stageAddVeiculo.show();

        }catch(Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao abrir tela de inclusão!");
        }
    }
    
    public void showDisplayAddItem() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaAddItem.fxml"));
        try{
            AnchorPane painel = (AnchorPane) leitor.load();
            Scene cena = new Scene(painel);
            this.stageAddItem = new Stage();
            this.stageAddItem.initModality(Modality.WINDOW_MODAL);
            this.telaAddItemCtrl = leitor.getController();
            this.telaAddItemCtrl.getApplicationRun(this, telaCadItemCtrl);
            this.stageAddItem.setScene(cena);
            this.stageAddItem.show();
        }catch(Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao abrir tela de Adição de itens");
        }
    }
    
    public void showDisplayAddFornecedor() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaAddFornecedor.fxml"));
        try{
            AnchorPane painel = (AnchorPane) leitor.load();
            Scene cena = new Scene(painel);
            this.stageAddFornecedor = new Stage();
            this.stageAddFornecedor.initModality(Modality.WINDOW_MODAL);
            this.telaAddFornecCtrl = leitor.getController();
            this.telaAddFornecCtrl.getApplicationRun(this, telaCadFornecCtrl);
            this.stageAddFornecedor.setScene(cena);
            this.stageAddFornecedor.show();
        }catch(Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao abrir tela de adição de fornecedores");
        }
    }
    
    public void showDisplayAddServico() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaAddServico.fxml"));
        try{
            AnchorPane painel = (AnchorPane) leitor.load();
            Scene cena = new Scene(painel);
            this.stageAddServico = new Stage();
            this.stageAddServico.initModality(Modality.WINDOW_MODAL);
            this.telaAddServicoCtrl = leitor.getController();
            this.telaAddServicoCtrl.getApplicationRun(this, telaCadServicoCtrl);
            this.stageAddServico.setScene(cena);
            this.stageAddServico.show();
        }catch(Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao abrir tela de adição de servicos");
        }
    }
    
    public void showDisplayEditVeiculo() {
        FXMLLoader leitor = new FXMLLoader(Run.class.getClassLoader().getResource("BasicControlOs/view/TelaEditVeiculo.fxml"));
        try{
            AnchorPane display = (AnchorPane) leitor.load();
            Scene cena = new Scene(display);
            this.stageEditVeiculo = new Stage();
            this.stageEditVeiculo.initModality(Modality.WINDOW_MODAL);
            this.telaEditVeiculo = leitor.getController();
            this.telaEditVeiculo.getApplicationRun(this , telaCadVeiculo);
            this.stageEditVeiculo.setScene(cena);
            this.stageEditVeiculo.show();
        }catch(Exception e) {
            e.printStackTrace();
            criaAlerta("Erro ao abrir tela de edição!");
        }
    }

    private void criaAlerta(String mensagem) {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setHeaderText("");
        dialog.setContentText(mensagem);
        dialog.setTitle("Error");
        dialog.show();
    }

}
