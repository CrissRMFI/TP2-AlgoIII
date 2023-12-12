package Parseador;

import Entidades.Errores.ArchivoNoEncontrado;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ParseadorMapaJson implements Parseador{
    private JsonNode info;
    private MapaJson mapaJson;

    @Override
    public void leerArchivo(String ruta) throws ArchivoNoEncontrado {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            this.info = objectMapper.readTree(new File(ruta));

            InfoMapa infoMapa = new InfoMapa();
            infoMapa.setAncho(info.get("mapa").get("ancho").asInt());
            infoMapa.setLargo(info.get("mapa").get("largo").asInt());

            Camino camino = new Camino();
            LinkedList<Celda> celdas = new LinkedList<>();

            for (JsonNode celdaJson : info.get("camino").get("celdas")) {
                Celda celda = new Celda();
                celda.setX(celdaJson.get("x").asInt());
                celda.setY(celdaJson.get("y").asInt());
                celda.setTipo(celdaJson.get("tipo").asText());
                celda.setObstaculo(celdaJson.get("obstaculo").asText());
                celda.setPremio(celdaJson.get("premio").asText());
                celdas.add(celda);
            }

            camino.setCeldas(celdas);

            this.mapaJson = new MapaJson(infoMapa,camino);

        }
        catch (IOException a){
            throw new ArchivoNoEncontrado();
        }
    }
    @Override
    public MapaJson obtenerInformacion () {
        return this.mapaJson;
    }



}

/*
  private int ancho;
    private int largo;
    private JsonNode celdas;


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

* */