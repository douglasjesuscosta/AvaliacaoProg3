package intefaces;

import java.util.HashMap;
import java.util.List;

import enums.Actions;
import model.Model;
import util.Return;

public interface IPack {
	
	public void setAction(Actions action);
	public Actions getAction();
	
	public void setModelObject(IModel model);
	public IModel getModelObject();
	
	public void setReturn(Return a_return);
	public Return getReturn();
	
	public void setListModel(List<IModel> listModel);
	public List<IModel> getListModel();
	
	public void setSearchParamethers(HashMap<String, Object> searchParamethers);
	public HashMap<String, Object> getSearchParamethers();
		
}
