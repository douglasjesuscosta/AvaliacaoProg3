package viewController;

import javax.management.RuntimeErrorException;

import annotation.Table;
import intefaces.IConnection;
import intefaces.IController;
import intefaces.ICrudController;
import intefaces.IModel;
import intefaces.IPack;

public class ViewController {
	
	public static IPack executeAction(IPack pack){
		
		IModel model = pack.getModelObject();
		Class<?> metaClass = model.getClass();
		Table t = metaClass.getAnnotation(Table.class);
		String controller = "controller." + t.useCase();
		
		try {
			System.out.println(controller);
			ICrudController icontrol = (ICrudController) Class.forName(controller).newInstance();
			pack = icontrol.executeAction(pack);
			
		} catch (Exception e){
			throw new RuntimeException("Failed to find controller: " + controller + e.getMessage());
		}
		return pack;
	}
}
