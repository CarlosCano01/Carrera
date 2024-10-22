/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "cometarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cometarios.findAll", query = "SELECT c FROM Cometarios c"),
    @NamedQuery(name = "Cometarios.findById", query = "SELECT c FROM Cometarios c WHERE c.id = :id"),
    @NamedQuery(name = "Cometarios.findByTexto", query = "SELECT c FROM Cometarios c WHERE c.texto = :texto"),
    @NamedQuery(name = "Cometarios.findByPrivacidad", query = "SELECT c FROM Cometarios c WHERE c.privacidad = :privacidad")})
public class Cometarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Texto")
    private String texto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Privacidad")
    private String privacidad;
    @JoinColumn(name = "Usuario", referencedColumnName = "Id")
    @OneToOne(optional = false)
    private Usuarios usuario;
    @JoinColumn(name = "Articulo", referencedColumnName = "Id")
    @OneToOne(optional = false)
    private Articulos articulo;

    public Cometarios() {
    }

    public Cometarios(Integer id) {
        this.id = id;
    }

    public Cometarios(Integer id, String texto, String privacidad) {
        this.id = id;
        this.texto = texto;
        this.privacidad = privacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Articulos getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulos articulo) {
        this.articulo = articulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cometarios)) {
            return false;
        }
        Cometarios other = (Cometarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Cometarios[ id=" + id + " ]";
    }
    
}
