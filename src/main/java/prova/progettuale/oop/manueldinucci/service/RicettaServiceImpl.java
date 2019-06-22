package prova.progettuale.oop.manueldinucci.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import prova.progettuale.oop.manueldinucci.domain.ArrListRicetta;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;
import prova.progettuale.oop.manueldinucci.repository.RicettaRepository;
@Service
public class RicettaServiceImpl implements RicettaService { 
	//STATISTICHE IMPL QUI
	//PASSO IL FILE QUI
	private final RicettaRepository ricettaRepository;
	
	/**
	 * @param ricettaRepository
	 */
	public RicettaServiceImpl(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	@Override
	public ArrListRicetta cercaPerId(Long id) {
		return ricettaRepository.getOne(id);
	}
	
	@Override
	public List<ArrListRicetta> findAll() {
		return ricettaRepository.findAll();
	}

}
