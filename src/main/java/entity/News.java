package entity;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "NEWS")
@NamedNativeQueries( @NamedNativeQuery(name = "@INSERT_INTO_NEWS",
//        query = "insert into NEWS (NEWS_BRIEF, NEWS_CONTENT, NEWS_DATE, NEWS_TITLE ) values (:brief, :content, :date_news, :title)"))
        query = "insert into NEWS (NEWS_ID, NEWS_BRIEF, NEWS_CONTENT, NEWS_DATE, NEWS_TITLE ) values (NEWS_SEQUENCE.nextval, :brief, :content, :date_news, :title)"))
public class News implements Serializable {

    private long newsId;
    private String newsTitle;
    private LocalDate newsDate;
    private String newsBrief;
    private String newsContent;

    public News() {
    }

    @Id
    @Column(name = "NEWS_ID")
    @SequenceGenerator(name = "newsGenerator", sequenceName = "NEWS_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsGenerator")
    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "NEWS_TITLE")
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "NEWS_DATE")
    public LocalDate getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(LocalDate newsDate) {
        this.newsDate = newsDate;
    }

    @Basic
    @Column(name = "NEWS_BRIEF")
    public String getNewsBrief() {
        return newsBrief;
    }

    public void setNewsBrief(String newsBrief) {
        this.newsBrief = newsBrief;
    }

    @Basic
    @Column(name = "NEWS_CONTENT")
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return newsId == news.newsId &&
                Objects.equals(newsTitle, news.newsTitle) &&
                Objects.equals(newsDate, news.newsDate) &&
                Objects.equals(newsBrief, news.newsBrief) &&
                Objects.equals(newsContent, news.newsContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, newsTitle, newsDate, newsBrief, newsContent);
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsDate=" + newsDate +
                ", newsBrief='" + newsBrief + '\'' +
                ", newsContent='" + newsContent + '\'' +
                '}';
    }
}
