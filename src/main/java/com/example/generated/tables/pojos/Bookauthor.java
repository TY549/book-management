/*
 * This file is generated by jOOQ.
 */
package com.example.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Bookauthor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bookId;
    private Integer authorId;

    public Bookauthor() {}

    public Bookauthor(Bookauthor value) {
        this.bookId = value.bookId;
        this.authorId = value.authorId;
    }

    public Bookauthor(
        Integer bookId,
        Integer authorId
    ) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    /**
     * Getter for <code>public.bookauthor.book_id</code>.
     */
    public Integer getBookId() {
        return this.bookId;
    }

    /**
     * Setter for <code>public.bookauthor.book_id</code>.
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * Getter for <code>public.bookauthor.author_id</code>.
     */
    public Integer getAuthorId() {
        return this.authorId;
    }

    /**
     * Setter for <code>public.bookauthor.author_id</code>.
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Bookauthor other = (Bookauthor) obj;
        if (this.bookId == null) {
            if (other.bookId != null)
                return false;
        }
        else if (!this.bookId.equals(other.bookId))
            return false;
        if (this.authorId == null) {
            if (other.authorId != null)
                return false;
        }
        else if (!this.authorId.equals(other.authorId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.bookId == null) ? 0 : this.bookId.hashCode());
        result = prime * result + ((this.authorId == null) ? 0 : this.authorId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bookauthor (");

        sb.append(bookId);
        sb.append(", ").append(authorId);

        sb.append(")");
        return sb.toString();
    }
}
