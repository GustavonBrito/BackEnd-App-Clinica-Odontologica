package com.dh.Checkpoint_I.repository.impl;

import com.dh.Checkpoint_I.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
