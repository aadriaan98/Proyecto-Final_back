package ar.com.backendproyecto_final.back.dto;

import javax.validation.constraints.NotBlank;

public class EducacionDto {

    @NotBlank
    private String nombreEd;
    @NotBlank
    private String descripcionEd;

    public EducacionDto() {
    }

    public EducacionDto(String nombreEd, String descripcionEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
    }

    public String getNombreEd() {
        return nombreEd;
    }

    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }

}
