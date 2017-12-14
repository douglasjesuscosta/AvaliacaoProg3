package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DAO.DaoTexto;
import DAO.GenericDao;
import intefaces.IModel;
import model.Classification;
import model.Model;
import model.Texts;

public class ManterTexto extends CrudController{

	public List<Texts> listAllModel(){
		List<IModel> lista;
		ArrayList<Texts> listaTextos = new ArrayList<Texts>();
		try {
			lista = super.listAll();
			
			for(int i =0; i < lista.size(); i++){
				listaTextos.add((Texts) lista.get(i));
			}
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaTextos;
	}

	@Override
	public Model getTableObject() {
		// TODO Auto-generated method stub
		return new Texts();
	}
}
