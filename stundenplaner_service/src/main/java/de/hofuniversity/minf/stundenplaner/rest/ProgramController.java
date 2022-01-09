package de.hofuniversity.minf.stundenplaner.rest;

import de.hofuniversity.minf.stundenplaner.common.security.RequiredPermission;
import de.hofuniversity.minf.stundenplaner.persistence.permission.data.PermissionTypeEnum;
import de.hofuniversity.minf.stundenplaner.service.boundary.ProgramService;
import de.hofuniversity.minf.stundenplaner.service.to.ProgramTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("programs")
public class ProgramController {

    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    @RequiredPermission(PermissionTypeEnum.CAN_READ_PROGRAMS)
    public ResponseEntity<List<ProgramTO>> getAllPrograms() {
        return ResponseEntity.ok(programService.findAll());
    }

    @PostMapping
    @RequiredPermission(PermissionTypeEnum.CAN_CREATE_PROGRAMS)
    public ResponseEntity<ProgramTO> createProgram(@RequestBody ProgramTO programTo) {
        return ResponseEntity.status(201).body(programService.createProgram(programTo));
    }

    @GetMapping("/{id}")
    @RequiredPermission(PermissionTypeEnum.CAN_READ_PROGRAMS)
    public ResponseEntity<ProgramTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(programService.findById(id));
    }

    @PutMapping("/{id}")
    @RequiredPermission(PermissionTypeEnum.CAN_UPDATE_PROGRAMS)
    public ResponseEntity<ProgramTO> updateProgram(@PathVariable("id") Long id, @RequestBody ProgramTO programTo, @RequestParam(value = "checkSemesters", defaultValue = "true") Boolean checkSemesters) {
        return ResponseEntity.ok(programService.updateProgram(id, programTo, checkSemesters));
    }

    @DeleteMapping("/{id}")
    @RequiredPermission(PermissionTypeEnum.CAN_DELETE_PROGRAMS)
    public ResponseEntity<ProgramTO> deleteProgram(@PathVariable("id") Long id) {
        ProgramTO deleted = programService.removeProgram(id);
        return ResponseEntity.ok(deleted);
    }
}
