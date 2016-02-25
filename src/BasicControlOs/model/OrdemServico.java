/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @date Jan 25, 2016
 * @author hc3
 */
@Entity
@Table(name = "OrdemServico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemServico.findAll", query = "SELECT o FROM OrdemServico o")})
public class OrdemServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_os")
    private Integer idOs;
    @Basic(optional = false)
    @Column(name = "valor_os")
    private double valorOs;
    @Basic(optional = false)
    @Column(name = "data_os")
    @Temporal(TemporalType.DATE)
    private Date dataOs;
    @JoinTable(name = "ServicoEfetuado", joinColumns = {
        @JoinColumn(name = "id_os", referencedColumnName = "id_os")}, inverseJoinColumns = {
        @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")})
    @ManyToMany
    private List<Servico> servicoList;
    @ManyToMany(mappedBy = "ordemServicoList")
    private List<Item> itemList;
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id_veiculo")
    @ManyToOne(optional = false)
    private Veiculo idVeiculo;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public OrdemServico() {
    }

    public OrdemServico(Integer idOs) {
        this.idOs = idOs;
    }

    public OrdemServico(Integer idOs, double valorOs, Date dataOs) {
        this.idOs = idOs;
        this.valorOs = valorOs;
        this.dataOs = dataOs;
    }

    public Integer getIdOs() {
        return idOs;
    }

    public void setIdOs(Integer idOs) {
        this.idOs = idOs;
    }

    public double getValorOs() {
        return valorOs;
    }

    public void setValorOs(double valorOs) {
        this.valorOs = valorOs;
    }

    public Date getDataOs() {
        return dataOs;
    }

    public void setDataOs(Date dataOs) {
        this.dataOs = dataOs;
    }

    @XmlTransient
    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Veiculo getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Veiculo idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOs != null ? idOs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemServico)) {
            return false;
        }
        OrdemServico other = (OrdemServico) object;
        if ((this.idOs == null && other.idOs != null) || (this.idOs != null && !this.idOs.equals(other.idOs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BasicControlOs.model.OrdemServico[ idOs=" + idOs + " ]";
    }

}
