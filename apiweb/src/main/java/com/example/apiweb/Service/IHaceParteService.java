package com.example.apiweb.Service;

import java.util.List;

import com.example.apiweb.Model.HaceParteModel;

public interface IHaceParteService {
    String agregarParticipacion(HaceParteModel participacion);
    HaceParteModel buscarParticipacionPorId(int idHaceParte);
    List<HaceParteModel>listarParticipaciones();
    String eliminarParticipacionesPorId(int idHaceParte);
    String actualizarParticipacion(int idHaceParte, HaceParteModel detallesParticipacion);
    List<HaceParteModel> mostrarPerteneceMenorQueUno();
}
