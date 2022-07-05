package br.com.Clinica_ManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Clinica_ManyToMany.models.Convenio;

@Repository
public interface ConvenioRepository  extends JpaRepository<Convenio, Long>{

}
