package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.controller.dto.CheckpointDTO;
import co.edu.unisabana.parcialarquitectura.controller.dto.ResponseGate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
public class GateControllerTest {
        @Autowired
        TestRestTemplate rest;
        @Test
        void Dado_CheckpointDTO_Cuando_CheckinValido_Entonces_true(){
            CheckpointDTO dto = new CheckpointDTO("Prueba","Pruba",1);
            ResponseEntity<ResponseGate> res = rest.postForEntity("/checkpoint/checkin", dto,
            ResponseGate.class);
            Assertions.assertTrue(res.getBody().transactionResult);
        }
    @Test
    void Dado_CheckpointDTO_Cuando_CheckinInvalido_Entonces_false(){
        CheckpointDTO dto = new CheckpointDTO("Prueba","Pruba",32);
        ResponseEntity<ResponseGate> res = rest.postForEntity("/checkpoint/checkin", dto,
                ResponseGate.class);
        Assertions.assertFalse(res.getBody().transactionResult);
    }
}
