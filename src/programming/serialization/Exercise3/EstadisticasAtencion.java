package programming.serialization.Exercise3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstadisticasAtencion implements Serializable {
    private List<Usuario> usuariosAtendidos;
    private Map<String, Integer> usuariosPorTipo;

    public EstadisticasAtencion() {
        usuariosAtendidos = new ArrayList<>();
        usuariosPorTipo = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuariosAtendidos.add(usuario);
        actualizarEstadisticas(usuario.getTipoAtencion());
    }

    public int getCantidadUsuariosAtendidos() {
        return usuariosAtendidos.size();
    }

    public int getCantidadUsuariosPorTipo(String tipo) {
        return usuariosPorTipo.getOrDefault(tipo, 0);
    }

    private void actualizarEstadisticas(String tipoAtencion) {
        usuariosPorTipo.put(tipoAtencion, usuariosPorTipo.getOrDefault(tipoAtencion, 0) + 1);
    }
}

