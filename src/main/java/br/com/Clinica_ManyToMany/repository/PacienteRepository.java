package br.com.Clinica_ManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Clinica_ManyToMany.models.Paciente;

public interface PacienteRepository  extends JpaRepository<Paciente, Long>{

}
