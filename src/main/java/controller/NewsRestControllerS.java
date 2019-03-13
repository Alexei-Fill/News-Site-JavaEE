package controller;

import entity.DTONews;
import entity.News;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Path("/soap")
@Stateless
public class NewsRestControllerS {
    Service service;
    NewsSOAP soap;
    public NewsRestControllerS() throws MalformedURLException {
        service = Service.create( new URL("http://localhost:8282/EjEx2/NewsSOAPControllerService/NewsSOAPController?Wsdl"),
                new QName("http://news.org/wsdl", "NewsSOAPControllerService"));
        soap = service.getPort(NewsSOAP.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DTONews> listNews() {
        return soap.listNews();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public News getNewsById(@PathParam("id") long id) {
        return new News(soap.getNewsById(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addNews(DTONews news) {
        soap.addNews(news);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateNews(DTONews news) {
        soap.updateNews(news);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteNews(Long[] id) {
        soap.deleteNews(id);
    }
}
