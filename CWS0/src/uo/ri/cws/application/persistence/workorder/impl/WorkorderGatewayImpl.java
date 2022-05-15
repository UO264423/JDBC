package uo.ri.cws.application.persistence.workorder.impl;

import uo.ri.cws.application.persistence.workorder.WorkOrderGateway;
import uo.ri.cws.application.persistence.workorder.WorkOrderRecord;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.business.workorder.WorkOrderDto;
import uo.ri.cws.application.persistence.PersistenceException;
import uo.ri.cws.application.persistence.util.Conf;
import uo.ri.cws.application.persistence.util.RecordAssembler;




/**
* WorkorderGatewayImpl
*/
public class WorkorderGatewayImpl implements WorkOrderGateway{


	private String SQL = "";
	// Process
	private Connection c = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private Conf conf = new Conf();


	@Override
	public List<WorkOrderRecord> findNotInvoicedWorkordersAction(){
		List<WorkOrderRecord> workorders = new ArrayList<WorkOrderRecord>();
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("WORKODER_FIND_NOT_INVOICED");
			pst = c.prepareStatement(SQL);
 			rs = pst.executeQuery();
			workorders = RecordAssembler.toWorkOrderRecordList(rs);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return workorders; 
	}

	@Override
	public String checkWorkOrderStatus(String workorderid){
		String workorderStatus = null;
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("WORKORDER_CHECK_STATUS");
			pst = c.prepareStatement(SQL);
			pst.setString(1, workorderid);
			rs = pst.executeQuery();

			workorderStatus = rs.getString("Status");
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return workorderStatus;
	}

	@Override
	public void linkWorkordersToInvoice(String invoiceId,String workorderId){
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("WORKORDER_CHECK_STATUS");
			pst = c.prepareStatement(SQL);
			pst.setString(1, invoiceId);
			pst.setString(2, workorderId);
			pst.executeUpdate();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
	}
	
	@Override
	public int findWorkOrderAmmount(String workorderId){
		int total=-1;
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("WORKORDER_FIND_AMMOUNT");
			pst = c.prepareStatement(SQL);
			pst.setString(1, workorderId);
			rs = pst.executeQuery();
			total = rs.getInt(total);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return total;
	}

	@Override
    public void	markWorkOrderAsInvoiced(String workorderId){
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("WORKORDER_MARK_AS_INVOICED");
			pst = c.prepareStatement(SQL);
			pst.setString(1, workorderId);
			pst.executeUpdate();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
	}

	@Override
	public void add(WorkOrderDto t) {

	}

	@Override
	public void remove(String id) {
}

	@Override
	public void update(WorkOrderDto t) {

	}

	@Override
 	public Optional<WorkOrderDto> findById(String id) {
	Optional<WorkOrderDto> workorder = Optional.ofNullable(new WorkOrderDto());
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("WORKODER_FIND_BY_ID");
			pst = c.prepareStatement(SQL);
			pst.setString(1, id);
			rs = pst.executeQuery();

			workorder = RecordAssembler.toWorkOrderDto(rs);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return workorder;
	}
	

	@Override
	public List<WorkOrderDto> findAll() {
	return null;	
	}
}
