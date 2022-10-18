package ar.com.backendproyecto_final.back.controller;

import ar.com.backendproyecto_final.back.dto.EducacionDto;
import ar.com.backendproyecto_final.back.model.Educacion;
import ar.com.backendproyecto_final.back.security.controller.Msj;
import ar.com.backendproyecto_final.back.service.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://front-portfolio-adrian.web.app")
public class EducacionController {

    @Autowired
    EducacionService eduServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = eduServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!eduServ.existsById(id)) {
            return new ResponseEntity(new Msj("no existe esa id"), HttpStatus.BAD_REQUEST);
        }
        Educacion edu = eduServ.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!eduServ.existsById(id)) {
            return new ResponseEntity(new Msj("no existe esa id"), HttpStatus.NOT_FOUND);
        }
        eduServ.delete(id);
        return new ResponseEntity(new Msj("educacion eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducacionDto edDto) {
        if (StringUtils.isBlank(edDto.getNombreEd())) {
            return new ResponseEntity(new Msj("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (eduServ.existsByNombreEd(edDto.getNombreEd())) {
            return new ResponseEntity(new Msj("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion edu = new Educacion(edDto.getNombreEd(), edDto.getDescripcionEd());

        eduServ.save(edu);

        return new ResponseEntity(new Msj("educacion creada con exito"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducacionDto edDto) {
        if (!eduServ.existsById(id)) {
            return new ResponseEntity(new Msj("no existe esa id"), HttpStatus.NOT_FOUND);
        }
        if (eduServ.existsByNombreEd(edDto.getNombreEd()) && eduServ.getByNombreEd(edDto.getNombreEd()).get().getId() != id) {
            return new ResponseEntity(new Msj("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(edDto.getNombreEd())) {
            return new ResponseEntity(new Msj("el campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Educacion edu = eduServ.getOne(id).get();
        edu.setNombreEd(edDto.getNombreEd());
        edu.setDescripcionEd(edDto.getDescripcionEd());

        eduServ.save(edu);

        return new ResponseEntity(new Msj("educacion modificada con exito"), HttpStatus.OK);
    }
}
