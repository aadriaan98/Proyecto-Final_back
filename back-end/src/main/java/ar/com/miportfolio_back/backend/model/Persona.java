package ar.com.miportfolio_back.backend.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity

public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
    @NotNull
    private String edad;
    
    public Persona(){
    }
    
    public Persona(Long id, String nombre, String apellido, String edad ){
        this.id=id;
        this.nombre= nombre;
        this.apellido=apellido;
        this.edad=edad;
    }
}
