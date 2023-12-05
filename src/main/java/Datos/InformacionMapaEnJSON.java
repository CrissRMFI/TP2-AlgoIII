package Datos;

import Entidades.Constructores.ConstructorObstaculo;
import Entidades.Constructores.ConstructorPremio;
import Entidades.Errores.*;
import Entidades.Obstaculos.Obstaculo;
import Entidades.Premios.Premio;
import Entidades.Tablero.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.LinkedList;

public class InformacionMapaEnJSON implements InformacionMapa{
    private int ancho;
    private int largo;
    private JsonNode celdas;
    private LinkedList listaPosiciones = new LinkedList<>();


    public InformacionMapaEnJSON (String rutaArchivo) throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        JsonNode informacion = new InformacionJSON(rutaArchivo).devolverInformacionDelArchivo();

        this.revisarSiLosDatosNecesariosEstan(informacion);

        JsonNode mapaInformacion = informacion.get("mapa");

        this.ancho = conseguirNumero("ancho", mapaInformacion, 100);
        this.largo = conseguirNumero("largo", mapaInformacion, 100);

        JsonNode caminoInformacion = informacion.get("camino");

        this.celdas = caminoInformacion.get("celdas");
    }

    @Override
    public void construirCamino(LinkedList<Casillero> camino) throws DatoNoValido {

        ConstructorPremio constructorPremio = new ConstructorPremio();
        ConstructorObstaculo constructorObstaculo = new ConstructorObstaculo();

        for (JsonNode celda : this.celdas) {
            int x = this.conseguirNumero("x", celda, this.largo);
            int y = this.conseguirNumero("y", celda, this.ancho);

            
            Casillero casillero = new Casillero(x,y);
            

            String tipoPremio = celda.get("premio").asText();
            Premio premio = constructorPremio.construirPremio(tipoPremio);

            String tipoObstaculo = celda.get("obstaculo").asText();
            Obstaculo obstaculo = constructorObstaculo.construirObstaculo(tipoObstaculo);

            casillero.recibirElemento(premio);
            casillero.recibirElemento(obstaculo);
            camino.add(casillero);
        }
    }


    public int conseguirAncho() {
        return this.ancho;
    }

    public int conseguirLargo() {
        return this.largo;
    }


    private int conseguirNumero(String dato, JsonNode informacion, int limiteMaximo) throws DatoNoValido {
        if (!(informacion.get(dato).isInt())){
            throw new DatoNoValido();
        }
        int numeroEncontrado = informacion.get(dato).asInt();
        if ((numeroEncontrado <= 0) || (numeroEncontrado > limiteMaximo)){
            throw new DatoFueraDeRango();
        }
        return numeroEncontrado;
    }

    private void revisarSiLosDatosNecesariosEstan(JsonNode informacion) throws DatoNoEncontrado{
        String[] datos = {"mapa", "ancho", "largo",
                "camino", "celdas", "x", "y", "tipo", "obstaculo", "premio"};
        for (String dato : datos){
            if (informacion.findValue(dato) == null ){
                throw new DatoNoEncontrado();
            }
        }
    }


}