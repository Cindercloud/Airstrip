CREATE TABLE feature (
    id             BIGINT(20)   NOT NULL AUTO_INCREMENT,
    name           VARCHAR(150) NOT NULL,
    description    varchar(255)                  DEFAULT NULL,
    active         BOOL                  DEFAULT FALSE,
    application_id BIGINT(20)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (application_id) REFERENCES application (id)
);
