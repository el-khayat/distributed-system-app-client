package projectFinal;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;

import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.rmi.NotBoundException;
import java.util.ResourceBundle;





public class HelloController implements Initializable {
    //File file = new File("C:\\Users\\Dell\\Pictures\\woooooooooooow.png");
    File file = new File("woooooooooooow.jpeg");

    @FXML
    private AnchorPane homePage;
    @FXML
    private AnchorPane matrixPage;
    @FXML
    private AnchorPane chatPage;
    @FXML
    private AnchorPane convolutionPage;
    @FXML
    private AnchorPane filterPage;
    @FXML
    private Button homeButton ;
    @FXML
    private Button chatButton ;
    @FXML
    private Button uploadButton ;
    @FXML
    private Button uploadButton1 ;
   @FXML
   private Label label;
    @FXML
    private ImageView imageView ;
    @FXML
    private ImageView imageView1 ;
    @FXML
    private ImageView preloader ;




    FileChooser fileChooser = new FileChooser();
    File selectedFile ;
    File userDirectory = new File(System.getProperty("user.home"));
    UtilClient util = new UtilClient();
    File currentImage = new File("image.jpeg");
    String nakename = null ;
    ObjectOutputStream out;
    ObjectInputStream in ;
    private String host = "localhost";
    private int port = 3336;
    Socket socket ;


    @FXML
    private AnchorPane form;
    @FXML
    private TextField nakenameField ;
    @FXML
    private  Button joinRoomButton ;

    @FXML
    private AnchorPane room;

    @FXML
    private TextField tf_messafeToSend ;

    @FXML
    private Button sendButton ;

