package uo.ri.cws.application.ui.manager.action;



import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.mechanic.crud.AddMechanic;

public class AddMechanicAction implements Action {

	

	@Override
	public void execute() throws BusinessException {
		
		// Get info
		String dni = Console.readString("Dni"); 
		String name = Console.readString("Name"); 
		String surname = Console.readString("Surname");
		
		MechanicDto mdto = new MechanicDto();
		mdto.dni=dni;
		mdto.name=name;
		mdto.surname=surname;
		
		AddMechanic am= new AddMechanic(mdto);
		
		am.execute();
		
		// Print result
		Console.println("Mechanic added");
	}

}
