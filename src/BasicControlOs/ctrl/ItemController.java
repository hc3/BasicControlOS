/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.ctrl;

import BasicControlOs.dao.ItemDAO;
import BasicControlOs.model.Item;
import java.util.Collection;

/**
 * @date Jan 27, 2016
 * @author hc3
 */
public class ItemController {
    
    private ItemDAO itemDAO;
    private Collection itens;
    
    public ItemController() {
        itemDAO = new ItemDAO();
    }
    
    
    public void criarItem(Item item) {
        itemDAO.beginTransaction();
        itemDAO.save(item);
        itemDAO.commitAndCloseTransaction();
    }
    
    public Collection<Item> listarItens() {
        itemDAO.beginTransaction();
        itens = itemDAO.findAll();
        return itens;
    }
    
    public void deletaItem(Item item) {
        itemDAO.beginTransaction();
        itemDAO.delete(item);
        itemDAO.commitAndCloseTransaction();
    }
    
    public Item buscaItem(int itemId) {
        itemDAO.beginTransaction();
        Item item = itemDAO.find(itemId);
        itemDAO.closeTransaction();
        return item;
    }
    
}
