package composer;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import communication.Pack;
import enums.Actions;
import intefaces.IModel;
import intefaces.IPack;
import model.Model;
import util.Return;
import validators.GenericValidator;
import viewController.ViewController;

public class GenericComposer extends SelectorComposer<Component>{
	protected IModel model;
	protected ListModelList<IModel> listModel;
	
	@Init
	public void init(){
		
	}
	
	@Command
	public void save(){
		Return retorno = new Return();
		retorno = GenericValidator.validate(model,retorno);
		
		if(retorno.getSucesso()){
			IPack pack = new Pack(Actions.INSERT, model,retorno);
			pack = ViewController.executeAction(pack);
			retorno = pack.getReturn();
			
			if(retorno.getSucesso()){
				Clients.showNotification("Operação concluida com sucesso!");
			}else{
				Clients.showNotification("Falha na inserção: " + retorno.getMessage());
			}
		}else{
			Messagebox.show(retorno.getAllMessages());
		}	
	}
	
	 @Command
	    public void delete(){
	    	
	    	  Messagebox.show("Deseja deletar o texto?", 
	            	    "Deletar texto?", Messagebox.OK | Messagebox.CANCEL,
	            	    Messagebox.QUESTION,
	            	        new org.zkoss.zk.ui.event.EventListener(){
	            	            public void onEvent(Event e){
	            	                if(Messagebox.ON_OK.equals(e.getName())){
	            	                	Return retorno = new Return();
	            	                	Pack pack = new Pack(Actions.DELETE, model, retorno);
	            	                	
	            	                	pack = (Pack) ViewController.executeAction(pack);
	            	                	retorno = pack.getReturn();
	            	                	
	            	            	    if(retorno.getSucesso()){
	            	            	    	Clients.showNotification("Deletado com sucesso: " + retorno.getMessage());
	            	            	    }else{
	            	            	    	Clients.showNotification("Falha ao deletar: " + retorno.getMessage());
	            	            	    }
	            	            	    listModel.remove(model);
	            	                }else if(Messagebox.ON_CANCEL.equals(e.getName())){
	            	                    //Cancel is clicked
	            	                }
	            	            }
	            	        }
	            	    );
	}
	 
    @Command
    public void update(){
    	Return retorno = new Return();
    	Pack pack = new Pack(Actions.UPDATE, model, retorno);
    	
    	pack = (Pack) ViewController.executeAction(pack);
    	retorno = pack.getReturn();
    	
    	if(retorno.getSucesso()){
    		Clients.showNotification("Atulizado com Sucesso!",true);
    	}else{
    		Clients.showNotification("Houve um problema na autentificacao: " + retorno.getMessage(), true);
    	}
    	
		
    }
    
    @Command
    public void cancel(){
    	Executions.sendRedirect("http://localhost:8080/Avaliacao_2VA_Douglas_de_Jesus_Costa/");
    }
    
    public List<IModel> selet(){
    	Return retorno = new Return();
    	
    	if(model != null){
	    	Pack pack = new Pack(Actions.SELECT, model, retorno);
	    	pack = (Pack) ViewController.executeAction(pack);
	    	retorno = pack.getReturn();
	    	return pack.getListModel();
    	}else{
    		Clients.showNotification("Houve um problema na autentificacao: " + retorno.getMessage(), true);
    		throw new RuntimeException("É necessário definir o modelo no metodo init antes de realizar o select");
    	}
    }
    
    public List<IModel> selet(IModel model){
    	Return retorno = new Return();
    	
    	if(model != null){
	    	Pack pack = new Pack(Actions.SELECT, model, retorno);
	    	pack = (Pack) ViewController.executeAction(pack);
	    	retorno = pack.getReturn();
	    	return pack.getListModel();
    	}else{
    		Clients.showNotification("Houve um problema na autentificacao: " + retorno.getMessage(), true);
    		throw new RuntimeException("É necessário definir o modelo no metodo init antes de realizar o select");
    	}
    }
    

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	public ListModelList<IModel> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<IModel> listModel) {
		this.listModel = listModel;
	}
}
