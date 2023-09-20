package programming.serialization.Exercise3;

import java.io.Serializable;

class Usuario implements Serializable {
    private String cedula;
    private String tipoAtencion;

    public Usuario(String cedula, String tipoAtencion) {
        this.cedula = cedula;
        this.tipoAtencion = tipoAtencion;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTipoAtencion() {
        return tipoAtencion;
    }
}

