package uo.ri.cws.application.business.workorder.action;
import uo.ri.cws.application.business.workorder.WorkOrderDto;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.business.util.command.Command;
import java.util.Optional;
/**
* WorkOrderBilling
*/
public class Optional<WorkOrderBilling> implements Command<Optional<WorkOrderDto>> {

	private String workorderId;

	public WorkOrderBilling(String workorderId) {
		this.workorderId = workorderId;
	}



	@Override
	public Optional<WorkOrderDto> execute(){
		PersistenceFactory ps = PersistenceFactory.forMechanic();	

	}
}
