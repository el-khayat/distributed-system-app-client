package projectFinal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class UtilClient implements IUtilClient {
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    @Override
    public String[] setInfoFromFile(String filepath) throws IOException {
        File file = new File(filepath);
        String config[] = new String[2];

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        while (line != null) {

            line = br.readLine();
            if (line == null)
                break;
            String[] lineStrings = line.split(";");
            config[0] = lineStrings[0];
            config[1] = lineStrings[1];
        }
        br.close();
        return config;
    }

    @Override
    public float[] setKernelFromFile(String filepath) throws IOException {
        File file = new File(filepath);
        float[] kernel = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String lineKernel = "";

        while (lineKernel != null) {
            lineKernel = br.readLine();
            if (lineKernel == null)
                break;
            String[] lineStrings = lineKernel.split(";");
            kernel = new float[lineStrings.length];
            for (int i = 0; i < lineStrings.length; ++i)
                kernel[i] = Float.parseFloat(lineStrings[i]);
        }
        br.close();
        return kernel;
    }

    @Override
    public File setImage(String filepath) {
        return new File(filepath);
    }

    @Override
    public float[][] ReadMatrice(String text, int size) {
        System.out.println(text);
        final Scanner sc = new Scanner(System.in);
        float[][] a = new float[size][size] ;
        System.out.println("Entrez  Matrice");
        int i;
        int j;
        for (i = 0; i < size; ++i) {
            for (j = 0; j < size; ++j) {
                System.out.println("  M[" + i + "][" + j + "] =  ");
                a[i][j] = Integer.parseInt(sc.next());
            }
        }
        return a;
    }

    @Override
    public float[][] sendReciveMatrice(String host ,int port, Data data) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(host,port);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        // send
        out.writeObject(data);
        out.flush();
        // receive
        data = (Data) in.readObject();
        System.out.println("le resultat est renvoyer du serveur");
        socket.close();
        return data.getRes();
    }

    @Override
    public void printMatrice(float[][] matrice) {
        String matAs = "\n";
        matAs += "\n";
        for (int i = 0; i < matrice.length; ++i) {
            matAs += "[";
            for (int j = 0; j < matrice.length; ++j) {
                matAs += matrice[i][j];
                matAs += " ";
            }
            matAs += " ]\n";
        }
        System.out.println(matAs);
    }

    @Override
    public byte[] fileToByte(File file) throws IOException {
        FileInputStream fl = new FileInputStream(file);

        byte[] bytes = new byte[(int) file.length()];
        fl.read(bytes);

        fl.close();

        return bytes;
    }

    @Override
    public File byteToFile(byte[] bytes, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        os.write(bytes);
        os.close();
        return file;
    }

    @Override
    public BufferedImage byteToBuffredImage(byte[] bytes) throws IOException {
        BufferedImage bufferedImage = null;
        InputStream is = new ByteArrayInputStream(bytes);
        bufferedImage = ImageIO.read(is);
        return bufferedImage;
    }

    @Override
    public byte[] buffredImageToByte(BufferedImage bi) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", baos);
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    public  byte[]   applyFilterRMI(byte[] image,String filter,String host,int port){
        try{
            Registry registry = LocateRegistry.getRegistry(host,port);
            IFilterRMI stub = (IFilterRMI) registry.lookup("Test");

            switch(filter){
                case "gray"  :
                    image = stub.Grayscale(image) ;
                    break;
                case "negative"  :
                    image = stub.negative(image);
                    break;
                case "red"  :
                    image = stub.red(image);
                    break;
                case "sepia"  :
                    image = stub.sepia(image);
                    break;
                case "blue"  :
                    image = stub.blue(image);
                    break;
                case "green"  :
                    image = stub.green(image);
                    break;
                default:
                    System.out.println("Your choise Doesn't exist ");
                    break;

            }

        }catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

        return image;
    }
    public byte[] applyConvOnImage(String host,int port,byte[] image,float[] Kernel) throws UnknownHostException, IOException, ClassNotFoundException{

        socket = new Socket(host, port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        // = = = = == === ==== ====== ======== ======== =====
        Data data = new Data();
        data.setF(image);
        data.setArrayKirnel(Kernel);
        data.setHegth((int)Math.sqrt(Kernel.length));
        data.setWidth((int)Math.sqrt(Kernel.length));
        data.setTask("convolution");
        out.writeObject(data);
        out.flush();

        data=(Data)in.readObject();
        socket.close();
        return data.getF();
    }



}
