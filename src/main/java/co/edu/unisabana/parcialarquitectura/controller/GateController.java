package co.edu.unisabana.parcialarquitectura.controller;


import co.edu.unisabana.parcialarquitectura.controller.dto.CheckpointDTO;
import co.edu.unisabana.parcialarquitectura.controller.dto.ResponseGate;
import co.edu.unisabana.parcialarquitectura.repository.jpa.CheckpointRepository;
import co.edu.unisabana.parcialarquitectura.service.CheckpointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateController {
  private final CheckpointRepository checkpointRepository;

  Logger logger = LoggerFactory.getLogger(GateController.class);

  public GateController(CheckpointRepository checkpointRepository, CheckpointService checkpointService) {
    this.checkpointRepository = checkpointRepository;
  }

  @PostMapping("/checkpoint/checkin")
  public ResponseGate checkin(@RequestBody CheckpointDTO checkpoint) {
    try {
      checkpointRepository.checkin(checkpoint);
      return new ResponseGate(true);
    } catch (Exception exception) {
      logger.error("Error in checkin", exception);
      return new ResponseGate(false);
    }
  }

}