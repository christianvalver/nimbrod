package ec.com.vipsoft.erp.gui.bindingbeans;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class CatalogoBienEconomicos implements Serializable{

	private static final long serialVersionUID = 8214469422212048076L;

	public CatalogoBienEconomicos() {
		super();
		bienes=new TreeSet<BienEconomicoBiding>();
	}

	protected Set<BienEconomicoBiding>bienes;

	public Set<BienEconomicoBiding> getBienes() {
		return bienes;
	}

	public void setBienes(Set<BienEconomicoBiding> bienes) {
		this.bienes = bienes;
	}
	
}
