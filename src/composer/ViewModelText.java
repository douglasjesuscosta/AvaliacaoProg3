package composer;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import communication.Pack;
import controller.CrudController;
import controller.ManterClassificacao;
import controller.ManterTexto;
import enums.Actions;
import intefaces.IModel;
import intefaces.IPack;
import model.Classification;
import model.Model;
import model.Texts;
import util.Return;
import validators.GenericValidator;
import viewController.ViewController;

public class ViewModelText extends GenericComposer{
	private ListModelList<IModel> listClassifications;
	
	public ViewModelText() {
		
	}
	
	@Init
	public void initVariablesExibition() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		super.setModel(new Texts());
		listClassifications = new ListModelList<IModel>(super.selet(new Classification()));
	}
	
	@Command
	public void save(){
		super.save();
	}
	

	public ListModelList<IModel> getListClassifications() {
		return listClassifications;
	}

	public void setListClassifications(ListModelList<IModel> listClassifications) {
		this.listClassifications = listClassifications;
	}
}
