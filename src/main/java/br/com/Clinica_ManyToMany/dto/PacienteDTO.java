package br.com.Clinica_ManyToMany.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.Clinica_ManyToMany.models.Convenio;

public class PacienteDTO {
	private Long id;
    private String nome;
    private String idade;
    private Set<Convenio> convenio = new HashSet<>();
}