    private String messageToSend ;
    @FXML
    public VBox vBox ;
    @FXML
    private TextField a1;
    @FXML
    private TextField a2;
    @FXML
    private TextField a3;
    @FXML
    private TextField a4;
    @FXML
    private TextField a5;
    @FXML
    private TextField a6;
    @FXML
    private TextField a7;
    @FXML
    private TextField a8;
    @FXML
    private TextField a9;
    @FXML
    private TextField b1;
    @FXML
    private TextField b2;
    @FXML
    private TextField b3;
    @FXML
    private TextField b4;
    @FXML
    private TextField b5;
    @FXML
    private TextField b6;
    @FXML
    private TextField b7;
    @FXML
    private TextField b8;
    @FXML
    private TextField b9;
    @FXML
    private TextField r1;
    @FXML
    private TextField r2;
    @FXML
    private TextField r3;
    @FXML
    private TextField r4;
    @FXML
    private TextField r5;
    @FXML
    private TextField r6;
    @FXML
    private TextField r7;
    @FXML
    private TextField r8;
    @FXML
    private TextField r9;
    @FXML
    private ComboBox comboBox ;
    float[][] res = new float[3][3];
    @FXML
    private AnchorPane PaneResMat;
    @FXML
    private Pane PaneFilter;
    @FXML
    private Pane PaneConv;
    @FXML
    private Label displayName;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboBox.getItems().add("+");
        comboBox.getItems().add("-");
        comboBox.getItems().add("*");
    }
    public void CompleteText() {


        String msg =  "hello";
        System.out.println(msg);



    }

    @FXML
    protected void onHomeButtonClick() {
        label.setText("home");
        homePage.setVisible( true);
        matrixPage.setVisible( false);
        convolutionPage.setVisible( false);
        filterPage.setVisible( false);
        chatPage.setVisible( false);
        CompleteText();
    }
    @FXML
    protected void onMatrixButtonClick() {
        label.setText("Matrix");
        homePage.setVisible( false);
        matrixPage.setVisible( true);
        convolutionPage.setVisible( false);
        filterPage.setVisible( false);
        chatPage.setVisible( false);
    }
    @FXML
    protected void onChatButtonClick() {
        label.setText("Chat");
        homePage.setVisible( false);
        matrixPage.setVisible( false);
        convolutionPage.setVisible( false);
        filterPage.setVisible( false);
        chatPage.setVisible( true);
    }
    @FXML
    protected void onConvolutionButtonClick() {
        label.setText("Convolution");
        homePage.setVisible( false);
        matrixPage.setVisible( false);
        convolutionPage.setVisible( true);
        filterPage.setVisible( false);
        chatPage.setVisible( false);
    }
    @FXML
    protected void onFilterButtonClick() {
        label.setText("Filter");
        homePage.setVisible( false);
        matrixPage.setVisible( false);
        convolutionPage.setVisible( false);
        filterPage.setVisible( true);
        chatPage.setVisible( false);
    }
    @FXML
    protected void uploadFile() {
        fileChooser.setInitialDirectory(userDirectory);
        Stage primaryStage ;
        // Show the file chooser and wait for the user's response
        selectedFile = fileChooser.showOpenDialog(new Popup());
        Image image = new Image(selectedFile.toURI().toString());
        imageView.setImage(image);
        imageView1.setImage(image);
        // Check if a file was selected
        if (selectedFile != null) {
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            uploadButton.setVisible(false);
            uploadButton1.setVisible(false);
            PaneFilter.setVisible(true);
            PaneConv.setVisible(true);
            imageView.setFitWidth(800);
            imageView.setFitHeight(450);
            imageView.setLayoutX(70);
            imageView.setLayoutY(10);

            imageView1.setFitWidth(800);
            imageView1.setFitHeight(450);
            imageView1.setLayoutX(70);
            imageView1.setLayoutY(10);


        } else {
            System.out.println("No file selected.");
        }
    }

    @FXML
    protected void RMIRed()  throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
            preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyFilterRMI(util.fileToByte(selectedFile),"red","localhost",9999);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                }
                preloader.setOpacity(0);
            }
        }).start();


    }
    @FXML
    protected void RMIGreen() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyFilterRMI(util.fileToByte(selectedFile),"green","localhost",9999);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                }
                preloader.setOpacity(0);
            }
        }).start();

    }
    @FXML
    protected void RMIBlue() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyFilterRMI(util.fileToByte(selectedFile),"blue","localhost",9999);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                }
                preloader.setOpacity(0);
            }
        }).start();

    }
    @FXML
    protected void RMIGray() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyFilterRMI(util.fileToByte(selectedFile),"gray","localhost",9999);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                }
                preloader.setOpacity(0);
            }
        }).start();

    }
    @FXML
    protected void RMINegative() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyFilterRMI(util.fileToByte(selectedFile),"negative","localhost",9999);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                }
                preloader.setOpacity(0);
            }
        }).start();

    }
    @FXML
    protected void RMISepia() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyFilterRMI(util.fileToByte(selectedFile),"sepia","localhost",9999);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                }
                preloader.setOpacity(0);
            }
        }).start();
    }
    @FXML
    protected void conv1() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    float[] kernel = {0,0,0,0,1,0,0,0,0};
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyConvOnImage("localhost",3336,util.fileToByte(selectedFile),kernel);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                preloader.setOpacity(0);
            }
        }).start();
    }
    @FXML
    protected void conv2() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    float[] kernel = {0,-1,0,-1,4,-1,0,-1,0};
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyConvOnImage("localhost",3336,util.fileToByte(selectedFile),kernel);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                preloader.setOpacity(0);
            }
        }).start();
    }
    @FXML
    protected void conv3() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    float[] kernel = {-1,-1,-1,-1,8,-1,-1,-1,-1};
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyConvOnImage("localhost",3336,util.fileToByte(selectedFile),kernel);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                preloader.setOpacity(0);
            }
        }).start();
    }
    @FXML
    protected void conv4() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    float[] kernel = {0,-1,0,-1,5,-1,0,-1,0} ;
                    System.out.println("filter rmi ");
                    byte[] imageByte = util.applyConvOnImage("localhost",3336,util.fileToByte(selectedFile),kernel);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                preloader.setOpacity(0);
            }
        }).start();
    }
    @FXML
    protected void conv5() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    float[] kernel = {0,-1,0,-1,5,-1,0,-1,0};
                    byte[] imageByte = util.applyConvOnImage("localhost",3336,util.fileToByte(selectedFile),kernel);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                preloader.setOpacity(0);
            }
        }).start();
    }
    @FXML
    protected void conv6() throws IOException, NotBoundException, ClassNotFoundException {
        preloader.setFitWidth(500);
        preloader.setFitHeight(300);
        preloader.setOpacity(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    float[] kernel = {1/16,1/16,1/16,1/16,1/16,1/16,1/16,1/16,1/16};
                    byte[] imageByte = util.applyConvOnImage("localhost",3336,util.fileToByte(selectedFile),kernel);
                    util.byteToFile(imageByte,file);
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                    imageView1.setImage(image);
                    // preloader.setOpacity(0);
                } catch (IOException ex) {
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                preloader.setOpacity(0);
            }
        }).start();
    }
    @FXML
    protected void sendMessage(){
            System.out.println("jjjjj");
            messageToSend = tf_messafeToSend.getText();
            if (messageToSend!=null && messageToSend !=""){
                HBox hBox = new HBox();
//                hBox.setStyle("-fx-background-color: red;-fx-border-color: green;-fx-pref-height: 30px");
                hBox.setAlignment(Pos.CENTER_RIGHT);
                hBox.setPadding(new Insets(5,5,5,10));

                Text text = new Text(messageToSend) ;
                TextFlow textFlow = new TextFlow(text);
                textFlow.setStyle("-fx-border-color: rgb(239,242,255);-fx-background-color: rgb(15,125,242);-fx-background-radius: 20px;-fx-font-size: 16px");
                textFlow.setPadding(new Insets(5,5,5,10));
                text.setFill(Color.color(0.934,0.945,0.996));

                hBox.getChildren().add(textFlow);
                vBox.getChildren().add(hBox);
                tf_messafeToSend.clear();

                try{
                        Data data = new Data();
                            data.setTask("chat");

                                data.setMessage(nakename+":" +messageToSend) ;
                                out.writeObject(data);
                                out.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
    }
    public static void addLabel(String textFromClient,VBox vBox){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5,5,5,10));
        String[] messageInfo = textFromClient.split(":");

        Text text = new Text(messageInfo[1]) ;
        TextFlow textFlow = new TextFlow(text);
        Text text1 = new Text(messageInfo[0]) ;
        TextFlow textFlow1 = new TextFlow(text1);
        textFlow.setStyle("-fx-border-color: rgb(239,242,255);-fx-background-color: rgb(205,225,242);-fx-background-radius: 20px;-fx-font-size: 16px");
        textFlow.setPadding(new Insets(5,5,5,10));
        text.setFill(Color.color(0.034,0.145,0.196));
        hBox.getChildren().add(textFlow1);
        hBox.getChildren().add(textFlow);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBox.getChildren().add(hBox);
            }
        });
    }
    @FXML
    public void joinToRoom(){
        nakename = nakenameField.getText();
        displayName.setText(nakename);
        room.setVisible(true);
        form.setVisible(false);
        try {
            socket = new Socket(this.host,this.port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Thread(new Runnable() {

            @Override
            public void run() {
                String message ;
                while (true) {
                    synchronized (this){
                        try {
                            Data data = (Data) in.readObject();
                            message = data.getMessage();
                           HelloController.addLabel(message,vBox);
                        } catch (Exception e) {

                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        },"receive").start();
    }
    @FXML
    public void calculeMatrix() throws IOException, ClassNotFoundException {
       float[][] matA = new float[3][3];
       float[][] matB = new float[3][3];
       matA[0][0] = Float.parseFloat(a1.getText().toString());
       System.out.println(a2.getText().toString());
        matA[0][1] = Float.parseFloat(a2.getText().toString());
        matA[0][2] = Float.parseFloat(a3.getText().toString());
        matA[1][0] = Float.parseFloat(a4.getText().toString());
        matA[1][1] = Float.parseFloat(a5.getText().toString());
        matA[1][2] = Float.parseFloat(a6.getText().toString());
        matA[2][0] = Float.parseFloat(a7.getText().toString());
        matA[2][1] = Float.parseFloat(a8.getText().toString());
        matA[2][2] = Float.parseFloat(a9.getText().toString());

        matB[0][0] = Float.parseFloat(b1.getText().toString());
        matB[0][1] = Float.parseFloat(b2.getText().toString());
        matB[0][2] = Float.parseFloat(b3.getText().toString());
        matB[1][0] = Float.parseFloat(b4.getText().toString());
        matB[1][1] = Float.parseFloat(b5.getText().toString());
        matB[1][2] = Float.parseFloat(b6.getText().toString());
        matB[2][0] = Float.parseFloat(b7.getText().toString());
        matB[2][1] = Float.parseFloat(b8.getText().toString());
        matB[2][2] = Float.parseFloat(b9.getText().toString());
        Data data = new Data();
        data.setMatA(matA);
        data.setMatB(matB);
        data.setTask("matrice");
        data.setOperation(comboBox.getValue().toString().charAt(0));
        System.out.println(comboBox.getValue().toString().charAt(0));
        System.out.println("===========================");

       res = util.sendReciveMatrice(host,port,data);



                r1.setText(""+res[0][0]);
                r2.setText(""+res[0][1]);
                r3.setText(""+res[0][2]);

                r4.setText(""+res[1][0]);
                r5.setText(""+res[1][1]);
                r6.setText(""+res[1][2]);

                r7.setText(""+res[2][0]);
                r8.setText(""+res[2][1]);
                r9.setText(""+res[2][2]);
                PaneResMat.setVisible(true);


    }


}