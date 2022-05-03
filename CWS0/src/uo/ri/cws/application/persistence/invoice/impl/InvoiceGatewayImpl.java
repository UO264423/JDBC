package uo.ri.cws.application.persistence.invoice.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import uo.ri.cws.application.persistence.invoice.InvoiceGateway;
import uo.ri.cws.application.persistence.invoice.InvoiceRecord;

public class InvoiceGatewayImpl implements InvoiceGateway{


@Override
public void add(InvoiceRecord t) {
	// TODO Auto-generated method stub
	
}

@Override
public void remove(String id) {
	// TODO Auto-generated method stub
	
}

@Override
public void update(InvoiceRecord t) {
	// TODO Auto-generated method stub
	
}

@Override
public Optional<InvoiceRecord> findById(String id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<InvoiceRecord> findAll() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Optional<InvoiceRecord> findByNumber(Long number) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Long getNextInvoiceNumber() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}


}
