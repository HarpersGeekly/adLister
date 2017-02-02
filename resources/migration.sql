create DATABASE if NOT EXISTS adlister_db;

use adlister_db;

create table if not exists ads (
  id int UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(400) NOT NULL,
  description TEXT,
  PRIMARY KEY (id)
);
