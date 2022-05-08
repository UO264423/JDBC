package uo.ri.cws.application.persistence.invoice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.persistence.invoice.InvoiceGateway;
import uo.ri.cws.application.persistence.invoice.InvoiceRecord;
import uo.ri.cws.application.persistence.util.Conf;
import uo.ri.cws.application.persistence.util.RecordAssembler;

public class InvoiceGatewayImpl implements InvoiceGateway {

	private String SQL = "";
	// Process
	private Connection c = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private Conf conf = new Conf();

	@Override
	public void add(InvoiceRecord t) {
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("INVOICE_ADD");
			pst = c.prepareStatement(SQL);
			pst.setString(1, t.id);
			pst.setString(2, "" + t.total);
			pst.setString(3, "" + t.vat);
			pst.setString(4, "" + t.number);
			pst.setString(5, "" + t.date);
			pst.setString(6, t.status);
			pst.setString(7, "" + t.usedForVoucher);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}

	}

	@Override
	public void remove(String id) {
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("INVOICE_REMOVE");
			pst = c.prepareStatement(SQL);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
	}

	@Override
	public void update(InvoiceRecord t) {
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("INVOICE_UPDATE");
			pst = c.prepareStatement(SQL);
			pst.setString(1, t.id);
			pst.setString(2, "" + t.total);
			pst.setString(3, "" + t.vat);
			pst.setString(4, "" + t.number);
			pst.setString(5, "" + t.date);
			pst.setString(6, "" + t.status);
			pst.setString(7, "" + t.usedForVoucher);
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}

	}

	@Override
	public Optional<InvoiceRecord> findById(String id) {
		Optional<InvoiceRecord> invoice = Optional.ofNullable(new InvoiceRecord());
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("INVOICE_FIND_BY_ID");
			pst = c.prepareStatement(SQL);
			pst.setString(1, id);
			rs = pst.executeQuery();

			invoice = RecordAssembler.toInvoiceRecord(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return invoice;
	}

	@Override
	public Optional<InvoiceRecord> findByNumber(Long number) {
		Optional<InvoiceRecord> invoice = Optional.ofNullable(new InvoiceRecord());
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("INVOICE_FIND_BY_NUM ");
			pst = c.prepareStatement(SQL);
			pst.setString(1, "" + number);
			rs = pst.executeQuery();

			invoice = RecordAssembler.toInvoiceRecord(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return invoice;
	}

	@Override
	public Long getNextInvoiceNumber() throws SQLException {
		Long number = 1;
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("INVOICE_GET_NEXT_INVOICE_NUMBER");
			pst = c.prepareStatement(SQL);
			rs = pst.executeQuery();
			number += (int) (rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return number;

		return null;
	}

	@Override
	public List<InvoiceRecord> findAll() {
		List<InvoiceRecord> invoices = new ArrayList<InvoiceRecord>();
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("INVOICE_FIND_ALL");
			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();

			invoices = RecordAssembler.toInvoiceRecordList(rs);
			return invoices;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return invoices;

	}

	@Override
	public InvoiceRecord createInvoiceFor(List<String> workOrderIds)
			throws BusinessException;

	@Override
	public List<InvoicingWorkOrderRecord> findWorkOrdersByClientDni(String dni)
			throws BusinessException;

	@Override
	public List<InvoicingWorkOrderRecord> findNotInvoicedWorkOrdersByClientDni(String dni)
			throws BusinessException;

	@Override
	public List<InvoicingWorkOrderRecord> findWorkOrdersByPlateNumber(String plate)
			throws BusinessException;

	@Override
	public Optional<InvoiceRecord> findInvoiceByNumber(Long number) throws BusinessException;

	@Override
	public List<PaymentMeanForInvoicingRecord> findPayMeansByClientDni(String dni)
			throws BusinessException;

	@Override
	public void settleInvoice(String invoiceId, List<ChargeRecord> charges)
			throws BusinessException;

}
