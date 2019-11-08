USE `db_appbase`;

INSERT INTO role (id, user_role) VALUES (1,'ROLE_ADMIN');
INSERT INTO role (id, user_role) VALUES (2,'ROLE_USER');
INSERT INTO role (id, user_role) VALUES (3,'ROLE_ANONYMOUS');

INSERT INTO user (id, email, first_name, last_name, birthdate, phone, password) 
VALUES (1,'admin@admin.com','Admin','Admin',DATE('1977-12-31'),666666666,'$2a$10$7NEAHCDpKuCHnH48rCES4uNX2bpIKr4LncLKidTer35OY9ccOm6qe');
INSERT INTO user (id, email, first_name, last_name, birthdate, phone, password) 
VALUES (2,'user@user.es','User','User',NULL,999999999,'$2a$10$Dn3daJ.vZL5Rcr978Ms23eKg68Sctig1fWxKLYKh1gpbDTy9HY8n6');
INSERT INTO user (id, email, first_name, last_name, birthdate, phone, password) 
VALUES (3,'anonymous@anonymous.cat','Anonymous','Anonymous',DATE('1985-03-31'),555555555,'$2a$10$Bi58zCo60NaPoHfxhsJCieakKhUqGfzrbpnOTXv4Ey/gzmFl5NDQ2');

INSERT INTO user_role (user_id, role_id) VALUES (1,1);
INSERT INTO user_role (user_id, role_id) VALUES (1,2);
INSERT INTO user_role (user_id, role_id) VALUES (2,2);
INSERT INTO user_role (user_id, role_id) VALUES (3,3);