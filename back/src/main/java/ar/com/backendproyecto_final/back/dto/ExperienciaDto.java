package ar.com.backendproyecto_final.back.dto;

import javax.validation.constraints.NotBlank;


public class ExperienciaDto {
   
    @NotBlank
    private String nombreExp;
    
    @NotBlank
    private String descripcionExp;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
       
}
