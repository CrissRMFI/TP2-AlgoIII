package edu.fiuba.algo3.entrega_2;

import Datos.InformacionMapaEnJSON;
import Entidades.Errores.*;
import Entidades.Tablero.Mapa;
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
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoLargo.json"));
    }

    @Test
    public void siElDatoAnchoEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoValido.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoAnchoNegativo.json"));
    }

    @Test
    public void siElDatoLargoEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoValido.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoLargoNegativo.json"));
    }

    @Test
    public void siElArchivoNoTieneDatoCaminoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoCamino.json"));
    }

    @Test
    public void siElArchivoNoTieneDatoCeldasLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoCeldas.json"));
    }

    @Test
    public void siElArchivoNoTieneNingunaCeldaLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinCeldas.json"));
    }

    @Test
    public void siElValorXDeUnaCeldaEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorXDeCeldaNegativo.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoNoValido.class, () -> mapa.contruirMapa());
    }

    @Test
    public void siElValorXDeUnaCeldaEsMayorALargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorXDeCeldaFueraDeRango.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoNoValido.class, () -> mapa.contruirMapa());
    }

    @Test
    public void siElValorYDeUnaCeldaEsMayorALargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorYDeCeldaFueraDeRango.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoNoValido.class, () -> mapa.contruirMapa());
    }

    @Test
    public void siElValorYDeUnaCeldaEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorYCero.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoNoValido.class, () -> mapa.contruirMapa());
    }

    /*
    @Test
    public void elTipoDeCeldaEsBatman() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConCeldaTipoBatman.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        mapa.contruirMapa();
    }

     */
}
