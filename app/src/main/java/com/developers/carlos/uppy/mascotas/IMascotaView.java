package com.developers.carlos.uppy.mascotas;

import com.developers.carlos.uppy.modelos.Mascota;

import java.util.List;

/**
 * Created by carlos on 16/02/17.
 */

public interface IMascotaView {


    void setData(List<Mascota> mascotas);

    void mostrarToast(String msj);

}
