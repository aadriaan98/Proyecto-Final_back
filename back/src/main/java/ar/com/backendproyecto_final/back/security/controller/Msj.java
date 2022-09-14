package ar.com.backendproyecto_final.back.security.controller;


public class Msj {
    private String msj;
    
    public Msj() {
    }

    public Msj(String msj) {
        this.msj = msj;
    }

    public String getMensaje() {
        return msj;
    }

    public void setMensaje(String mensaje) {
        this.msj = mensaje;
    }
}
