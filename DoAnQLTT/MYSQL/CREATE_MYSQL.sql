-- Drop and recreate the database
DROP DATABASE IF EXISTS QLTT;
CREATE DATABASE QLTT;
USE QLTT;

-- Create tables within the database
CREATE TABLE Country (
    country_id VARCHAR(3) PRIMARY KEY,
    country_name VARCHAR(100) NOT NULL
);

CREATE TABLE City (
    city_id BIGINT PRIMARY KEY,
    city_name VARCHAR(50) NOT NULL,
    country_id VARCHAR(3) NOT NULL,
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES Country(country_id)
);

CREATE TABLE WeatherCondition (
    weather_condition_id INT PRIMARY KEY,
    main VARCHAR(50),
    weather_description VARCHAR(100)
);

CREATE TABLE DailyForecast (
    daily_forecast_id INT PRIMARY KEY AUTO_INCREMENT,
    weather_condition_id INT NOT NULL,
    city_id BIGINT NOT NULL,
    df_date BIGINT NOT NULL,
    icon VARCHAR(5) NOT NULL,
    sunrise BIGINT NOT NULL,
    sunset BIGINT NOT NULL,
    moonrise BIGINT NOT NULL,
    moonset BIGINT NOT NULL,
    summary VARCHAR(100),
    temperature_max FLOAT NOT NULL,
    temperature_min FLOAT NOT NULL,
    temperature_morn FLOAT NOT NULL,
    temperature_day FLOAT NOT NULL,
    temperature_eve FLOAT NOT NULL,
    temperature_night FLOAT NOT NULL,
    feels_like_morn FLOAT NOT NULL,
    feels_like_day FLOAT NOT NULL,
    feels_like_eve FLOAT NOT NULL,
    feels_like_night FLOAT NOT NULL,
    pressure INT NOT NULL,
    humidity INT NOT NULL,
    wind_speed FLOAT NOT NULL,
    clouds INT NOT NULL,
    uv FLOAT NOT NULL,
    pop FLOAT NOT NULL,
    aqi INT NOT NULL,
    FOREIGN KEY (weather_condition_id) REFERENCES WeatherCondition(weather_condition_id),
    FOREIGN KEY (city_id) REFERENCES City(city_id)
);

CREATE TABLE CurrentWeather (
    current_weather_id INT PRIMARY KEY AUTO_INCREMENT,
    city_id BIGINT NOT NULL UNIQUE,
    weather_condition_id INT NOT NULL,
    cur_timestamp BIGINT NOT NULL,
    icon VARCHAR(5) NOT NULL,
    temperature FLOAT NOT NULL,
    feels_like FLOAT NOT NULL,
    pressure INT NOT NULL,
    humidity INT NOT NULL,
    clouds INT NOT NULL,
    uv FLOAT NOT NULL,
    visibility INT NOT NULL,
    wind_speed FLOAT NOT NULL,
    aqi INT NOT NULL,
    FOREIGN KEY (weather_condition_id) REFERENCES WeatherCondition(weather_condition_id),
    FOREIGN KEY (city_id) REFERENCES City(city_id)
);

CREATE TABLE NguoiDung (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(25) NOT NULL UNIQUE,
    Email VARCHAR(60) NOT NULL,
    Password VARCHAR(128) NOT NULL,
    VerifyCode VARCHAR(50),
    current_city_fk BIGINT NULL,
    hashSalt VARCHAR(25),
    nd_language VARCHAR(25) NOT NULL DEFAULT 'en',
    measurement_type VARCHAR(10) NOT NULL DEFAULT 'Metric',
    utc INT NULL,
    Status VARCHAR(50),
    Role INT NOT NULL DEFAULT 0,
    FOREIGN KEY (current_city_fk) REFERENCES City(city_id)
);

CREATE TABLE HourlyForecast (
    hourly_forecast_id INT PRIMARY KEY AUTO_INCREMENT,
    weather_condition_id INT NOT NULL,
    city_id BIGINT NOT NULL,
    hf_timestamp BIGINT NOT NULL,
    icon VARCHAR(5) NOT NULL,
    temperature FLOAT NOT NULL,
    feels_like FLOAT NOT NULL,
    pressure INT NOT NULL,
    humidity INT NOT NULL,
    clouds INT NOT NULL,
    uv FLOAT NOT NULL,
    visibility INT NOT NULL,
    wind_speed FLOAT NOT NULL,
    pop FLOAT NOT NULL,
    aqi INT NOT NULL,
    FOREIGN KEY (weather_condition_id) REFERENCES WeatherCondition(weather_condition_id),
    FOREIGN KEY (city_id) REFERENCES City(city_id)
);

CREATE TABLE UserAlertType (
    alert_type_id INT PRIMARY KEY,
    alert_description VARCHAR(100) NOT NULL
);

CREATE TABLE UserAlert (
    user_alert_id INT PRIMARY KEY AUTO_INCREMENT,
    nd_id INT NOT NULL,
    alert_type_id INT NOT NULL,
    city_id BIGINT NOT NULL,
    condition_type CHAR(1) NOT NULL,
    alert_value FLOAT NOT NULL,
    comment VARCHAR(255),
    activated TINYINT NOT NULL DEFAULT 0,
    FOREIGN KEY (nd_id) REFERENCES NguoiDung(UserID),
    FOREIGN KEY (alert_type_id) REFERENCES UserAlertType(alert_type_id),
    FOREIGN KEY (city_id) REFERENCES City(city_id)
);

CREATE TABLE UserAlertHistory (
    history_id INT PRIMARY KEY AUTO_INCREMENT,
    nd_id INT NOT NULL,
    city_id BIGINT NOT NULL,
    condition_type CHAR(1) NOT NULL,
    alert_value FLOAT NOT NULL,
    comment VARCHAR(255),
    timeframe VARCHAR(10) NOT NULL, -- DAILY / HOURLY
    activation_time DATETIME NOT NULL,
    FOREIGN KEY (nd_id) REFERENCES NguoiDung(UserID),
    FOREIGN KEY (city_id) REFERENCES City(city_id)
);


