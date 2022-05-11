package uo.ri.cws.application.business.invoice.create.commands;

import uo.ri.cws.application.business.util.DtoAssembler;
import uo.ri.cws.application.business.workorder.WorkOrderDto;
import uo.ri.cws.application.persistence.PersistenceException;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.invoice.InvoiceGateway;

public class FindWorkOrderByClientDni implements Command<WorkorderDto>{

    private String clientDni;

    public FindWorkOrderByClientDni(String clientDni){
        this.clientDni = clientDni;
    }

    @Override
    public WorkOrderDto execute(){
        InvoiceGateway ig = PersistenceFactory.forInvoice();
        return (DtoAssembler.toRecord());)
    }

    
}
