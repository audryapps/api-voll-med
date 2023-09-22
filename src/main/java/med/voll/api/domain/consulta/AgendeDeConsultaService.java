package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.pacientes.Paciente;
import med.voll.api.domain.pacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendeDeConsultaService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    public void agendar(DatosAgendarConsulta datos){

        var paciente = pacienteRepository.findById(datos.idPaciente()).get();

        var medico = medicoRepository.findById(datos.idMedico()).get();

        var consulta = new Consulta(null, medico,paciente,datos.fecha());

        consultaRepository.save(consulta);
    }
}