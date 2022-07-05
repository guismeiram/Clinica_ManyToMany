package br.com.Clinica_ManyToMany.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Clinica_ManyToMany.exception.ClinicaNotFoundException;
import br.com.Clinica_ManyToMany.exception.ResourceNotFoundException;
import br.com.Clinica_ManyToMany.models.Paciente;
import br.com.Clinica_ManyToMany.repository.ConvenioRepository;
import br.com.Clinica_ManyToMany.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private ConvenioRepository convenioRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	public PacienteService(ConvenioRepository convenioRepository,PacienteRepository pacienteRepository) {
		this.convenioRepository = convenioRepository;
		this.pacienteRepository = pacienteRepository;
	}
	
	 public Paciente createPaciente(Paciente paciente) {
	    return pacienteRepository.save(paciente);
	 }
	  public Paciente getPacienteById(long id) throws ClinicaNotFoundException{
	        Optional<Paciente> result = pacienteRepository.findById(id);
	        if (result.isPresent()) {
	            return result.get();
	        }else{
	            throw new ResourceNotFoundException();
	        }
	    }

	    public void deletePaciente(long id)  throws ClinicaNotFoundException{
	        Paciente paciente = pacienteRepository.findById(id).
	        		orElseThrow(() -> new ResourceNotFoundException());

	        pacienteRepository.delete(paciente);
	    }
	    
	    public Paciente updateById(Paciente pacienteRequest,Long id) throws ClinicaNotFoundException{
	        pacienteRequest = pacienteRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException());

	        //consultorio
	        //consultaRequest.getConsultorio().forEach(c ->c.setNumero(c.getNumero()));
	        
	       
	       return pacienteRepository.save(pacienteRequest);
	     
	    }
}
