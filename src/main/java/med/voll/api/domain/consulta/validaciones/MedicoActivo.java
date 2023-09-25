package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;


public class MedicoActivo implements ValidadorDeConsultas{

    private MedicoRepository repository;

    public void validar(DatosAgendarConsulta datos){

        if(datos.idPaciente()==null){
            return;
        }

        var medicoActivo = repository.findActivoById(datos.idMedico());

        if(!medicoActivo){
            throw new ValidationException("No se permite agendar citas a pacientes inactivos");
        }
    }
}








