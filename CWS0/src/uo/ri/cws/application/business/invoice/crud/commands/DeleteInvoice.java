package uo.ri.cws.application.business.invoice.crud.commands;

import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.invoice.InvoiceGateway;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;

public class DeleteInvoice implements Command<Void>  {
	
	
	String idInvoice;

	public void DeleteMechanic(String idInvoice) {
		this.idInvoice=idInvoice;
	}


	@Override
	public Void execute() throws BusinessException {
		InvoiceGateway ig = PersistenceFactory.forInvoice();
		ig.remove(idInvoice);
		return null;
	}
}
