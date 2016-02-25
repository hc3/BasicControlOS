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
@Table(name = "Fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;
    @Basic(optional = false)
    @Column(name = "razao_fornecedor")
    private String razaoFornecedor;
    @Basic(optional = false)
    @Column(name = "sigla_fornecedor")
    private String siglaFornecedor;
    @Basic(optional = false)
    @Column(name = "cnpj_fornecedor")
    private int cnpjFornecedor;
    @ManyToMany(mappedBy = "fornecedorList")
    private List<Item> itemList;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Fornecedor(Integer idFornecedor, String razaoFornecedor, String siglaFornecedor, int cnpjFornecedor) {
        this.idFornecedor = idFornecedor;
        this.razaoFornecedor = razaoFornecedor;
        this.siglaFornecedor = siglaFornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoFornecedor() {
        return razaoFornecedor;
    }

    public void setRazaoFornecedor(String razaoFornecedor) {
        this.razaoFornecedor = razaoFornecedor;
    }

    public String getSiglaFornecedor() {
        return siglaFornecedor;
    }

    public void setSiglaFornecedor(String siglaFornecedor) {
        this.siglaFornecedor = siglaFornecedor;
    }

    public int getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(int cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BasicControlOs.model.Fornecedor[ idFornecedor=" + idFornecedor + " ]";
    }

}
