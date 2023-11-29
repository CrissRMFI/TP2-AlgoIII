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

        revisarSiLosDatosNecesariosEstan(informacion);

        JsonNode mapaInformacion = informacion.get("mapa");

        this.ancho = conseguirNumero("ancho", mapaInformacion, 100);
        this.largo = conseguirNumero("largo", mapaInformacion, 100);

        JsonNode caminoInformacion = informacion.get("camino");

        this.celdas = caminoInformacion.get("celdas");

    }

    @Override
    public Map<Posicion, Casillero> construirMapa(LinkedList<Posicion> posiciones) throws DatoNoValido {
        Map<Posicion,Casillero> mapa = new HashMap<>();
        Casilleros casilleros = new Casilleros();

        for (JsonNode celda : this.celdas) {

            int x = this.conseguirNumero("x", celda, this.largo);
            int y = this.conseguirNumero("y", celda, this.ancho);
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

    private int conseguirNumero(String dato, JsonNode informacion, int limiteMaximo) throws DatoNoValido {
        if (!(informacion.get(dato).isInt())){
            throw new DatoNoValido();
        }
        int numeroEncontrado = informacion.get(dato).asInt();
        if ((numeroEncontrado <= 0) || (numeroEncontrado > limiteMaximo)){
            throw new DatoNoValido();
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