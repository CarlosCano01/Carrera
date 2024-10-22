/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a"),
    @NamedQuery(name = "Articulos.findById", query = "SELECT a FROM Articulos a WHERE a.id = :id"),
    @NamedQuery(name = "Articulos.findByNombre", query = "SELECT a FROM Articulos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Articulos.findByPrecio", query = "SELECT a FROM Articulos a WHERE a.precio = :precio")})
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Precio")
    private String precio;
    @JoinColumn(name = "Usuario", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Usuarios usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articulo")
    private Collection<Cometarios> cometariosCollection;

    public Articulos() {
    }

    public Articulos(Integer id) {
        this.id = id;
    }

    public Articulos(Integer id, String nombre, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<Cometarios> getCometariosCollection() {
        return cometariosCollection;
    }

    public void setCometariosCollection(Collection<Cometarios> cometariosCollection) {
        this.cometariosCollection = cometariosCollection;
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
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Articulos[ id=" + id + " ]";
    }
    
}
