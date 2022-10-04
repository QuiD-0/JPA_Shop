package jpa.jpa_study.playGround;

import jpa.jpa_study.playGround.enumGround.Enums;
import jpa.jpa_study.playGround.timerAOP.ExeTimer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnumsController {

    @ExeTimer
    @GetMapping("/api/enums/1")
    public void findByEnumSet() {
        Enums.findByEnumSet();
    }

    @ExeTimer
    @GetMapping("/api/enums/2")
    public void findByValues() {
        Enums.findByValues();
    }

}
