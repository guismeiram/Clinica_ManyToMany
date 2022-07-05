package br.com.Clinica_ManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Clinica_ManyToMany.models.Paciente;

@Repository

public interface PacienteRepository  extends JpaRepository<Paciente, Long>{

}
