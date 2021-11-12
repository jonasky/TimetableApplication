package de.hofuniversity.minf.stundenplaner.rest;

import de.hofuniversity.minf.stundenplaner.service.boundary.LectureService;
import de.hofuniversity.minf.stundenplaner.service.to.LectureTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lectures")
public class LectureController {

    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    public ResponseEntity<List<LectureTO>> getAllLectures() {
        return ResponseEntity.ok(lectureService.getAllLectures());
    }

    @PostMapping
    public ResponseEntity<LectureTO> createLecture(
            @RequestBody LectureTO lectureTO) {
        return ResponseEntity.status(201).body(lectureService.createLecture(lectureTO));
    }

    @GetMapping("/{lectureId}")
    public ResponseEntity<LectureTO> findById(
            @PathVariable("lectureId") Long lectureId
    ) {
        return ResponseEntity.ok(lectureService.findById(lectureId));
    }

    @PutMapping("/{lectureId}")
    public ResponseEntity<LectureTO> updateLecture(
            @PathVariable("lectureId") Long lectureId,
            @RequestBody LectureTO lectureTO,
            @RequestParam(value = "checkLessons", defaultValue = "true") Boolean checkLessons) {
        return ResponseEntity.ok(lectureService.updateLecture(lectureId, lectureTO, checkLessons));
    }

    @DeleteMapping("/{lectureId}")
    public ResponseEntity<LectureTO> deleteLecture(
            @PathVariable("lectureId") Long lectureId) {
        return ResponseEntity.ok(lectureService.removeLecture(lectureId));
    }

    @PostMapping("/{lectureId}/{lessonId}")
    public ResponseEntity<LectureTO> addLesson(
            @PathVariable("lectureId") Long lectureId,
            @PathVariable("lessonId") Long lessonId) {
        return ResponseEntity.ok(lectureService.addLesson(lectureId, lessonId));
    }

}