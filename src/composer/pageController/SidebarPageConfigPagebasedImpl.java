package composer.pageController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import services.SidebarPage;
import services.SidebarPageConfig;



public class SidebarPageConfigPagebasedImpl implements SidebarPageConfig{
	
	HashMap<String,SidebarPage> pageMap = new LinkedHashMap<String,SidebarPage>();
	public SidebarPageConfigPagebasedImpl(){		
		pageMap.put("Cadastrar",new SidebarPage("Cadastrar","Cadastrar","/imagens/addtext.png","/Textos/cadastrarViewModel.zul"));
		pageMap.put("Listar Todos",new SidebarPage("Listar","Listar todos","/imagens/textv.png","/Textos/list_textsViewModel.zul"));
		pageMap.put("Cadastrar Classificacao",new SidebarPage("Cadastrar Classificação","Cadastrar Classificação","/imagens/Classification.png","/classificacao/cadastrarClassificacao.zul"));
	}
	
	public List<SidebarPage> getPages(){
		return new ArrayList<SidebarPage>(pageMap.values());
	}
	
	public SidebarPage getPage(String name){
		return pageMap.get(name);
	}
}
	