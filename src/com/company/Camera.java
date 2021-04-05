package com.company;

public class Camera {
    String name;
    String pName;
    int price;
    double crop;
    int resolution;
    int fps;
    int iso;
    int deep;
    int speed;
    boolean stab;
    int fPar;
    int dfPar;
    int upDown;
    int sub;


    Camera(String name, String pName, int price, double crop, int resolution, int fps, int iso, int deep, int speed, boolean stab) {
        this.name=name;
        this.pName=pName;
        this.price = price;
        this.crop = crop;
        this.resolution = resolution;
        this.fps = fps;
        this.iso = iso;
        this.deep = deep;
        this.speed = speed;
        this.stab = stab;
        this.dfPar = 0;
        this.upDown = 0;
        this.sub = 0;
    }

}
