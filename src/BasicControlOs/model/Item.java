/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @date Jan 25, 2016
 * @author hc3
 */
@Entity
@Table(name = "Item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item")
    private Integer idItem;
    @Basic(optional = false)
    @Column(name = "desc_item")
    private String descItem;
    @Basic(optional = false)
    @Column(name = "price_item")
    private double priceItem;
    @Basic(optional = false)
    @Column(name = "qnt_item")
    private int qntItem;
    @Basic(optional = false)
    @Column(name = "marca_item")
    private String marcaItem;
    @Basic(optional = false)
    @Column(name = "cod_item")
    private String codItem;
    @JoinTable(name = "TrocaDePeca", joinColumns = {
        @JoinColumn(name = "id_item", referencedColumnName = "id_item")}, inverseJoinColumns = {
        @JoinColumn(name = "id_os", referencedColumnName = "id_os")})
    @ManyToMany
    private List<OrdemServico> ordemServicoList;
    @JoinTable(name = "Fornecimento", joinColumns = {
        @JoinColumn(name = "id_item", referencedColumnName = "id_item")}, inverseJoinColumns = {
        @JoinColumn(name = "id_fornecedor", referencedColumnName = "id_fornecedor")})
    @ManyToMany
    private List<Fornecedor> fornecedorList;

    public Item() {
    }

    public Item(Integer idItem) {
        this.idItem = idItem;
    }

    public Item(Integer idItem, String descItem, double priceItem, int qntItem, String marcaItem, String codItem) {
        this.idItem = idItem;
        this.descItem = descItem;
        this.priceItem = priceItem;
        this.qntItem = qntItem;
        this.marcaItem = marcaItem;
        this.codItem = codItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    public double getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(double priceItem) {
        this.priceItem = priceItem;
    }

    public int getQntItem() {
        return qntItem;
    }

    public void setQntItem(int qntItem) {
        this.qntItem = qntItem;
    }

    public String getMarcaItem() {
        return marcaItem;
    }

    public void setMarcaItem(String marcaItem) {
        this.marcaItem = marcaItem;
    }

    public String getCodItem() {
        return codItem;
    }

    public void setCodItem(String codItem) {
        this.codItem = codItem;
    }

    @XmlTransient
    public List<OrdemServico> getOrdemServicoList() {
        return ordemServicoList;
    }

    public void setOrdemServicoList(List<OrdemServico> ordemServicoList) {
        this.ordemServicoList = ordemServicoList;
    }

    @XmlTransient
    public List<Fornecedor> getFornecedorList() {
        return fornecedorList;
    }

    public void setFornecedorList(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BasicControlOs.model.Item[ idItem=" + idItem + " ]";
    }

}
