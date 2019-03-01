package DAO;

import entity.News;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NewsDAO {
    void addNews(News news);

    void updateNews(News news);

    List<News> listNews();

    News getNewsById(long Id);

    void deleteNews(long Id);
}
