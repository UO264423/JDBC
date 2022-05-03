package uo.ri.cws.application.business.mechanic.crud;

import java.util.List;
import java.util.Optional;

import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.mechanic.MechanicCrudService;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.mechanic.crud.commands.AddMechanic;
import uo.ri.cws.application.business.mechanic.crud.commands.DeleteMechanic;
import uo.ri.cws.application.business.mechanic.crud.commands.FindAllMechanics;
import uo.ri.cws.application.business.mechanic.crud.commands.FindMechanicByDni;
import uo.ri.cws.application.business.mechanic.crud.commands.FindMechanicById;
import uo.ri.cws.application.business.mechanic.crud.commands.UpdateMechanic;
import uo.ri.cws.application.business.util.command.CommandExecutor;
import uo.ri.cws.application.persistence.PersistenceException;

public class MechanicCrudServiceImpl implements MechanicCrudService {
	
	private CommandExecutor executor = new CommandExecutor();

	@Override
	public MechanicDto addMechanic(MechanicDto mechanic) throws BusinessException, PersistenceException {
		AddMechanic am = new AddMechanic(mechanic);
		return executor.execute(am);
	}

	@Override
	public void deleteMechanic(String idMechanic) throws BusinessException, PersistenceException {
		DeleteMechanic dm = new DeleteMechanic(idMechanic);
		executor.execute(dm);
		
	}

	@Override
	public void updateMechanic(MechanicDto mechanic) throws BusinessException, PersistenceException {
		UpdateMechanic um = new UpdateMechanic(mechanic); 
		executor.execute(um);
		
	}

	@Override
	public Optional<MechanicDto> findMechanicById(String idMechanic) throws BusinessException, PersistenceException {
		return new FindMechanicById(idMechanic).execute();
	}

	@Override
	public Optional<MechanicDto> findMechanicByDni(String dniMechanic) throws BusinessException, PersistenceException {
		return new FindMechanicByDni(dniMechanic).execute();
	}

	@Override
	public List<MechanicDto> findAllMechanics() throws BusinessException {
		return new FindAllMechanics().execute();
	}

}
