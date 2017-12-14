package communication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import enums.Actions;
import intefaces.IModel;
import intefaces.IPack;
import model.Model;
import util.Return;

public class Pack implements IPack {
	
	private Actions action;
	private IModel model;
	private Return a_return;
	private HashMap<String, Object> searchParamethers;
	private List<IModel> listModel;

	public Pack(Actions action, IModel model, Return returno){
		setAction(action);
		setModelObject(model);
		setReturn(returno);
	}
	
	public Pack(){
		
	}
	
	@Override
	public void setAction(Actions action) {
		this.action = action;

	}

	@Override
	public Actions getAction() {
		return action;
	}

	@Override
	public void setModelObject(IModel model) {
		this.model = model;

	}

	@Override
	public IModel getModelObject() {
		return model;
	}

	@Override
	public void setReturn(Return a_return) {
		this.a_return = a_return;

	}

	@Override
	public Return getReturn() {
		return a_return;
	}

	public List<IModel> getListModel() {
		return listModel;
	}

	public void setListModel(List<IModel> listModel) {
		this.listModel = listModel;
	}

	public HashMap<String, Object> getSearchParamethers() {
		return searchParamethers;
	}

	public void setSearchParamethers(HashMap<String, Object> searchParamethers) {
		this.searchParamethers = searchParamethers;
	}
	
	

}
