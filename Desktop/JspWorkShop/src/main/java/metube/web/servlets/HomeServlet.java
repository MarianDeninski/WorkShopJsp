package metube.web.servlets;

import metube.domain.models.view.AllVideosViewModel;
import metube.service.TubeService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public HomeServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AllVideosViewModel allVideosViewModel = new AllVideosViewModel();
        allVideosViewModel.setTubes(this.tubeService.findAllTubes());
        req.setAttribute("allVideos",allVideosViewModel);

        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }
}
