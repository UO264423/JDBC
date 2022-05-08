package uo.ri.cws.application.persistence.cashier;

import java.util.List;

import uo.ri.cws.application.business.workorder.WorkOrderDto;
import uo.ri.cws.application.persistence.Gateway;

/**
* WorkOrderGateway
*/
public interface WorkOrderGateway extends Gateway<WorkOrderDto>{

	List<WorkOrderRecord> findNotInvoicedWorkordersAction(){
		
	}
	
	workOrdersBilling

}	

