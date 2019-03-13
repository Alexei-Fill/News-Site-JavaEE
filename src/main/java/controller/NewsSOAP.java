package controller;

import entity.DTONews;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://news.org/wsdl")
public interface NewsSOAP {
    List<DTONews> listNews();

    DTONews getNewsById(long id);

    void addNews(DTONews news);

    void updateNews(DTONews news);

    void deleteNews(Long[] id);
}
