package composer;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.impl.BindChildRenderer;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import annotation.Column;
import communication.Pack;
import controller.ManterClassificacao;
import controller.ManterTexto;
import enums.Actions;
import intefaces.IModel;
import intefaces.IPack;
import model.Classification;
import model.Texts;
import util.Return;
import viewController.ViewController;

public class ListViewModel extends GenericComposer {
     
	private static final long serialVersionUID = 1L;
	private ListModelList<Classification> listClassifications;
	private String searchParamether1;

	
    @Init
    public void init(){
    	model = new Texts();

    	listModel = new ListModelList(super.selet());
		listClassifications =  new ListModelList(super.selet(new Classification()));
		searchParamether1 = "";
	
    }
    
    @Command
    public void delete(){
    	super.delete();
    }
    
    @Command
    @NotifyChange("listModel")
    public void search(){
    	Return retorno = new Return();
    	HashMap searchParamethers = new HashMap<String, Object>();
    	
    	searchParamethers.put("titulo", searchParamether1);
    	
    	IPack pack = new Pack(Actions.SELECT,model,retorno);
    	pack.setSearchParamethers(searchParamethers);
    	
    	pack =ViewController.executeAction(pack);
    	listModel = new ListModelList<IModel>(pack.getListModel());
    }
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ListModelList<Classification> getListClassifications() {
		return listClassifications;
	}

	public void setListClassifications(ListModelList<Classification> listClassifications) {
		this.listClassifications = listClassifications;
	}

	public String getSearchParamether1() {
		return searchParamether1;
	}

	public void setSearchParamether1(String searchParamether1) {
		this.searchParamether1 = searchParamether1;
	}

	
 
}
    