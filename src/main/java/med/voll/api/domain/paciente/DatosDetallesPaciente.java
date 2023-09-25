package med.voll.api.domain.paciente;


import med.voll.api.domain.direccion.Direccion;
import med.voll.api.domain.pacientes.Paciente;

public record DatosDetallesPaciente(Long id, String nombre, String email, String documento, String telefono, Direccion direccion) {

    public DatosDetallesPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumento(), paciente.getTelefono(), paciente.getDireccion());
    }
}
