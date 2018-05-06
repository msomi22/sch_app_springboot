
SET FOREIGN_KEY_CHECKS=0; -- to disable them

DROP TABLE IF EXISTS presentation;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_presentation;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user_role;

SET FOREIGN_KEY_CHECKS=1; -- to re-enable them

--
-- Table structure for table presentation
--

CREATE TABLE presentation (
  pre_no int(11) NOT NULL AUTO_INCREMENT,
  topic varchar(255) DEFAULT NULL,
  subject varchar(255) DEFAULT NULL,
  supervisor varchar(255) DEFAULT NULL,
  add_date timestamp DEFAULT current_timestamp, 
  PRIMARY KEY (pre_no)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Table structure for table user
--


CREATE TABLE user (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  is_active int(11) DEFAULT NULL,
  email varchar(255) NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Table structure for table user_presentation
--

CREATE TABLE user_presentation (
  user_id int(11) NOT NULL,
  pre_no int(11) NOT NULL,
  PRIMARY KEY (user_id,pre_no),
  FOREIGN KEY (user_id) REFERENCES user (user_id),
  FOREIGN KEY (pre_no) REFERENCES presentation (pre_no) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table role
--
CREATE TABLE role (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role varchar(255) DEFAULT NULL,
  PRIMARY KEY (role_id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



--
-- Table structure for table role
--
CREATE TABLE user_role (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  KEY `FKa68196081fvovjhkek5m97n3y` (role_id),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (user_id) REFERENCES user (user_id),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (role_id) REFERENCES role (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO role VALUES (1,'ADMIN');
INSERT INTO role VALUES (2,'USER'); 
 



-- sudo mysql --password 
-- create database unidb;

-- mysql -h localhost -u root -p unidb < db_structure.sql