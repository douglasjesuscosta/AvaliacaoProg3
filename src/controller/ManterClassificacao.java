package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import intefaces.IModel;
import model.Classification;
import model.Model;

public class ManterClassificacao extends CrudController{

	@Override
	public Model getTableObject() {
		return new Classification();
	}
	
	public static ManterClassificacao getInstance(){
		return new ManterClassificacao();
	}

	@Override
	public List<Classification> listAllModel() {
		ArrayList<Classification> listaClassificaco = new ArrayList<Classification>();
		List<IModel> lista;
		try {
			lista = super.listAll();
			
			for(int i =0; i < lista.size(); i++){
				listaClassificaco.add((Classification) lista.get(i));
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return listaClassificaco;
	}

}
