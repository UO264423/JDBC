package uo.ri.cws.application.persistence.invoice;

import java.sql.SQLException;
import java.util.Optional;
import java.util.List;

import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.persistence.Gateway;

public interface InvoiceGateway extends Gateway<InvoiceRecord> {

	/**
	 * @param invoice's number 
	 * @return invoice dto or null if it does not exist
	 */
	Optional<InvoiceRecord> findByNumber(Long number);
	
	/**
	 * @return next invoice number to assign; that is, one greater than the 
	 * 			greatest number already assigned to an invoice + 1 
	 * 
	 * Notice that, in a real deployment, this way to get a new invoice number 
	 * may produce incorrect values in a concurrent environment because two
	 * concurrent threads could get the same number.
	 * @throws SQLException 
	 *  
	 */
	Long getNextInvoiceNumber() throws SQLException;

	

	/**
	 * Create a new invoice billing the workorders in the argument
	 * The new invoice will be in NOT_YET_PAID status, the workorders will be marked
	 * as INVOICED
	 * @param the list of workorder ids to bill
	 * @throws BusinessException if
	 * 	- the status of any of the workorders is not FINISHED 
	 *  - any of the workorders does not exist
	 * @throws IllegalArgumentException if list is null, empty or any of the strings in the
	 *  		list is empty or null
	 */
	InvoiceRecord createInvoiceFor(List<String> workOrderIds)
			throws BusinessException;

	/**
	 * Returns a list with info of all the work orders of all the client's vehicles
	 * @param dni of the client
	 * @return a list of InvoicingWorkOrderDto or empty list if there is none
	 * @throws BusinessException DOES NOT
	 */
	List<InvoicingWorkOrderRecord> findWorkOrdersByClientDni(String dni)
			throws BusinessException;
	
	/**
	 * Find FINISHED BUT NOT INVOICED workorders due to a client with certain dni.
	 * @param the dni 
	 * @throws BusinessException if
	 * 	- client with this dni does not exist
	 *         IllegalArgumentException if dni is empty 
	 */
	List<InvoicingWorkOrderRecord> findNotInvoicedWorkOrdersByClientDni(String dni)
			throws BusinessException;

	/**
	 * Returns a list with info of all the work orders of a vehicle
	 * @param plate, the plate number of the vehicle
	 * @return a list of InvoicingWorkOrderDto or empty list if there is none
	 * @throws BusinessException DOES NOT
	 */
	List<InvoicingWorkOrderRecord> findWorkOrdersByPlateNumber(String plate)
			throws BusinessException;

	/**
	 * @param number, of the invoice
	 * @return the InvoiceDto with the data of the invoice
	 * @throws BusinessException DOES NOT
	 */
	Optional<InvoiceRecord> findInvoiceByNumber(Long number) throws BusinessException;

	/**
	 * @param dni of the client
	 * @return the list of the PaymentMeanDto of a client represented by the dni
	 * 		or an empty list if none
	 * @throws BusinessException DOES NOT
	 */
	List<PaymentMeanForInvoicingRecord> findPayMeansByClientDni(String dni)
			throws BusinessException;

	/**
	 * Creates the charges against the indicated payment means (with the amount
	 * indicated) and then pass the invoice to the PAID status.
	 *
	 * @param invoiceId, the id of the invoice to be paid
	 * @param charges, a List of ChargeDto
	 * 	whose:
	 * 	- Key (String) represents the payment mean id, and
	 * 	- Value (Double) represents the amount to be charged to the payment mean
	 * @throws IllegalArgumentException if
	 *  	- invoiceId is null or empty
	 *  	- charges is null
	 * @throws BusinessException if
	 * 	- there is no invoice for the invoiceId provided
	 *  - the indicated invoice is already in PAID status
	 * 	- does not exist any of the payment means indicated by the id
	 *  - the addition of all amounts charged to each payment mean does not
	 *  	equals the amount of the invoice with a precision of two cents
	 *  	( Math.abs( total - amount) <= 0.01 )
	 * 	- any of the payment means cannot be used to pay the specified amount:
	 * 		- For a CreditCard, if the current date is after the validThough date
	 * 		- For a Voucher, if it has not enough available for the amount
	 * 		- For Cash there is no constraint, cash can be used always
	 *
	 * Note (JUST FOR JPA IMPLEMENTATION):
	 * 		the domain model does not have the proper design to do it
	 * 		polymorphically,
	 *
	 * 		THUS
	 *
	 * 		add a
	 * 			public abstract boolean canPay( amount );
	 * 		method to PaymentMean class and the proper specialization on the
	 * 		child classes
	 */
	void settleInvoice(String invoiceId, List<ChargeRecord> charges)
			throws BusinessException;
	




}
