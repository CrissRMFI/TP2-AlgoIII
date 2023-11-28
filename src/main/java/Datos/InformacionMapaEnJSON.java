package Datos;

import Entidades.Constructores.Casilleros;
import Entidades.Constructores.ElementosCamino;
import Entidades.Interactuable;
import Entidades.Obstaculos.Obstaculo;
import Entidades.Premios.Premio;
import Entidades.Tablero.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    public Map<Posicion, Casillero> construirMapa(LinkedList<Posicion> posiciones) {
        Map<Posicion,Casillero> mapa = new HashMap<>();
        ElementosCamino elementosCamino = new ElementosCamino();
        Casilleros casilleros = new Casilleros();

        for (JsonNode celda : this.celdas) {

            int x = celda.get("x").asInt();
            int y = celda.get("y").asInt();
            Posicion posicion= new Posicion(x,y);


            String tipoCasillero = celda.get("tipo").asText();
            Casillero casillero = casilleros.obtenerCasillero(tipoCasillero);


            String tipoPremio = celda.get("premio").asText();
            casillero.recibirElemento(generarInteractuable("Entidades.Premios."+tipoPremio));
            String tipoObstaculo = celda.get("obstaculo").asText();
            casillero.recibirElemento(generarInteractuable("Entidades.Obstaculos."+tipoObstaculo));


            /*

            Obstaculo obstaculo = elementosCamino.obtenerTipoDeObstaculo(tipoObstaculo);
            Premio premio = elementosCamino.obtenerTipoDePremio(tipoPremio);

            if (premio != null) casillero.recibirElemento(premio);
            if (obstaculo != null) casillero.recibirElemento(obstaculo);

             */
            mapa.put(posicion,casillero);
            posiciones.add(posicion);
        }

        return mapa;
    }

    public Interactuable generarInteractuable(String interactuable){
        if (noHayNada(interactuable)) return null;
        try {
            Interactuable unInteractuable = (Interactuable) Class.forName(interactuable).getDeclaredConstructor().newInstance();
            return unInteractuable;
        } catch (NumberFormatException a){
            System.out.print("NumberFormatException");
        } catch(InstantiationException b){
            System.out.print("InstantiationException");
        } catch (ClassNotFoundException c ){
            System.out.print("ClassNotFoundException");
        } catch (NoSuchMethodException d){
            System.out.print("NoSuchMethodException");
        } catch (IllegalAccessException e){
            System.out.print("IllegalAccessException");
        } catch (InvocationTargetException f){
            System.out.print("InvocationTargetException");
        }
        return null;
    }

    public boolean noHayNada(String interactuable){
        return (interactuable.substring(interactuable.lastIndexOf('.') + 1)).isEmpty();
    }
}