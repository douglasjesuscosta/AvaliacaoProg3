package composer;

import java.util.HashMap;

import org.zkoss.zhtml.Label;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import communication.Pack;
import enums.Actions;
import intefaces.IPack;
import model.User;
import util.Return;
import viewController.ViewController;

public class LoginController extends SelectorComposer<Component> {
	
	@Wire 
	Textbox account;
	@Wire
	Textbox password;
	@Wire
	Label message;
	@Wire
	Button login;

	@Listen("onClick=#login")
	public void doInit(){
		String nm = account.getValue();
	    String pd = password.getValue();
	    Return retorno = new Return();
	    HashMap<String, Object> hash = new HashMap<String, Object>();
	    
        IPack pack = new Pack(Actions.AUTENTIFY, new User(), retorno);
        
        hash.put("usuario", nm);
        hash.put("senha", pd);
        pack.setSearchParamethers(hash);
        pack = ViewController.executeAction(pack);
        retorno = pack.getReturn();
        
        if(retorno.getSucesso()){
        	Session sess = Sessions.getCurrent();
        	sess.setAttribute("Autentificado", "true");
        	Executions.sendRedirect("/index.zul");
        }else{
        	Clients.showNotification("Usuário ou senha incorretos", true); 
        	Executions.sendRedirect("/login.zul");
        }

	}
	
}
