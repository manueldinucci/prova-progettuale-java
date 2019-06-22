package prova.progettuale.oop.manueldinucci.service;

import java.util.List;

import prova.progettuale.oop.manueldinucci.domain.Ricetta;
import prova.progettuale.oop.manueldinucci.repository.RicettaRepository;

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
	public Ricetta cercaPerId(Long id) {
		return ricettaRepository.getOne(id);
	}

	@Override
	public List<Ricetta> ottieniList() {
	return;
	}
	
	@Override
	public List<Ricetta> findAll() {
		return ricettaRepository.findAll();
	}

}
