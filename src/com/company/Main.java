package com.company;

public class Main {

    public static void print(Camera[] mas){
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("|  Model  | Crop | Resolution | FPS | Native ISO | Color Deep | Mb/s | Stabilization | Price |");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (int i = 0; i < mas.length; i++){
            System.out.println("| " + mas[i].pName + " | "  + mas[i].crop + "  |     " + mas[i].resolution + "      | " + mas[i].fps + "  |     " + mas[i].iso + "    |   " + mas[i].deep + "    | " + mas[i].speed + "  |    " + mas[i].stab + "      | " + mas[i].price + " |");
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }


    public static void firstPar (Camera cam1, Camera cam2){

        cam1.fPar = 0;
        cam2.fPar = 0;

        if (cam1.price > cam2.price){
            cam2.fPar+=1;
        } else if (cam1.price < cam2.price){
            cam1.fPar+=1;
        } else {
            cam1.fPar+=1;
            cam2.fPar+=1;
        }

        if (cam1.crop > cam2.crop){
            cam2.fPar+=1;
        } else if (cam1.crop < cam2.crop){
            cam1.fPar+=1;
        } else {
            cam1.fPar+=1;
            cam2.fPar+=1;
        }

        if (cam1.resolution > cam2.resolution){
            cam1.fPar+=1;
        } else if (cam1.resolution < cam2.resolution){
            cam2.fPar+=1;
        } else {
            cam1.fPar+=1;
            cam2.fPar+=1;
        }

        if (cam1.fps > cam2.fps){
            cam1.fPar+=1;
        } else if (cam1.fps < cam2.fps){
            cam2.fPar+=1;
        } else {
            cam1.fPar+=1;
            cam2.fPar+=1;
        }

        if (cam1.iso > cam2.iso){
            cam1.fPar+=1;
        } else if (cam1.iso < cam2.iso){
            cam2.fPar+=1;
        } else {
            cam1.fPar+=1;
            cam2.fPar+=1;
        }

        if (cam1.deep > cam2.deep){
            cam1.fPar+=1;
        } else if (cam1.deep < cam2.deep){
            cam2.fPar+=1;
        } else {
            cam1.fPar+=1;
            cam2.fPar+=1;
        }

        if (cam1.speed >  cam2.speed){
            cam1.fPar+=1;
        } else if (cam1.speed < cam2.speed){
            cam2.fPar+=1;
        } else {
            cam1.fPar+=1;
            cam2.fPar+=1;
        }

        if (cam1.stab && !cam2.stab){
            cam1.fPar+=1;
        } else if (!cam1.stab && cam2.stab){
            cam2.fPar+=1;
        } else if (cam1.stab && cam2.stab){
            cam1.fPar+=1;
            cam2.fPar+=1;
        }

        if (cam1.fPar==8){
            cam1.dfPar+=1;
        } else if (cam2.fPar==8){
            cam2.dfPar+=1;
        }

    }


    public static void main(String[] args) {


        Camera XT4 = new Camera("X-T4", "  X-T4 ", 105000, 1.5, 4, 60, 640, 10422, 400, true);
        Camera XT3 = new Camera("X-T3", "  X-T3 ", 82000, 1.5, 4, 60, 640, 10422, 400, false);
        Camera XT30 = new Camera("X-T30", "  X-T30", 59000, 1.5, 4, 30, 640, 10420, 200, false);
        Camera BMPCC6K = new Camera("BMPCC6K", "BMPCC6K", 169000, 1, 6, 60, 3200, 12422, 483, false);
        Camera BMPCC4K = new Camera("BMPCC4K", "BMPCC4K", 116000, 1.9, 4, 60, 3200, 12422, 203, false);
        Camera BMMCC = new Camera("BMMCC", " BMMCC ", 98000, 1.9, 1, 0, 800, 10422, 65, false);
        Camera A7sIII = new Camera("A7sIII", " A7sIII", 267000, 1, 4, 120, 800, 10422, 300, true);
        Camera A7sII = new Camera("A7sII", " A7sII ", 153000, 1, 4, 30, 100, 8420, 100, true);
        Camera A7sI = new Camera("A7sI", "  A7sI ", 98000, 1, 4, 30, 100, 8420, 28, false);
        Camera a6600 = new Camera("a6600", " a6600 ", 94000, 1.5, 4, 30, 100, 8420, 200, true);

        Camera[] mainMas = {XT4, XT3, XT3, BMPCC6K, BMPCC4K, BMMCC, A7sIII, A7sII, A7sI, a6600};

        print(mainMas);

        for (int i = 0; i < mainMas.length; i++) {
            for (int j = 0; j < mainMas.length; i++) {
                firstPar(mainMas[i], mainMas[j]);
            }
            System.out.println(mainMas[i].name + " " + mainMas[i].dfPar);
        }


    }
}
