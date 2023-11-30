package Vista;

import Datos.MensajesUsuario;
import Entidades.Jugadores.Jugador;
import Entidades.ListaCircular;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PanelDeControlVista {
    private GridPane grid;
    private VBox columna1;
    private VBox columna2;
    private VBox columna3;

    private MensajesUsuario m = new MensajesUsuario();



    public PanelDeControlVista() {
        this.columna1 = new VBox();
        this.columna2 = new VBox();
        this.columna3 = new VBox();
        this.grid = new GridPane();
    }


    public GridPane crearVista (ListaCircular<Jugador> jugadores) {

       this.grid.add(this.tabla(),0,0);

        return this.grid;
    }

    public TableView<Item> tabla () {
        MensajesUsuario m = new MensajesUsuario();
        GridPane grid = new GridPane();
        TableView<Item> tablaItems = new TableView<>();
        tablaItems.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox.setVgrow(tablaItems, Priority.ALWAYS );

        TableColumn<Item, String> colJugadores = new TableColumn<>(m.PanelControlTituloJugadores());
        TableColumn<Item, String> colTurno = new TableColumn<>(m.PanelControlTituloTurno());
        TableColumn<Item, String> colLanzar = new TableColumn<>(m.PanelControlTituloLanzar());


        colJugadores.setCellValueFactory( new PropertyValueFactory<>(m.PanelControlTituloJugadores()) );
        colTurno.setCellValueFactory( new PropertyValueFactory<>(m.PanelControlTituloTurno()) );
        colLanzar.setCellValueFactory( new PropertyValueFactory<>(m.PanelControlTituloLanzar()) );


        tablaItems.getColumns().addAll(
                colJugadores,colTurno,colLanzar
        );

        tablaItems.getItems().addAll(
                new Item("KBD-0455892", "Mechanical Keyboard","hola"),
                new Item( "145256", "Product Docs","hola"),
                new Item( "OR-198975", "O-Ring (100)","prueba")
        );

        Button btnInventory = new Button("Inventory");
        Button btnCalcTax = new Button("Tax");

        btnInventory.disableProperty().bind(
                tablaItems.getSelectionModel().selectedItemProperty().isNull()
        );

        btnCalcTax.disableProperty().bind(
                tablaItems.getSelectionModel().selectedItemProperty().isNull().or(
                        Bindings.select(
                                tablaItems.getSelectionModel().selectedItemProperty(),
                                "taxable"
                        ).isEqualTo(false)
                )
        );

        HBox buttonHBox = new HBox( btnInventory, btnCalcTax );
        buttonHBox.setSpacing( 8 );

        VBox vbox = new VBox( tablaItems, buttonHBox );
        vbox.setPadding( new Insets(10) );
        vbox.setSpacing( 10 );

        return tablaItems;
    }


}
