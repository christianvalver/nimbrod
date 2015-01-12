package ec.com.vipsoft.erp.gui.tablas;

import com.vaadin.ui.Table;

public class TablaFacturaDetalle extends Table{
	private static final long serialVersionUID = -1161381380064981536L;

	public TablaFacturaDetalle() {
		super();
		setSelectable(true);
		setMultiSelect(true);
		setWidth("100%");
		setSizeFull();
		setPageLength(8);
		setColumnCollapsingAllowed(true);
		setEditable(true);		
	//	setNullRepresentation("");
		
	}

}
