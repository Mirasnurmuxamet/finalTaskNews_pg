CREATE TABLE t_permissions(
    id bigint auto_increment,
    role varchar(255),
    primary key (id)
);

CREATE TABLE t_users(
    id bigint auto_increment,
    email varchar(255),
    password varchar(255),
    full_name varchar(255),
    birthdate varchar(255),
    bio text,
    delete_application bit(1),
    primary key (id)
);

CREATE TABLE t_users_permissions(
    user_id bigint,
    permissions_id bigint
);

CREATE TABLE t_news_category(
    id bigint auto_increment,
    name varchar(255),
    primary key (id)
);

CREATE TABLE t_posts(
    id bigint auto_increment,
    title varchar(255),
    content text,
    post_time varchar(255),
    user_id bigint,
    news_category_id bigint,
    primary key (id)
);

CREATE TABLE t_comments(
    id bigint auto_increment,
    comment text,
    comment_time varchar(255),
    user_id bigint,
    post_id bigint,
    primary key (id)
);

ALTER TABLE t_users_permissions
    ADD CONSTRAINT fk_users_permissions_user
        FOREIGN KEY (user_id)
            REFERENCES t_users(id)
            ON DELETE CASCADE;

ALTER TABLE t_users_permissions
    ADD CONSTRAINT fk_users_permissions_permission
        FOREIGN KEY (permissions_id)
            REFERENCES t_permissions(id)
            ON DELETE CASCADE;


ALTER TABLE t_posts
    ADD CONSTRAINT fk_posts_user
        FOREIGN KEY (user_id)
            REFERENCES t_users(id)
            ON DELETE CASCADE;

ALTER TABLE t_posts
    ADD CONSTRAINT fk_posts_category
        FOREIGN KEY (news_category_id)
            REFERENCES t_news_category(id)
            ON DELETE CASCADE;


ALTER TABLE t_comments
    ADD CONSTRAINT fk_comments_user
        FOREIGN KEY (user_id)
            REFERENCES t_users(id)
            ON DELETE CASCADE;

ALTER TABLE t_comments
    ADD CONSTRAINT fk_comments_post
        FOREIGN KEY (post_id)
            REFERENCES t_posts(id)
            ON DELETE CASCADE;