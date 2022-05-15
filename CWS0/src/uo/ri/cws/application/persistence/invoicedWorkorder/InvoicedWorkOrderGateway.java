package uo.ri.cws.application.persistence;

import java.util.List;
import 
/**
* InvoicedWorkOrderGateway
*/
public class InvoicedWorkOrderGateway {
	public List<InvoicingWorkOrderRecord> findWorkOrdersByClientDni(String dni)throws PersistenceException{
		

	}
	public List<InvoicingWorkOrderRecord> findNotInvoicedWorkOrdersByClientDni(String dni)throws PersistenceException{
		return null;
	}

	public List<InvoicingWorkOrderRecord> findWorkOrdersByPlateNumber(String plate)throws PersistenceException{
		return null;
	}


	
}
