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

public class MechanicCrudServiceImpl implements MechanicCrudService {

	@Override
	public MechanicDto addMechanic(MechanicDto mechanic) throws BusinessException {
		return new AddMechanic(mechanic).execute();
	}

	@Override
	public void deleteMechanic(String idMechanic) throws BusinessException {
		 new DeleteMechanic(idMechanic).execute();;
		
	}

	@Override
	public void updateMechanic(MechanicDto mechanic) throws BusinessException {
		new UpdateMechanic(mechanic);
		
	}

	@Override
	public Optional<MechanicDto> findMechanicById(String idMechanic) throws BusinessException {
		return new FindMechanicById(idMechanic).execute();
	}

	@Override
	public Optional<MechanicDto> findMechanicByDni(String dniMechanic) throws BusinessException {
		return new FindMechanicByDni(dniMechanic).execute();
	}

	@Override
	public List<MechanicDto> findAllMechanics() throws BusinessException {
		return new FindAllMechanics().execute();
	}

}
