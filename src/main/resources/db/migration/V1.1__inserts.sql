--
insert into institution (id, name, email, site, local, create_by, created_date) values (1, 'UaiJUG', 'uaijug@localhost.com','www.uaijug.com.br', 'virtual', 'uaijug@localhost.com', '2012-03-16 17:05:41.136');

insert into event_category (id, name, create_by, created_date) values (1, 'Workshop', 'uaijug@localhost.com', '2012-03-16 17:05:41.136');

insert into news (id, title, description, institution_id, author, create_by, created_date) values (1, 'news1', 'nononono', 1, 'rogeriofontes', 'uaijug@localhost.com', '2012-03-16 17:05:41.136');

insert into room (id, name, institution_id, create_by, created_date) values (1, '50-4', 1, 'uaijug@localhost.com', '2012-03-16 17:05:41.136');

insert into event (id, institution_id, name, event_category_id, start_date, end_date, local, description, create_by, created_date) values (1, 1, 'Worksho-github', 1, '2012-03-16 17:05:41.136', '2016-03-16 17:05:41.136', 'UFU', 'nononono', 'uaijug@localhost.com', '2012-03-16 17:05:41.136');

insert into session (id, name, description, event_id, room_id, start_date, end_date, create_by, created_date) values (1, 'curso git', 'nononono', 1, 1, '2012-03-16 17:05:41.136', '2012-03-16 17:05:41.136', 'uaijug@localhost.com', '2012-03-16 17:05:41.136');

insert into speaker (id, name, email, twitter, linkedin, curriculum, create_by, created_date) values (1, 'Rogerio', 'rogerio@localhost', '@rogeriofontes', 'linkedin', 'curriculum', 'uaijug@localhost.com', '2012-03-16 17:05:41.136');