/*
 * This file is generated by jOOQ.
 */
package com.example.generated.tables;


import com.example.generated.Keys;
import com.example.generated.Public;
import com.example.generated.tables.Author.AuthorPath;
import com.example.generated.tables.Book.BookPath;
import com.example.generated.tables.records.BookauthorRecord;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Bookauthor extends TableImpl<BookauthorRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.bookauthor</code>
     */
    public static final Bookauthor BOOKAUTHOR = new Bookauthor();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookauthorRecord> getRecordType() {
        return BookauthorRecord.class;
    }

    /**
     * The column <code>public.bookauthor.book_id</code>.
     */
    public final TableField<BookauthorRecord, Integer> BOOK_ID = createField(DSL.name("book_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.bookauthor.author_id</code>.
     */
    public final TableField<BookauthorRecord, Integer> AUTHOR_ID = createField(DSL.name("author_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private Bookauthor(Name alias, Table<BookauthorRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Bookauthor(Name alias, Table<BookauthorRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.bookauthor</code> table reference
     */
    public Bookauthor(String alias) {
        this(DSL.name(alias), BOOKAUTHOR);
    }

    /**
     * Create an aliased <code>public.bookauthor</code> table reference
     */
    public Bookauthor(Name alias) {
        this(alias, BOOKAUTHOR);
    }

    /**
     * Create a <code>public.bookauthor</code> table reference
     */
    public Bookauthor() {
        this(DSL.name("bookauthor"), null);
    }

    public <O extends Record> Bookauthor(Table<O> path, ForeignKey<O, BookauthorRecord> childPath, InverseForeignKey<O, BookauthorRecord> parentPath) {
        super(path, childPath, parentPath, BOOKAUTHOR);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class BookauthorPath extends Bookauthor implements Path<BookauthorRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> BookauthorPath(Table<O> path, ForeignKey<O, BookauthorRecord> childPath, InverseForeignKey<O, BookauthorRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private BookauthorPath(Name alias, Table<BookauthorRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public BookauthorPath as(String alias) {
            return new BookauthorPath(DSL.name(alias), this);
        }

        @Override
        public BookauthorPath as(Name alias) {
            return new BookauthorPath(alias, this);
        }

        @Override
        public BookauthorPath as(Table<?> alias) {
            return new BookauthorPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<BookauthorRecord> getPrimaryKey() {
        return Keys.BOOKAUTHOR_PKEY;
    }

    @Override
    public List<ForeignKey<BookauthorRecord, ?>> getReferences() {
        return Arrays.asList(Keys.BOOKAUTHOR__BOOKAUTHOR_AUTHOR_ID_FKEY, Keys.BOOKAUTHOR__BOOKAUTHOR_BOOK_ID_FKEY);
    }

    private transient AuthorPath _author;

    /**
     * Get the implicit join path to the <code>public.author</code> table.
     */
    public AuthorPath author() {
        if (_author == null)
            _author = new AuthorPath(this, Keys.BOOKAUTHOR__BOOKAUTHOR_AUTHOR_ID_FKEY, null);

        return _author;
    }

    private transient BookPath _book;

    /**
     * Get the implicit join path to the <code>public.book</code> table.
     */
    public BookPath book() {
        if (_book == null)
            _book = new BookPath(this, Keys.BOOKAUTHOR__BOOKAUTHOR_BOOK_ID_FKEY, null);

        return _book;
    }

    @Override
    public Bookauthor as(String alias) {
        return new Bookauthor(DSL.name(alias), this);
    }

    @Override
    public Bookauthor as(Name alias) {
        return new Bookauthor(alias, this);
    }

    @Override
    public Bookauthor as(Table<?> alias) {
        return new Bookauthor(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bookauthor rename(String name) {
        return new Bookauthor(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bookauthor rename(Name name) {
        return new Bookauthor(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bookauthor rename(Table<?> name) {
        return new Bookauthor(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Bookauthor where(Condition condition) {
        return new Bookauthor(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Bookauthor where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Bookauthor where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Bookauthor where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Bookauthor where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Bookauthor where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Bookauthor where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Bookauthor where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Bookauthor whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Bookauthor whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
