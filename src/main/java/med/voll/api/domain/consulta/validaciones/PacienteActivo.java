package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.pacientes.PacienteRepository;

public class PacienteActivo {

    private PacienteRepository repository;

    public void validar(DatosAgendarConsulta datos){

        if(datos.idPaciente()==null){
            return;
        }

        var pacienteActivo = repository.findActivoById(datos.idPaciente());

        if(!pacienteActivo){
            throw new ValidationException("No se permite agendar citas a pacientes inactivos");
        }
    }
}
