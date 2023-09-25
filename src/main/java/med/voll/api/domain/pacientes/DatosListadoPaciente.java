package med.voll.api.domain.pacientes;

public record DatosListadoPaciente(String nombre, String documentos, String email) {
    public DatosListadoPaciente(Paciente paciente) {
        this(paciente.getNombre(), paciente.getDocumento(), paciente.getEmail());
    }
}