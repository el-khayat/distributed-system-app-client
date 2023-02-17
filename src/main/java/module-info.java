module projectFinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

//    requires org.kordamp.bootstrapfx.core;
//    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires java.rmi;
    requires okhttp3 ;


    opens projectFinal to javafx.fxml;
    exports projectFinal;
}