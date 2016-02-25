/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.dao;

import BasicControlOs.model.Item;

/**
 * @date Jan 27, 2016
 * @author hc3
 */
public class ItemDAO extends GenericDAO<Item>{

    public ItemDAO() {
        super(Item.class);
    }
    
    public void delete(Item item) {
        super.delete(item.getIdItem(),Item.class);
    }

}
