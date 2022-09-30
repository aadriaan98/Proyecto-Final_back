package ar.com.backendproyecto_final.back.controller;

import ar.com.backendproyecto_final.back.dto.SkillsDto;
import ar.com.backendproyecto_final.back.model.Skills;
import ar.com.backendproyecto_final.back.security.controller.Msj;
import ar.com.backendproyecto_final.back.service.SkillsService;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {

    @Autowired
    SkillsService skillsServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skillsServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!skillsServ.existsById(id)) {
            return new ResponseEntity(new Msj("no existe"), HttpStatus.NOT_FOUND);
        }
        Skills sk = skillsServ.getOne(id).get();
        return new ResponseEntity(sk, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillsServ.existsById(id)) {
            return new ResponseEntity(new Msj("no existe"), HttpStatus.NOT_FOUND);
        }
        skillsServ.delete(id);
        return new ResponseEntity(new Msj("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillsDto skillsDto) {
        if (StringUtils.isBlank(skillsDto.getNombreS())) {
            return new ResponseEntity(new Msj("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillsServ.existsByNombreS(skillsDto.getNombreS())) {
            return new ResponseEntity(new Msj("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skills sk = new Skills(skillsDto.getNombreS(), skillsDto.getPorcentaje());
        skillsServ.save(sk);

        return new ResponseEntity(new Msj("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillsDto skillsDto) {

        if (!skillsServ.existsById(id)) {
            return new ResponseEntity(new Msj("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (skillsServ.existsByNombreS(skillsDto.getNombreS()) && skillsServ.getByNombreS(skillsDto.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Msj("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(skillsDto.getNombreS())) {
            return new ResponseEntity(new Msj("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills sk = skillsServ.getOne(id).get();
        sk.setNombreS(skillsDto.getNombreS());
        sk.setPorcentaje(skillsDto.getPorcentaje());

        skillsServ.save(sk);
        return new ResponseEntity(new Msj("Skill actualizada"), HttpStatus.OK);

    }
}
