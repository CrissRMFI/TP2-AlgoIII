package edu.fiuba.algo3.entrega_2;
import Datos.InformacionJSON;
import Datos.InformacionMapaEnJSON;
import Datos.InformacionMapaLinealEnMatriz;
import Entidades.AlgoRoma;
import Entidades.Errores.*;
import Entidades.Premios.Comida;
import Entidades.Interactuable;
import Entidades.Elementos.MockDado;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.Obstaculos.Fiera;
import Entidades.Premios.Equipamiento;
import Entidades.Premios.JerarquiaEquipos;
import Entidades.Tablero.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class Entrega2 {

    @Test
    public void siElArchivoNoExisteLanzaExcepcion(){
        assertThrows(ArchivoNoEncontrado.class, () -> new InformacionMapaEnJSON("map31232a.json"));
    }

    @Test
    public void siElArchivoNoTieneDatoMapaLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoMapa.json"));
    }

    @Test
    public void siElArchivoNoTieneDatoAnchoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoAncho.json"));
    }

    @Test
    public void siElArchivoNoTieneDatoLargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoAlto.json"));
    }

    @Test
    public void siElDatoAnchoEsNegativoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoValido.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoAnchoNegativo.json"));
    }

    @Test
    public void siElDatoAltoEsNegativoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoValido.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoAltoNegativo.json"));
    }

    @Test
    public void siElArchivoNoTieneDatoCaminoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoCamino.json"));
    }
}
