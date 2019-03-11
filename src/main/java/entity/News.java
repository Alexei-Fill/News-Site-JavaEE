package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import util.LocalDateDeserializer;
import util.LocalDateSerialaizer;

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

    private long id;
    private String title;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerialaizer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;
    private String brief;
    private String content;

    public News() {
    }

    @Id
    @Column(name = "NEWS_ID")
    @SequenceGenerator(name = "newsGenerator", sequenceName = "NEWS_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsGenerator")
    public long getId() {
        return id;
    }

    public void setId(long newsId) {
        this.id = newsId;
    }

    @Basic
    @Column(name = "NEWS_TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String newsTitle) {
        this.title = newsTitle;
    }

    @Basic
    @Column(name = "NEWS_DATE")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate newsDate) {
        this.date = newsDate;
    }

    @Basic
    @Column(name = "NEWS_BRIEF")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String newsBrief) {
        this.brief = newsBrief;
    }

    @Basic
    @Column(name = "NEWS_CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String newsContent) {
        this.content = newsContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(title, news.title) &&
                Objects.equals(date, news.date) &&
                Objects.equals(brief, news.brief) &&
                Objects.equals(content, news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, brief, content);
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + id +
                ", newsTitle='" + title + '\'' +
                ", newsDate=" + date +
                ", newsBrief='" + brief + '\'' +
                ", newsContent='" + content + '\'' +
                '}';
    }
}
