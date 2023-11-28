package Datos;

import Entidades.Constructores.Casilleros;
import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import Entidades.Interactuable;
import Entidades.Tablero.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class InformacionMapaEnJSON implements InformacionMapa{
    private int ancho;
    private int largo;
    private JsonNode celdas;

    public InformacionMapaEnJSON (String rutaArchivo) throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        JsonNode informacion = new InformacionJSON(rutaArchivo).devolverInformacionDelArchivo();
        revisarSiElDatoEsta(new String[]{"mapa"}, informacion);
        JsonNode mapaInformacion = informacion.get("mapa");
        revisarSiElDatoEsta(new String[]{"ancho", "largo"}, mapaInformacion);
        this.ancho = conseguirNumero("ancho", mapaInformacion);
        this.largo = conseguirNumero("largo", mapaInformacion);
        revisarSiElDatoEsta(new String[]{"camino"}, informacion);
        this.celdas = informacion.get("camino").get("celdas");
    }

    @Override
    public Map<Posicion, Casillero> construirMapa(LinkedList<Posicion> posiciones) {
        Map<Posicion,Casillero> mapa = new HashMap<>();
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

            mapa.put(posicion,casillero);
            posiciones.add(posicion);
        }

        return mapa;
    }

    public Interactuable generarInteractuable(String interactuable){
        if (noExisteInteractuable(interactuable)) return null;
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

    private boolean noExisteInteractuable(String interactuable){
        return (interactuable.substring(interactuable.lastIndexOf('.') + 1)).isEmpty();
    }

    private void revisarSiElDatoEsta(String[] datos, JsonNode informacion) throws DatoNoEncontrado {
        for (int i=0; i < datos.length; i++){
            if(!informacion.has(datos[i])){
                throw new DatoNoEncontrado();
            }
        }
    }

    private int conseguirNumero(String dato, JsonNode informacion) throws DatoNoValido {
        if (!(informacion.get(dato).isInt())){
            throw new DatoNoValido();
        }
        int numeroEncontrado = informacion.get(dato).asInt();
        if (numeroEncontrado < 0){
            throw new DatoNoValido();
        }
        return numeroEncontrado;
    }
}