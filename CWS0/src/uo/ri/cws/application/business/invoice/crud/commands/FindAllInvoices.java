package uo.ri.cws.application.business.invoice.crud.commands;

import java.util.List;

import uo.ri.cws.application.business.invoice.InvoiceDto;
import uo.ri.cws.application.business.util.DtoAssembler;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.invoice.InvoiceGateway;
import uo.ri.cws.application.persistence.invoice.InvoiceRecord;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;
import uo.ri.cws.application.persistence.mechanic.MechanicRecord;

public class FindAllInvoices implements Command<List<InvoiceDto>>{
	

	public FindAllInvoices() {

	}
	
	@Override
	public List<InvoiceDto> execute(){
		InvoiceGateway ig = PersistenceFactory.forInvoice();

		List<InvoiceRecord> invoiceRecords = ig.findAll();
		
		return DtoAssembler.toDtoListInvoice(invoiceRecords);		
		
	}
	
}
