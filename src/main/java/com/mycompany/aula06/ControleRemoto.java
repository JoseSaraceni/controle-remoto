package com.mycompany.aula06;

public class ControleRemoto implements Controlador{
    //Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;
    
    //Metodos Especiais
    public ControleRemoto(){
    this.volume = 50;
    this.ligado = true;
    this.tocando = false;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    
    //Metodos Abstratos
    @Override
    public void ligar() {
        setLigado(true);
    }

    @Override
    public void desligar() {
        setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if(getLigado()){
            System.out.println("____________MENU____________");
            System.out.println("Está Ligada? " + this.getLigado());
            System.out.println("Está Tocando? " + this.getTocando());
            System.out.print("Volume: " + this.getVolume() + " ");
            for(int i = 1; i <= this.getVolume(); i+=10 ){
            System.out.print("|");
            }
        }
        else{
            System.out.println("TV Desligada, impossivel abrir menu.");
        }
        
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu...");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() + 5);     
        }
        else{
            System.out.println("TV Desligada, impossivel aumentar volume");
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume() - 1);
        }
         else{
            System.out.println("TV Desligada, impossivel diminuir volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado() && this.getVolume() > 0){
            this.setVolume(0);
        }
        else{
            System.out.println("TV Desligada, impossivel ligar mudo");
        }
    }

    @Override
    public void desligarMudo() {
        if (this.getLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }
        else{
            System.out.println("TV Desligada, impossivel desligar Mudo");
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())){
            this.setTocando(true);
        }
        else{
            System.out.println("TV Desligada, impossivel dar play");
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }
        else{
            System.out.println("TV Desligada, impossivel dar pause");
        }
    }
        
    
}
