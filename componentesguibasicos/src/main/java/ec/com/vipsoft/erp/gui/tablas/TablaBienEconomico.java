package ec.com.vipsoft.erp.gui.tablas;

import com.vaadin.ui.Table;

public class TablaBienEconomico extends Table {
	public TablaBienEconomico() {
		super();
		setSelectable(true);
		setMultiSelect(true);
		setWidth("100%");
		setSizeFull();
		setPageLength(11);
		setColumnCollapsingAllowed(true);
		
	}
	private static final long serialVersionUID = 3090019113785431637L;

}
