package metube.service;

import metube.domain.entities.Tube;
import metube.domain.models.service.TubeServiceModel;
import metube.repository.TubeRepository;
import metube.util.ValidationUtil;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;

public class TubeServiceImpl implements TubeService {

    private final TubeRepository tubeRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, UserService userService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.tubeRepository = tubeRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean uploadTube(TubeServiceModel tubeServiceModel) {

        if(this.validationUtil.isValid(tubeServiceModel)){

            throw new IllegalArgumentException();

        }
        tubeServiceModel
                .setUploader(this.userService.findUserByUsername(tubeServiceModel.getUploader().getUsername()));

        try {
            this.tubeRepository.update(this.modelMapper.map(tubeServiceModel, Tube.class));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public TubeServiceModel findTubeById(String id) {
        Tube tube = this.tubeRepository.findById(id);

        if (tube == null) {
            throw new IllegalArgumentException();
        }

        return this.modelMapper.map(tube, TubeServiceModel.class);
    }

    @Override
    public List<Tube> findAllTubes() {
      return  this.tubeRepository.findAll();
    }
}
