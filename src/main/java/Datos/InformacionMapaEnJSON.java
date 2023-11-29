package Datos;

import Entidades.Constructores.Casilleros;
import Entidades.Constructores.ElementosCamino;
import Entidades.Obstaculos.Obstaculo;
import Entidades.Premios.Premio;
import Entidades.Tablero.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class InformacionMapaEnJSON implements InformacionMapa{
    private int ancho;
    private int largo;
    private JsonNode celdas;
    private LinkedList listaPosiciones = new LinkedList<>();
    public InformacionMapaEnJSON (String rutaArchivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(rutaArchivo));

        this.ancho = jsonNode.get("mapa").get("ancho").asInt();
        this.largo = jsonNode.get("mapa").get("largo").asInt();
        this.celdas = jsonNode.get("camino").get("celdas");

    }
    @Override
    public Map<Posicion, Casillero> construirMapa(LinkedList<Posicion> posiciones) {
        Map<Posicion,Casillero> mapa = new HashMap<>();
        ElementosCamino elementosCamino = new ElementosCamino();
        Casilleros casilleros = new Casilleros();

        for (JsonNode celda : this.celdas) {

            int x = celda.get("x").asInt();
            int y = celda.get("y").asInt();
            Posicion posicion= new Posicion(x,y);
            this.listaPosiciones.add(posicion);


            String tipoCasillero = celda.get("tipo").asText();
            Casillero casillero = casilleros.obtenerCasillero(tipoCasillero);

            String tipoObstaculo = celda.get("obstaculo").asText();
            String tipoPremio = celda.get("premio").asText();

            Obstaculo obstaculo = elementosCamino.obtenerTipoDeObstaculo(tipoObstaculo);
            Premio premio = elementosCamino.obtenerTipoDePremio(tipoPremio);

            if (premio != null) casillero.recibirElemento(premio);
            if (obstaculo != null) casillero.recibirElemento(obstaculo);

            mapa.put(posicion,casillero);
            posiciones.add(posicion);
        }

        return mapa;
    }
    @Override
    public LinkedList listaDePosiciones () {
        return this.listaPosiciones;
    }

}
