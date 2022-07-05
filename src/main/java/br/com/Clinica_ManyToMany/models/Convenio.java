package br.com.Clinica_ManyToMany.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TB_CONVENIO")
public class Convenio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nCarteirininha;//numero carteirninha
	private String nConvenio;//nome convenio
	private Boolean pConvenio;//possui convenio
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "convenio")
		  @JsonIgnore
	private Set<Paciente> paciente = new HashSet<>();
	

	public Long getAllId(){
		return (id.equals(0) ? null:id);
	}
}
