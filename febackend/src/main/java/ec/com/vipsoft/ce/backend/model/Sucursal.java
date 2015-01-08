package ec.com.vipsoft.ce.backend.model;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import java.lang.Override;
import java.util.List;

@Entity
public class Sucursal implements Serializable
{

   /**
	 * 
	 */
	private static final long serialVersionUID = -651167123376644306L;
@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;
   private Integer numeroSucursal;
   
   @OneToMany
   private List<PuntoEmision>puntosEmision;

   public List<PuntoEmision> getPuntosEmision() {
	return puntosEmision;
}

public void setPuntosEmision(List<PuntoEmision> puntosEmision) {
	this.puntosEmision = puntosEmision;
}

public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (id != null)
         result += "id: " + id;
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!(obj instanceof Sucursal))
      {
         return false;
      }
      Sucursal other = (Sucursal) obj;
      if (id != null)
      {
         if (!id.equals(other.id))
         {
            return false;
         }
      }
      return true;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

public Integer getNumeroSucursal() {
	return numeroSucursal;
}

public void setNumeroSucursal(Integer numeroSucursal) {
	this.numeroSucursal = numeroSucursal;
}
   
}