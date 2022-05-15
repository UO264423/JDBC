package uo.ri.cws.application.persistence.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate; 
import java.sql.Date;

import uo.ri.cws.application.business.workorder.WorkOrderDto;
import uo.ri.cws.application.persistence.invoice.InvoiceRecord;
import uo.ri.cws.application.persistence.mechanic.MechanicRecord;
import uo.ri.cws.application.persistence.workorder.WorkOrderRecord;


public class RecordAssembler {

	public static Optional<MechanicRecord> toMechanicRecord(ResultSet m) throws SQLException {
		if (m.next()) {
			return Optional.of(resultSetToMechanicRecord(m));
		}
		else 	
			return Optional.ofNullable(null);
	}
	

	public static List<MechanicRecord> toMechanicRecordList(ResultSet rs) throws SQLException {
		List<MechanicRecord> res = new ArrayList<>();
		while(rs.next()) {
			res.add( resultSetToMechanicRecord(rs));
		}

		return res;
	}

	private static MechanicRecord resultSetToMechanicRecord(ResultSet rs) throws SQLException {
		MechanicRecord value = new MechanicRecord();
		value.id = rs.getString("id");

		value.dni = rs.getString("dni");
		value.name = rs.getString("name");
		value.surname = rs.getString("surname");
		return value;
	}

	public static List<InvoiceRecord> toInvoiceRecordList(ResultSet rs) throws SQLException {
		List<InvoiceRecord> res = new ArrayList<>();
		while(rs.next()) {
			res.add( resultSetToInvoiceRecord(rs));
		}

		return res;
	}




	public static Optional<InvoiceRecord> toInvoiceRecord(ResultSet m) throws SQLException {
		if (m.next()) {
			return Optional.of(resultSetToInvoiceRecord(m));
		}
		else 	
			return Optional.ofNullable(null);
	}


	private static InvoiceRecord resultSetToInvoiceRecord(ResultSet rs) throws SQLException {
		InvoiceRecord value = new InvoiceRecord();
		value.id = rs.getString("id");

		value.total = Double.parseDouble(rs.getString("total"));
		value.vat = Double.parseDouble(rs.getString("vat"));
		value.number = Long.parseLong(rs.getString("number"));
		value.date =  LocalDate.parse(rs.getString("number"));
		value.status = rs.getString("status");

		return value;
	}


	
		
	public static Optional<WorkOrderRecord> toWorkOrderRecord ( ResultSet rs ) throws SQLException {
		WorkOrderRecord record = null;
		

		if (rs.next()) {
			record = resultSetToWorkOrderRecord(rs);
			}
		return Optional.ofNullable(record);
		
	}

	public static List<WorkOrderRecord> toWorkOrderRecordList(ResultSet rs) throws SQLException {
		List<WorkOrderRecord> res = new ArrayList<>();
		while(rs.next()) {
			res.add( resultSetToWorkOrderRecord(rs)	);
		}
		
		return res;
	}
	
	
	private static WorkOrderRecord resultSetToWorkOrderRecord ( ResultSet rs ) throws SQLException {
		WorkOrderRecord record = new WorkOrderRecord();
		
		record.id = rs.getString("id");
		record.version = rs.getLong("version");

		record.vehicleId = rs.getString( "vehicle_Id");
		record.description = rs.getString( "description");
		Date sqlDate = rs.getDate( "date");
		record.date =  sqlDate.toLocalDate(); 
		record.total = rs.getDouble("amount");
		record.status = rs.getString( "status");
		record.mechanicId = rs.getString( "mechanic_Id");
		record.invoiceId = rs.getString( "invoice_Id");
		record.usedForVoucher = rs.getBoolean("usedForVoucher");
		
		return record;		
	}

	private static WorkOrderDto resultSetToWorkOrderDto ( ResultSet rs ) throws SQLException {
		WorkOrderDto record = new WorkOrderDto();
		
		record.id = rs.getString("id");
		record.version = rs.getLong("version");

		record.vehicleId = rs.getString( "vehicle_Id");
		record.description = rs.getString( "description");
		Date sqlDate = rs.getDate( "date");
		record.date =  sqlDate.toLocalDate(); 
		record.total = rs.getDouble("amount");
		record.status = rs.getString( "status");
		record.mechanicId = rs.getString( "mechanic_Id");
		record.invoiceId = rs.getString( "invoice_Id");
		record.usedForVoucher = rs.getBoolean("usedForVoucher");	
		return record;		
	}
}
