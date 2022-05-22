package uo.ri.cws.application.persistence.invoice;
import uo.ri.cws.application.persistence.PersistenceException;
import java.util.List;
/**
* InvoicingWorkorderRecord
*/
public class InvoicingWorkOrderGateway {
	public List<InvoicingWorkOrderRecord> findWorkOrdersByClientDni(String dni)throws PersistenceException{
		return null;	

	}
	public List<InvoicingWorkOrderRecord> findNotInvoicedWorkOrdersByClientDni(String dni)throws PersistenceException{
		return null;
	}

	public List<InvoicingWorkOrderRecord> findWorkOrdersByPlateNumber(String plate)throws PersistenceException{
		return null;
	}


	
}
