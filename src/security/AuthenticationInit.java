/* 
	Description:
		ZK Essentials
	History:
		Created by dennis

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package security;

import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Initiator;

import services.UserCredential;

public class AuthenticationInit implements Initiator {

	//services
	
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		
		Session sess = Sessions.getCurrent();
		String autent = (String) sess.getAttribute("Autentificado");
		if(autent == null){
			sess.setAttribute("Autentificado", "false");
            Executions.sendRedirect("/login.zul");
		}else{
			if(autent.equalsIgnoreCase("true")){
			}else{
				sess.setAttribute("Autentificado", "false");
				Executions.sendRedirect("/login.zul");
			}
		}
	}
}