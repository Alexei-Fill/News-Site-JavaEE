package controller;

import DAO.NewsDAO;
import action.NewsRestService;
import entity.News;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/rest/news")
@Stateless
public class NewsRestController {

    @EJB
    NewsRestService newsRestService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<News> listNews() {
        return newsRestService.listNews();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public News getNewsById(@PathParam("id") long id) {
        return newsRestService.getNewsById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addNews(News news) {
        newsRestService.addNews(news);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateNews(News news) {
        newsRestService.updateNews(news);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteNews(Long[] id) {
        newsRestService.deleteNews(Arrays.asList(id));
    }
}
