package com.company;

public class Main {

    public static void print(Camera[] mas) {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("|  Model  | Crop | Resolution | FPS | Native ISO | Color Deep | Mb/s | Stabilization | Price |");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (int i = 0; i < mas.length; i++) {
            System.out.println("| " + mas[i].pName + " | " + mas[i].crop + "  |     " + mas[i].resolution + "      | " + mas[i].fps + "  |     " + mas[i].iso + "    |   " + mas[i].deep + "    | " + mas[i].speed + "  |    " + mas[i].stab + "      | " + mas[i].price + " |");
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public static void firstPar(Camera[] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {

                mas[i].fPar = 0;
                mas[j].fPar = 0;

                if (mas[i].price > mas[j].price) {
                    mas[j].fPar += 1;
                } else if (mas[i].price < mas[j].price) {
                    mas[i].fPar += 1;
                } else {
                    mas[i].fPar += 1;
                    mas[j].fPar += 1;
                }

                if (mas[i].crop > mas[j].crop) {
                    mas[j].fPar += 1;
                } else if (mas[i].crop < mas[j].crop) {
                    mas[i].fPar += 1;
                } else {
                    mas[i].fPar += 1;
                    mas[j].fPar += 1;
                }

                if (mas[i].resolution > mas[j].resolution) {
                    mas[i].fPar += 1;
                } else if (mas[i].resolution < mas[j].resolution) {
                    mas[j].fPar += 1;
                } else {
                    mas[i].fPar += 1;
                    mas[j].fPar += 1;
                }

                if (mas[i].fps > mas[j].fps) {
                    mas[i].fPar += 1;
                } else if (mas[i].fps < mas[j].fps) {
                    mas[i].fPar += 1;
                } else {
                    mas[i].fPar += 1;
                    mas[j].fPar += 1;
                }

                if (mas[i].iso > mas[j].iso) {
                    mas[i].fPar += 1;
                } else if (mas[i].iso < mas[j].iso) {
                    mas[j].fPar += 1;
                } else {
                    mas[i].fPar += 1;
                    mas[j].fPar += 1;
                }

                if (mas[i].deep > mas[j].deep) {
                    mas[i].fPar += 1;
                } else if (mas[i].deep < mas[j].deep) {
                    mas[j].fPar += 1;
                } else {
                    mas[i].fPar += 1;
                    mas[j].fPar += 1;
                }

                if (mas[i].speed > mas[j].speed) {
                    mas[i].fPar += 1;
                } else if (mas[i].speed < mas[j].speed) {
                    mas[j].fPar += 1;
                } else {
                    mas[i].fPar += 1;
                    mas[j].fPar += 1;
                }

                if (mas[i].stab && !mas[j].stab) {
                    mas[i].fPar += 1;
                } else if (!mas[i].stab && mas[j].stab) {
                    mas[j].fPar += 1;
                } else if (mas[i].stab && mas[j].stab) {
                    mas[i].fPar += 1;
                    mas[j].fPar += 1;
                }

                if (mas[i].fPar == 16) {
                    mas[i].dfPar += 1;
                } else if (mas[j].fPar == 16) {
                    mas[j].dfPar += 1;
                } else if (mas[i].fPar == 16 && mas[j].fPar == 16) {
                    mas[i].dfPar += 1;
                    mas[j].dfPar += 1;
                }
            }
        }
        //Парето-оптимальные варианты помещаются в начало массива
        for (int i = 1; i < mas.length; i++) {
            int valueToSort = mas[i].dfPar;
            Camera temp = mas[i];
            int j = i;
            while (j > 0 && mas[j - 1].dfPar < valueToSort) {
                mas[j] = mas[j - 1];
                j--;
            }
            mas[j] = temp;
        }
    }

    public static void upDown(Camera[] mas) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i].price <= 200000 && mas[i].iso >= 600) {
                mas[i].upDown += 1;
            }
        }
        //Элементы, подходящие под границы - попадают в начало массива
        for (int i = 1; i < mas.length; i++) {
            int valueToSort = mas[i].upDown;
            Camera temp = mas[i];
            int j = i;
            while (j > 0 && mas[j - 1].upDown < valueToSort) {
                mas[j] = mas[j - 1];
                j--;
            }
            mas[j] = temp;
        }
    }

    public static Camera[] SUB(Camera[] mas) {
        Camera[] mas1 = new Camera[2];
        //Проверка по границам
        for (int i = 0; i < mas.length; i++) {
            if (mas[i].crop <= 1.5 && mas[i].resolution >= 4 && mas[i].fps >= 30 && mas[i].iso >= 300 && mas[i].deep >= 10420 && mas[i].speed >= 200 && mas[i].stab) {
                mas[i].sub += 1;
            }
        }
        //Элементы, подходящие под границы - попадают в начало массива
        for (int i = 1; i < mas.length; i++) {
            int valueToSort = mas[i].sub;
            Camera temp = mas[i];
            int j = i;
            while (j > 0 && mas[j - 1].sub < valueToSort) {
                mas[j] = mas[j - 1];
                j--;
            }
            mas[j] = temp;
        }
        //Записываем камеры прошедшие границы в отдельный массив
        for (int i = 0; i < mas1.length; i++) {
            mas1[i] = mas[i];
        }

        //Сортируем камеры по главному критерию - цена
        for (int i = 1; i < mas1.length; i++) {
            int valueToSort = mas1[i].price;
            Camera temp = mas1[i];
            int j = i;
            while (j > 0 && mas1[j - 1].price > valueToSort) {
                mas1[j] = mas1[j - 1];
                j--;
            }
            mas1[j] = temp;
        }

        return mas1;
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

        Camera[] mainMas = new Camera[]{XT4, XT3, XT30, BMPCC6K, BMPCC4K, BMMCC, A7sIII, A7sII, A7sI, a6600};
        Camera[] parMas = new Camera[4];
        Camera[] upMas = new Camera[6];
        Camera[] upMasPar = new Camera[1];
        Camera[] subMas = new Camera[2];


        System.out.println("Изначальная таблица:");
        print(mainMas);

        firstPar(mainMas); //Определяются Парето оптимальыне варианты

        for (int i = 0; i < parMas.length; i++) {//Парето-оптимаьные варианты записываются в отдельный массив
            parMas[i] = mainMas[i];
        }

        System.out.println("Парето-оптимальные варианты:");
        print(parMas);

        upDown(mainMas); //Определяются варианты, подходящие под границы: ISO не меньше 600, цена не более 200.000 руб.

        for (int i = 0; i < upMas.length; i++) {//Варианты, подходящие под границы, записываются в отдельный массив
            upMas[i] = mainMas[i];
        }

        System.out.println("Варианты, подходящие под границы: ISO не меньше 600, цена не более 200.000 руб.: ");
        print(upMas);

        System.out.println("Из них Парето-оптимальные: ");
        for (int i = 0; i < upMasPar.length; i++) {
            if (upMas[i].dfPar == 1) {
                upMasPar[i] = upMas[i];
            } else break;
        }

        print(upMasPar);


        subMas = SUB(mainMas); //Производится субоптимизация

        System.out.println("Варианты, прошедшие субоптимизацию: ");

        print(subMas);


    }
}
