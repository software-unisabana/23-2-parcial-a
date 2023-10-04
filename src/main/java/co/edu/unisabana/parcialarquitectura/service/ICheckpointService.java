package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.CheckpointPort;
import co.edu.unisabana.parcialarquitectura.service.model.Checkin;

public interface ICheckpointService {
    CheckpointPort checkpointPort = new CheckpointPort() {
        @Override
        public void saveCheckin(Checkin checkin) {

        }
    };
}
