package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.pacientes.PacienteRepository;
import med.voll.api.domain.pacientes.DatosRegistroPaciente;
import med.voll.api.domain.pacientes.Paciente;
import med.voll.api.domain.pacientes.DatosListadoPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepostory;

    @PostMapping
    public void registrarPaciente(@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente) {

        pacienteRepostory.save(new Paciente(datosRegistroPaciente));
    }
    @GetMapping
    public Page<DatosListadoPaciente> listadoPacientes(@PageableDefault(size = 2) Pageable paginacion) {
        return pacienteRepostory.findAll(paginacion).map(DatosListadoPaciente::new);
    }


}