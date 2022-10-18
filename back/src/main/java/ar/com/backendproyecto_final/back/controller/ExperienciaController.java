package ar.com.backendproyecto_final.back.controller;

import ar.com.backendproyecto_final.back.dto.ExperienciaDto;
import ar.com.backendproyecto_final.back.model.Experiencia;
import ar.com.backendproyecto_final.back.security.controller.Msj;
import ar.com.backendproyecto_final.back.service.ExperienciaService;
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
@RequestMapping("/experiencia-laboral")
@CrossOrigin(origins = "https://front-portfolio-adrian.web.app")
public class ExperienciaController {

    @Autowired
    ExperienciaService expServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = expServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!expServ.existById(id)) {
            return new ResponseEntity(new Msj("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia exp = expServ.getOne(id).get();
        return new ResponseEntity(exp, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto expDto) {
        if (StringUtils.isBlank(expDto.getNombreExp())) {
            return new ResponseEntity(new Msj("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (expServ.existByNombreExp(expDto.getNombreExp())) {
            return new ResponseEntity(new Msj("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia exp = new Experiencia(expDto.getNombreExp(), expDto.getDescripcionExp());
        expServ.save(exp);

        return new ResponseEntity(new Msj("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto expDto) {
        if (!expServ.existById(id)) {
            return new ResponseEntity(new Msj("Esa Id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (expServ.existByNombreExp(expDto.getNombreExp()) && expServ.getByNombreExp(expDto.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Msj("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(expDto.getNombreExp())) {
            return new ResponseEntity(new Msj("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia exp = expServ.getOne(id).get();
        exp.setNombreExp(expDto.getNombreExp());
        exp.setDescripcionExp(expDto.getDescripcionExp());

        expServ.save(exp);
        return new ResponseEntity(new Msj("Experiencia actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expServ.existById(id)) {
            return new ResponseEntity(new Msj("no existe"), HttpStatus.NOT_FOUND);
        }

        expServ.delete(id);
        return new ResponseEntity(new Msj("Experiencia eliminada"), HttpStatus.OK);
    }
}
