package uo.ri.cws.application.persistence.workorder;

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
	String checkWorkOrderStatus(String id);

	int findWorkOrderAmmount(String workorderId);

	void linkWorkordersToInvoice(String invoiceId,String workorderId);

	void markWorkOrderAsInvoiced(String workorderId);


}	

