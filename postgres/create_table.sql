CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS app_user (
  username varchar(45) NOT NULL,
  password varchar(450) NOT NULL,
  enabled integer NOT NULL DEFAULT '1',
  PRIMARY KEY (username)
);

create table  IF NOT EXISTS test2 (
id uuid NOT NULL DEFAULT uuid_generate_v4() ,
info jsonb not null
);

select *
from test2;