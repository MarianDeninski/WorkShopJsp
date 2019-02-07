package metube.service;

import metube.domain.entities.Tube;
import metube.domain.models.service.TubeServiceModel;

import java.util.List;

public interface TubeService {

    boolean uploadTube(TubeServiceModel tubeServiceModel);

    TubeServiceModel findTubeById(String id);

    List<Tube> findAllTubes();
}
