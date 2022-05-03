package uo.ri.cws.application.business.invoice.crud.commands;


import uo.ri.cws.application.business.invoice.InvoiceDto;
import uo.ri.cws.application.business.util.DtoAssembler;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.invoice.InvoiceGateway;

public class AddInvoice implements Command<InvoiceDto> {

	InvoiceDto idto;

	public AddInvoice(InvoiceDto idto) {
		this.idto = idto;
	}

	@Override
	public InvoiceDto execute() {
		InvoiceGateway ig = PersistenceFactory.forInvoice();
		ig.add(DtoAssembler.toRecord(idto));
		return idto;
	}
}
