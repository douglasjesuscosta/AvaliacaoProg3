package composer;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.util.Clients;

import communication.Pack;
import controller.ManterClassificacao;
import controller.ManterTexto;
import enums.Actions;
import model.Classification;
import util.Return;

public class ViewModelClassification extends GenericComposer{
	
	@Init
	public void init(){
		model = new Classification();
		super.init();
	}
		
}
