package br.com.Clinica_ManyToMany.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Clinica_ManyToMany.exception.ClinicaNotFoundException;
import br.com.Clinica_ManyToMany.exception.ResourceNotFoundException;
import br.com.Clinica_ManyToMany.models.Convenio;
import br.com.Clinica_ManyToMany.repository.ConvenioRepository;
import br.com.Clinica_ManyToMany.repository.PacienteRepository;

@Service
public class ConvenioService {
	
	@Autowired
	private ConvenioRepository convenioRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	public ConvenioService(ConvenioRepository convenioRepository,PacienteRepository pacienteRepository) {
		this.convenioRepository = convenioRepository;
		this.pacienteRepository = pacienteRepository;
	}
	
	 public Convenio createConvenio(Convenio convenio) {

	        return convenioRepository.save(convenio);

	    }
	  public Convenio getConsultaById(long id) throws ClinicaNotFoundException{
	        Optional<Convenio> result = convenioRepository.findById(id);
	        if (result.isPresent()) {
	            return result.get();
	        }else{
	            throw new ResourceNotFoundException();
	        }
	    }

	    public void deleteConvenio(long id)  throws ClinicaNotFoundException{
	        Convenio convenio = convenioRepository.findById(id).
	        		orElseThrow(() -> new ResourceNotFoundException());

	        convenioRepository.delete(convenio);
	    }
	    
	    public Convenio updateById(Convenio convenioRequest,Long id) throws ClinicaNotFoundException{
	        convenioRequest = convenioRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException());

	        //consultorio
	        //consultaRequest.getConsultorio().forEach(c ->c.setNumero(c.getNumero()));
	     
	       
	       return convenioRepository.save(convenioRequest);
	     
	    }

}
