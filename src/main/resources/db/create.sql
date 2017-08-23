SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS businesses (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  contact VARCHAR,
  hours VARCHAR,
  businesstype VARCHAR
)