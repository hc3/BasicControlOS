/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @date Jan 25, 2016
 * @author hc3
 */
@Entity
@Table(name = "Veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v")})
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_veiculo")
    private Integer idVeiculo;
    @Basic(optional = false)
    @Column(name = "modelo_veiculo")
    private String modeloVeiculo;
    @Basic(optional = false)
    @Column(name = "marca_veiculo")
    private String marcaVeiculo;
    @Basic(optional = false)
    @Column(name = "ano_veiculo")
    private Integer anoVeiculo;
    @Basic(optional = false)
    @Column(name = "cor_veiculo")
    private String corVeiculo;
    @Basic(optional = false)
    @Column(name = "km_veiculo")
    private Double kmVeiculo;
    @Basic(optional = false)
    @Column(name = "placa_veiculo")
    private String placaVeiculo;
    @Basic(optional = false)
    @Column(name = "uf_veiculo")
    private String ufVeiculo;
    @Basic(optional = false)
    @Column(name = "nome_dono_veiculo")
    private String nomeDonoVeiculo;
    @Basic(optional = false)
    @Column(name = "cpf_dono_veiculo")
    private String cpfDonoVeiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVeiculo")
    private Collection<OrdemServico> ordemServicoList;

    public Veiculo() {
  
    }

    public Veiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Veiculo(Integer idVeiculo, String modeloVeiculo, String marcaVeiculo, Integer anoVeiculo, String corVeiculo, Double kmVeiculo, String placaVeiculo, String ufVeiculo, String nomeDonoVeiculo, String cpfDonoVeiculo, Collection<OrdemServico> ordemServicoList) {
        this.idVeiculo = idVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.corVeiculo = corVeiculo;
        this.kmVeiculo = kmVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.ufVeiculo = ufVeiculo;
        this.nomeDonoVeiculo = nomeDonoVeiculo;
        this.cpfDonoVeiculo = cpfDonoVeiculo;
        this.ordemServicoList = ordemServicoList;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public Integer getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(Integer anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }

    public Double getKmVeiculo() {
        return kmVeiculo;
    }

    public void setKmVeiculo(Double kmVeiculo) {
        this.kmVeiculo = kmVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getUfVeiculo() {
        return ufVeiculo;
    }

    public void setUfVeiculo(String ufVeiculo) {
        this.ufVeiculo = ufVeiculo;
    }

    public String getNomeDonoVeiculo() {
        return nomeDonoVeiculo;
    }

    public void setNomeDonoVeiculo(String nomeDonoVeiculo) {
        this.nomeDonoVeiculo = nomeDonoVeiculo;
    }

    public String getCpfDonoVeiculo() {
        return cpfDonoVeiculo;
    }

    public void setCpfDonoVeiculo(String cpfDonoVeiculo) {
        this.cpfDonoVeiculo = cpfDonoVeiculo;
    }

    public Collection<OrdemServico> getOrdemServicoList() {
        return ordemServicoList;
    }

    public void setOrdemServicoList(Collection<OrdemServico> ordemServicoList) {
        this.ordemServicoList = ordemServicoList;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVeiculo != null ? idVeiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.idVeiculo == null && other.idVeiculo != null) || (this.idVeiculo != null && !this.idVeiculo.equals(other.idVeiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BasicControlOs.model.Veiculo[ idVeiculo=" + idVeiculo + " ]";
    }

}
