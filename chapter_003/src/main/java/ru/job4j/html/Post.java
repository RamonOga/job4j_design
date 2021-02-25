package ru.job4j.html;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private String href;
    private String description;
    private LocalDateTime createDate;

    public Post(String href, String description, LocalDateTime createDate) {
        this.href = href;
        this.description = description;
        this.createDate = createDate;
    }

    public String getHref() {
        return href;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Post{"
                + "href='" + href + '\''
                + ", description='" + description + '\''
                + ", createDate=" + createDate
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return Objects.equals(href, post.href)
                && Objects.equals(description, post.description)
                && Objects.equals(createDate, post.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, description, createDate);
    }
}
