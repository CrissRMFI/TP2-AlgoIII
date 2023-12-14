package sonido;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


import java.io.File;

public class ReproductorSonido {

    private MediaPlayer mediaPlayer;
    public ReproductorSonido(String rutaSonido) {

        Media media = new Media(new File(rutaSonido).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);

    }

    public void reproducir() {
        this.mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
                //mediaPlayer.play();
            }
        });
        // No puedo hacer que se repita el sonido
        this.mediaPlayer.play();
    }
}
