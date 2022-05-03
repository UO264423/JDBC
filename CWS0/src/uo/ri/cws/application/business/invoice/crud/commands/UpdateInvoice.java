package uo.ri.cws.application.business.invoice.crud.commands;


import uo.ri.cws.application.business.invoice.InvoiceDto;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.util.DtoAssembler;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.invoice.InvoiceGateway;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;

public class UpdateInvoice implements Command<Void> {
	
	InvoiceDto idto;

	
	public UpdateInvoice(InvoiceDto idto)  {
		this.idto=idto;
	}

	@Override
	public Void execute() {
		InvoiceGateway ig = PersistenceFactory.forInvoice();
		ig.update(DtoAssembler.toRecord(idto));
		return null;
	}
	
}
