package br.com.Clinica_ManyToMany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Convenio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nCarteirininha;//numero carteirninha
	private String nConvenio;//nome convenio
	private Boolean pConvenio;//possui convenio
	
}
