CREATE TABLE public.t_permissions (
                                      id bigserial PRIMARY KEY,
                                      role varchar(255)
);

ALTER TABLE public.t_permissions
    OWNER TO postgres;

create table public.t_users(
    id                 bigserial primary key,
    bio                text,
    birthdate          varchar(255),
    delete_application boolean,
    email              varchar(255),
    full_name          varchar(255),
    password           varchar(255)
);

alter table public.t_users
    owner to postgres;


create table public.t_users_permissions
(
    user_id bigint references t_users(id) on delete cascade,
    permissions_id bigint references t_permissions(id) on delete cascade

);

alter table public.t_users_permissions
    owner to postgres;


create table public.t_news_category(
    id   bigserial primary key,
    name varchar(255)
);

alter table public.t_news_category
    owner to postgres;



create table public.t_posts
(
                        id bigserial primary key,
                        title varchar(255),
                        content text,
                        post_time varchar(255),
                        user_id bigint references t_users(id) on delete cascade,
                        news_category_id bigint references t_news_category(id) on delete cascade
);

alter table public.t_posts
    owner to postgres;



create table public.t_comments(
                           id bigserial primary key,
                           comment text,
                           comment_time varchar(255),
                           user_id bigint references t_users(id) on delete cascade,
                           post_id bigint references t_posts(id) on delete cascade
);


alter table public.t_comments
    owner to postgres;

