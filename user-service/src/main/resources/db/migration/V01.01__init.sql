CREATE SEQUENCE user_seq;

CREATE TABLE application_user (
  id         BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('user_seq' :: regclass),
  first_name VARCHAR(255),
  last_name  VARCHAR(255),
  username   VARCHAR(255),
  password   VARCHAR(255)
);

CREATE SEQUENCE address_seq;
CREATE TABLE address (
  id       BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('address_seq' :: regclass),
  city     VARCHAR(255),
  street   VARCHAR(255),
  house    VARCHAR(255),
  flat     VARCHAR(255),
  zip_code VARCHAR(255)
);

CREATE TABLE user_address (
  user_id    BIGINT NOT NULL REFERENCES application_user(id),
  address_id BIGINT NOT NULL REFERENCES address(id),
  PRIMARY KEY (user_id, address_id)
);

CREATE SEQUENCE role_seq;
CREATE TABLE role (
  id   BIGINT      NOT NULL PRIMARY KEY DEFAULT nextval('role_seq'::regclass),
  name VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE user_roles (
  user_id  BIGINT NOT NULL REFERENCES application_user(id),
  roles_id BIGINT NOT NULL REFERENCES role(id),
  PRIMARY KEY (user_id, roles_id)
);