package uo.ri.cws.application.persistence.cashier;

import java.util.List;

import uo.ri.cws.application.business.workorder.WorkOrderDto;
import uo.ri.cws.application.persistence.Gateway;

/**
* WorkOrderGateway
*/
public interface WorkOrderGateway extends Gateway<WorkOrderDto>{

	List<WorkOrderRecord> findNotInvoicedWorkordersAction(); 
              
  
	/*
	* Metodo que devuelve el estado de un workorder 
	* @param id del workorder a comprobar
	*/
	boolean checkWorkOrderStatus(String id);

	int findWorkOrderAmmount();

	void linkWorkordersToInvoice();

	boolean	markWorkOrderAsInvoiced();

	void workOrdersBilling();

}	

