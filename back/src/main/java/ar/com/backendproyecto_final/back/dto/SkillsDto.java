package ar.com.backendproyecto_final.back.dto;

import javax.validation.constraints.NotBlank;


public class SkillsDto {
    
    @NotBlank
    private String nombreS;
    @NotBlank
    private String porcentaje;

    public SkillsDto() {
    }

    public SkillsDto(String nombreS, String porcentaje) {
        this.nombreS = nombreS;
        this.porcentaje = porcentaje;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
