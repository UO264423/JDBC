package uo.ri.cws.application.business.invoice.crud.commands;


import java.util.Optional;

import uo.ri.cws.application.business.invoice.InvoiceDto;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.util.DtoAssembler;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.invoice.InvoiceGateway;
import uo.ri.cws.application.persistence.invoice.InvoiceRecord;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;
import uo.ri.cws.application.persistence.mechanic.MechanicRecord;

public class FindInvoiceById implements Command<Optional<InvoiceDto>>{
	String idInvoice;

	public FindInvoiceById(String idInvoice) {
		this.idInvoice=idInvoice;
	}
	
	@Override
	public Optional<InvoiceDto> execute(){
		InvoiceGateway ig = PersistenceFactory.forInvoice();
		Optional<InvoiceRecord> ir = ig.findById(idInvoice);
		Optional<InvoiceDto> idto = DtoAssembler.toDto(ir.get());
		return idto;
	}


}
