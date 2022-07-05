package br.com.Clinica_ManyToMany.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.Clinica_ManyToMany.models.Paciente;

public class ConvenioDTO {
	private Long id;
	private String nCarteirininha;//numero carteirninha
	private String nConvenio;//nome convenio
	private Boolean pConvenio;//possui convenio
	private Set<Paciente> paciente = new HashSet<>();
	
}
