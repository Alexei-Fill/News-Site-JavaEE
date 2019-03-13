package controller;

import action.NewsRestService;
import entity.DTONews;
import entity.News;
import security.CustomSecured;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Stateless
@WebService(
        portName = "NewsSOAPControllerPort",
        serviceName = "NewsSOAPControllerService",
        targetNamespace = "http://superbiz.org/wsdl",
        endpointInterface = "controller.NewsSOAP"
)
public class NewsSOAPController implements NewsSOAP {

    @EJB
    NewsRestService newsRestService;

    @Override
    public List<DTONews> listNews() {
        List<DTONews> list = new ArrayList<>();
        for(News news: newsRestService.listNews()){
            list.add(new DTONews(news));
        }
        return list ;
    }
    @Override
    public DTONews getNewsById(long id) {
        return new DTONews(newsRestService.getNewsById(id));
    }

    @Override
    public void addNews(DTONews news) {
        newsRestService.addNews(new News(news));
    }

    public void updateNews(DTONews news) {
        newsRestService.updateNews(new News(news));
    }

    @Override
    public void deleteNews(Long[] id) {
        newsRestService.deleteNews(Arrays.asList(id));
    }
}
