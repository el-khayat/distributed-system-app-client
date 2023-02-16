//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package projectFinal;

import java.awt.image.Kernel;
import java.io.Serializable;

public class Data implements Serializable {
    public String task;
    public byte[] f;
    public int id;
    public int hegth;
    public int width;
    public float[] arrayKirnel;
    public float[][] matA;
    public float[][] matB;
    public float[][] Res = new float[][]{{0.0F, 0.0F, 0.0F}, {0.0F, 0.0F, 0.0F}};
    public char operation;
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float[][] getMatA() {
        return this.matA;
    }

    public void setMatA(float[][] matA) {
        this.matA = matA;
    }

    public float[][] getMatB() {
        return this.matB;
    }

    public void setMatB(float[][] matB) {
        this.matB = matB;
    }

    public float[][] getRes() {
        return this.Res;
    }

    public void setRes(float[][] res) {
        this.Res = res;
    }

    public char getOperation() {
        return this.operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public int getHegth() {
        return this.hegth;
    }

    public void setHegth(int hegth) {
        this.hegth = hegth;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Data() {
    }

    public Data(byte[] f, Kernel kernel) {
        this.f = f;
    }

    public byte[] getF() {
        return this.f;
    }

    public void setF(byte[] f) {
        this.f = f;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float[] getArrayKirnel() {
        return this.arrayKirnel;
    }

    public void setArrayKirnel(float[] arrayKirnel) {
        this.arrayKirnel = arrayKirnel;
    }

    public Data(float[][] matA, float[][] matB, char operation) {
        this.matA = matA;
        this.matB = matB;
        this.operation = operation;
    }

    public String getTask() {
        return this.task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
