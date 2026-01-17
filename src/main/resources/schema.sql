/*-- ユーザー
CREATE TABLE app_users (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           user_name VARCHAR(50) NOT NULL
);

-- KGI
CREATE TABLE kgi (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     user_id INT NOT NULL,
                     title VARCHAR(100) NOT NULL,
                     target_value INT NOT NULL
);

-- KPI
CREATE TABLE kpi (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     kgi_id INT NOT NULL,
                     title VARCHAR(100) NOT NULL,
                     target_value INT NOT NULL
);

-- KPI実績
CREATE TABLE kpi_record (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            kpi_id INT NOT NULL,
                            record_date DATE NOT NULL,
                            actual_value INT NOT NULL
);

-- リレーション
ALTER TABLE kgi
    ADD CONSTRAINT fk_kgi_user
        FOREIGN KEY (user_id)
            REFERENCES app_users(id);

ALTER TABLE kpi
    ADD CONSTRAINT fk_kpi_kgi
        FOREIGN KEY (kgi_id)
            REFERENCES kgi(id);

ALTER TABLE kpi_record
    ADD CONSTRAINT fk_record_kpi
        FOREIGN KEY (kpi_id)
            REFERENCES kpi(id);
*/