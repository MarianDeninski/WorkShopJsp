package metube.domain.models.view;

import metube.domain.entities.Tube;

import java.util.List;

public class AllVideosViewModel {

    private List<Tube> tubes;


    public AllVideosViewModel() {
    }

    public List<Tube> getTubes() {
        return tubes;
    }

    public void setTubes(List<Tube> tubes) {
        this.tubes = tubes;
    }
}
