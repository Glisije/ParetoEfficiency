package com.company;

public class Main {

    public static void main(String[] args) {


        Camera XT4 = new Camera("X-T4", "", 105000, 1.5, 4, 60, 640, 10422, 400, true);
        Camera XT3 = new Camera("X-T3", "", 82000, 1.5, 4, 60, 640, 10422, 400, false);
        Camera XT30 = new Camera("X-T30", "", 59000, 1.5, 4, 30, 640, 10420, 200, false);
        Camera BMPCC6K = new Camera("BMPCC6K", "", 169000, 1, 6, 60, 3200, 12422, 483, false);
        Camera BMPCC4K = new Camera("BMPCC4K", "", 116000, 1.9, 4, 60, 3200, 12422, 203, false);
        Camera BMMCC = new Camera("BMMCC", "", 98000, 1.9, 1, 0, 800, 10422, 65, false);
        Camera A7sIII = new Camera("A7sIII", "", 267000, 1, 4, 120, 800, 10422, 300, true);
        Camera A7sII = new Camera("A7sII", "", 153000, 1, 4, 30, 100, 8420, 100, true);
        Camera A7sI = new Camera("A7sI", "", 98000, 1, 4, 30, 100, 8420, 28, false);
        Camera a6600 = new Camera("a6600", "", 94000, 1.5, 4, 30, 100, 8420, 200, true);

        Camera[] mainMas = {XT4, XT3, XT3, BMPCC6K, BMPCC4K, BMMCC, A7sIII, A7sII, A7sI, a6600};




    }
}
