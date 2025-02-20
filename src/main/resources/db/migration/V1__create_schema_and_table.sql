-- スキーマ作成
CREATE SCHEMA IF NOT EXISTS public;

-- テーブル作成
CREATE TABLE IF NOT EXISTS public.author (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL CHECK (birth_date < CURRENT_DATE)
);

CREATE TABLE IF NOT EXISTS public.book (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DECIMAL NOT NULL CHECK (price >= 0),
    publication_status VARCHAR(20) NOT NULL CHECK (publication_status IN ('未出版', '出版済み'))
);

-- 中間テーブル作成（書籍に複数の著者を持つため）
CREATE TABLE IF NOT EXISTS public.bookAuthor (
    book_id INT REFERENCES public.book(book_id) ON DELETE CASCADE,
    author_id INT REFERENCES public.author(author_id) ON DELETE CASCADE,
    PRIMARY KEY (book_id, author_id)
);
