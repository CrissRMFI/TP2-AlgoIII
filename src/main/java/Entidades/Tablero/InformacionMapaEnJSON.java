package Entidades.Tablero;

import Entidades.Elementos.Interactuable;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipamiento;
import Entidades.Equipo.Equipo;
import Entidades.Jugadores.Jugador;
import Entidades.Obstaculos.Bacanal;
import Entidades.Obstaculos.FieraSalvaje;
import Entidades.Obstaculos.Obstaculo;
import Entidades.Obstaculos.Piedra;
import Entidades.Premios.Comida;
import Entidades.Premios.Premio;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class InformacionMapaEnJSON implements InformacionMapa{
    private int ancho;
    private int largo;
    private JsonNode celdas;
    public InformacionMapaEnJSON (String rutaArchivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(rutaArchivo));

        this.ancho = jsonNode.get("mapa").get("ancho").asInt();
        this.largo = jsonNode.get("mapa").get("largo").asInt();
        this.celdas = jsonNode.get("camino").get("celdas");

    }
    @Override
    public Map<Posicion,Casillero> construirMapa(LinkedList<Posicion> posiciones) {
        Map<Posicion,Casillero> mapa = new HashMap<>();

        for (JsonNode celda : this.celdas) {

            int x = celda.get("x").asInt();
            int y = celda.get("y").asInt();
            Posicion posicion= new Posicion(x,y);

            String tipo = celda.get("tipo").asText();

            if (tipo.equals("Camino")) {
                CasilleroMapa casilleroMapa = new CasilleroMapa();
                String obstaculo = celda.get("obstaculo").asText();
                String premio = celda.get("premio").asText();

                if (!obstaculo.equals("")) {
                    Obstaculo obs = this.obtenerTipoDeObstaculo(obstaculo);
                    casilleroMapa.recibirElemento(obs);
                }

                if (!premio.equals("")) {
                    Premio p = this.obtenerTipoDePremio(premio);
                    casilleroMapa.recibirElemento(p);
                }
                mapa.put(posicion,casilleroMapa);
                posiciones.add(posicion);
            } else if (tipo.equals("Salida")) {
                Casillero casilleroInicial = new CasilleroInicial(posicion);
                mapa.put(posicion,casilleroInicial);
                posiciones.add(posicion);
            } else {
                Casillero casilleroFinal = new CasilleroFinal(posicion);
                mapa.put(posicion,casilleroFinal);
                posiciones.add(posicion);
            }



        }

        return mapa;
    }

    private Obstaculo obtenerTipoDeObstaculo (String tipoObstaculo) {
        if (tipoObstaculo.equals("Lesion")) {
            return new Piedra();
        } else if (tipoObstaculo.equals("Fiera")) {
            return new FieraSalvaje();
        } else {
            return new Bacanal();
        }
    }

    private Premio obtenerTipoDePremio (String premio) {
        if (premio.equals("Equipamiento")) {
            return new Equipo();
        } else {
            return new Comida();
        }
    }
}
