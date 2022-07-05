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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    
    @ManyToMany(fetch = FetchType.LAZY,
    	      cascade = {
    	          CascadeType.PERSIST,
    	          CascadeType.MERGE
    	      })
    	  @JoinTable(name = "convenio_paciente",
    	        joinColumns = { @JoinColumn(name = "convenio_id") },
    	        inverseJoinColumns = { @JoinColumn(name = "paciente_id") })
    	  private Set<Convenio> convenio = new HashSet<>();

	public Long getAllId(){
		return (id.equals(0) ? null:id);
	}
}
