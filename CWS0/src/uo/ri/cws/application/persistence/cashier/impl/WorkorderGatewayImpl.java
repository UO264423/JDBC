package uo.ri.cws.application.persistence.cashier.impl;

import uo.ri.cws.application.persistence.cashier.WorkOrderGateway;
import uo.ri.cws.application.persistence.cashier.WorkOrderRecord;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import alb.util.jdbc.Jdbc;
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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
	}
	
	@Override
	public int findWorkOrderAmmount(){

	} 

	@Override
    public boolean	markWorkOrderAsInvoiced(){

	}

	@Override
	public void workOrdersBilling(){

	}





	
}
