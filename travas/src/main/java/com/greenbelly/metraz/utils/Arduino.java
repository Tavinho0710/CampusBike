package com.greenbelly.metraz.utils;

public class Arduino {
    private ControlePorta arduino;

    /**
     * Construtor da classe Arduino
     */
    public Arduino(){
//      arduino = new ControlePorta("/dev/ttyACM0",9600);//Windows - porta e taxa de transmissão
        arduino = new ControlePorta("/dev/ttyUSB1",9600);//Linux - porta e taxa de transmissão
    }


    public void comunicacaoArduino(String action) {
        arduino.enviaDados(action);
    }
}
