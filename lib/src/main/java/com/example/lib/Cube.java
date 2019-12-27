package com.example.lib;

import java.util.Scanner;

public class Cube {
    private Scanner scanner = new Scanner(System.in);
    private float cube[] = new float[40];
    private float point[] = new float[20];
    private int cubeN=0,cubeC=0,pointN=0,pointC=0;
    private float NUm=0;
    private float NUmm=0;


    public void makemoreCube(){
        System.out.println("Enter r to bulid a rectangle(maximum is 10),or enter e to exit");
        String s =scanner.next();
        while ((s.matches("r")!=true)&&(s.matches("e")!=true)){
            System.out.println("Enter r to bulid a rectangle(maximum is 10),or enter e to exit");
            s =scanner.next();
        }
        if(s.matches("r")){
            cubeN++;
            makeCube(cubeN,cubeC);
            cubeC+=4;
            makemoreCube();
        }
        else if(s.matches("e")){
            System.out.println("exit");
        }
    }

    public void makemorePoint(){
        System.out.println("Enter p to bulid a dot(maximum is 10),or enter e to exit");
        String s =scanner.next();
        while ((s.matches("p")!=true)&&(s.matches("e")!=true)){
            System.out.println("Enter p to bulid a dot(maximum is 10),or enter e to exit");
            s =scanner.next();
        }
        if(s.matches("p")){
            pointN++;
            makePoint(pointN,pointC);
            pointC+=2;
            makemorePoint();
        }
        else if(s.matches("e")){
            System.out.println("exit");
        }
    }

    private void setLowRight(int cC,float BRx,float BLy){
        cube[cC]=BRx;
        cube[cC+1]=BLy;
    }
    private void setUpLeft(int cC,float TLx,float TLy){
        cube[cC+2]=TLx;
        cube[cC+3]=TLy;
    }

    public  void makeCube(int cN,int cC){
        while ((cube[cC]<=cube[cC+2])||(cube[cC+1]>=cube[cC+3])){
            System.out.printf("please enter  upper left corner of figure %d (x y)\n",cN);
            setUpLeft(cC,scanner.nextFloat(),scanner.nextFloat());
            System.out.printf("please enter  lower right corner of figure %d (x y)\n",cN);
            setLowRight(cC,scanner.nextFloat(),scanner.nextFloat());
        }
    }
    public void makePoint(int pN,int pC){
        System.out.printf("Enter the dot %d (x y)\n",pN);
        point[pC]=scanner.nextFloat();
        NUm=point[pC];
        point[pC+1]=scanner.nextFloat();
        NUmm=point[pC+1];
        System.out.printf("save success the dot %d is ( %.2f , %.2f )\n",pN,NUm,NUmm);

    }

    public void pointCheck(){
        for (int j=0;j<pointN;j++){
            for(int i=0;i<cubeN;i++){
                if ((point[(j*2)]<cube[(i*4)])&&(point[((j*2)+1)]>cube[((i*4)+1)])&&(point[((j*2))]>cube[((i*4)+2)])&&(point[((j*2)+1)]<cube[((i*4)+3)])){
                    System.out.printf("dot %d is in the %d\n",(j+1),(i+1));
                }
                else{
                    System.out.printf("dot %d is not in the %d\n",(j+1),(i+1));
                }
            }
        }
    }
}