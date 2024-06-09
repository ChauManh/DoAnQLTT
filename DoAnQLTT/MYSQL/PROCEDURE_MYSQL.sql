-- Procedure to calculate average temperature and rain probability for the next X hours
USE
    QLTT;
DELIMITER
    //
    -- Drop the procedure if it already exists
-- Drop the procedure if it already exists
DROP PROCEDURE IF EXISTS AverageTemperatureNextXHours //
DELIMITER
//
-- Create the procedure
CREATE PROCEDURE AverageTemperatureNextXHours(IN cityID BIGINT, IN X INT)
BEGIN
    SELECT
        AVG(temperature) AS AvgTemperature
    FROM
        HourlyForecast
    WHERE
        city_id = cityID AND TIMESTAMPDIFF(
            HOUR,
            NOW(), HOUR(FROM_UNIXTIME(hf_timestamp))) <= X;
END //
DELIMITER //

-- Drop the procedure if it already exists
DROP PROCEDURE IF EXISTS AverageRainProbabilityNextXHours //

DELIMITER //
-- Create the procedure
CREATE PROCEDURE AverageRainProbabilityNextXHours(IN cityID BIGINT, IN X INT)
BEGIN
    SELECT
        AVG(pop) AS AvgRainProbability
    FROM
        HourlyForecast
    WHERE
        city_id = cityID AND TIMESTAMPDIFF(
            HOUR,
            NOW(), HOUR(FROM_UNIXTIME(hf_timestamp))) <= X;
END //
DELIMITER // 

DELIMITER
    //
    -- Drop the procedure if it already exists
DROP PROCEDURE IF EXISTS AverageAQINextXHours //
DELIMITER
    //
    -- Create the procedure
    CREATE PROCEDURE AverageAQINextXHours(IN cityID BIGINT, IN X INT)
BEGIN
    SELECT
        AVG(aqi) AS AvgAQI
    FROM
        HourlyForecast
    WHERE
        city_id = cityID AND TIMESTAMPDIFF(
            HOUR,
            NOW(), HOUR(FROM_UNIXTIME(hf_timestamp))) <= X ;
        END //
    DELIMITER
        ;
        -- Procedure to calculate average humidity for the next X hours
DELIMITER
    //
    -- Drop the procedure if it already exists
DROP PROCEDURE IF EXISTS AverageHumidityNextXHours //
DELIMITER
    //
    -- Create the procedure
    CREATE PROCEDURE AverageHumidityNextXHours(IN cityID BIGINT, IN X INT)
BEGIN
    SELECT
        AVG(humidity) AS AvgHumidity
    FROM
        HourlyForecast
    WHERE
        city_id = cityID AND TIMESTAMPDIFF(
            HOUR,
            NOW(), HOUR(FROM_UNIXTIME(hf_timestamp))) <= X ;
        END //
    DELIMITER
        ;
        -- Procedure to calculate average UV index for the next X days
DELIMITER
    //
    -- Drop the procedure if it already exists
DROP PROCEDURE IF EXISTS AverageUVNextXDays //
DELIMITER
    //
    -- Create the procedure
    CREATE PROCEDURE AverageUVNextXDays(IN cityID BIGINT, IN X INT)
BEGIN
    SELECT
        AVG(uv) AS AvgUV
    FROM
        DailyForecast
    WHERE
        city_id = cityID AND DATEDIFF(NOW(), DAY(FROM_UNIXTIME(df_date))) <= X ;
        END //
    DELIMITER
        ;
        -- Procedure to calculate average temperature for the next X days
DELIMITER
    //
    -- Drop the procedure if it already exists
DROP PROCEDURE IF EXISTS AverageTemperatureNextXDays //
DELIMITER
    //
    -- Create the procedure
    CREATE PROCEDURE AverageTemperatureNextXDays(IN cityID BIGINT, IN X INT)
BEGIN
    SELECT
        AVG(
            (
                temperature_max + temperature_min
            ) / 2
        ) AS AvgTemperature
    FROM
        DailyForecast
    WHERE
        city_id = cityID AND DATEDIFF(NOW(), DAY(FROM_UNIXTIME(df_date))) <= X ;
        END //
    DELIMITER
        ;
        -- Procedure to calculate average AQI for the next X days
DELIMITER
    //
    -- Drop the procedure if it already exists
DROP PROCEDURE IF EXISTS AverageAQINextXDays //
DELIMITER
    //
    -- Create the procedure
    CREATE PROCEDURE AverageAQINextXDays(IN cityID BIGINT, IN X INT)
BEGIN
    SELECT
        AVG(aqi) AS AvgAQI
    FROM
        DailyForecast
    WHERE
        city_id = cityID AND DATEDIFF(NOW(), DAY(FROM_UNIXTIME(df_date))) <= X ;
        END //
    DELIMITER
        ;
        -- Procedure to calculate average humidity for the next X days
DELIMITER
    //
    -- Drop the procedure if it already exists
DROP PROCEDURE IF EXISTS AverageHumidityNextXDays //
DELIMITER
    //
    -- Create the procedure
    CREATE PROCEDURE AverageHumidityNextXDays(IN cityID BIGINT, IN X INT)
BEGIN
    SELECT
        AVG(humidity) AS AvgHumidity
    FROM
        DailyForecast
    WHERE
        city_id = cityID AND DATEDIFF(NOW(), DAY(FROM_UNIXTIME(df_date))) <= X ;
        END //

DELIMITER //

DROP PROCEDURE IF EXISTS UpdateCurrentWeather //

DELIMITER //

CREATE PROCEDURE UpdateCurrentWeather(
    IN p_city_id BIGINT,
    IN p_weather_condition_id INT,
    IN p_cur_timestamp BIGINT,
    IN p_icon VARCHAR(5),
    IN p_temperature FLOAT,
    IN p_feels_like FLOAT,
    IN p_pressure INT,
    IN p_humidity INT,
    IN p_clouds INT,
    IN p_uv FLOAT,
    IN p_visibility INT,
    IN p_wind_speed FLOAT,
    IN p_aqi INT
)
BEGIN
    DECLARE existing_timestamp BIGINT;
    
    -- Lấy timestamp hiện tại của city
    SELECT cur_timestamp INTO existing_timestamp
    FROM CurrentWeather
    WHERE city_id = p_city_id;

    -- Kiểm tra nếu timestamp mới khác với timestamp hiện tại
    IF existing_timestamp IS NULL OR existing_timestamp < p_cur_timestamp THEN
        UPDATE CurrentWeather
        SET
            weather_condition_id = p_weather_condition_id,
            cur_timestamp = p_cur_timestamp,
            icon = p_icon,
            temperature = p_temperature,
            feels_like = p_feels_like,
            pressure = p_pressure,
            humidity = p_humidity,
            clouds = p_clouds,
            uv = p_uv,
            visibility = p_visibility,
            wind_speed = p_wind_speed,
            aqi = p_aqi
        WHERE city_id = p_city_id;
    END IF;
END//

DELIMITER //

DROP PROCEDURE IF EXISTS UpdateDailyForecast //
DELIMITER //

CREATE PROCEDURE UpdateDailyForecast(
    IN p_city_id BIGINT,
    IN p_df_date BIGINT,
    IN p_weather_condition_id INT,
    IN p_icon VARCHAR(5),
    IN p_sunrise BIGINT,
    IN p_sunset BIGINT,
    IN p_moonrise BIGINT,
    IN p_moonset BIGINT,
    IN p_summary VARCHAR(100),
    IN p_temperature_max FLOAT,
    IN p_temperature_min FLOAT,
    IN p_temperature_morn FLOAT,
    IN p_temperature_day FLOAT,
    IN p_temperature_eve FLOAT,
    IN p_temperature_night FLOAT,
    IN p_feels_like_morn FLOAT,
    IN p_feels_like_day FLOAT,
    IN p_feels_like_eve FLOAT,
    IN p_feels_like_night FLOAT,
    IN p_pressure INT,
    IN p_humidity INT,
    IN p_wind_speed FLOAT,
    IN p_clouds INT,
    IN p_uv FLOAT,
    IN p_pop FLOAT,
    IN p_aqi INT
)
BEGIN
    DECLARE existing_timestamp BIGINT;

    -- Lấy timestamp hiện tại của city và df_date
    SELECT df_date INTO existing_timestamp
    FROM DailyForecast
    WHERE city_id = p_city_id AND df_date = p_df_date;

    -- Kiểm tra nếu timestamp mới khác với timestamp hiện tại
    IF existing_timestamp IS NULL OR existing_timestamp < p_df_date THEN
        UPDATE DailyForecast
        SET
            weather_condition_id = p_weather_condition_id,
            icon = p_icon,
            sunrise = p_sunrise,
            sunset = p_sunset,
            moonrise = p_moonrise,
            moonset = p_moonset,
            summary = p_summary,
            temperature_max = p_temperature_max,
            temperature_min = p_temperature_min,
            temperature_morn = p_temperature_morn,
            temperature_day = p_temperature_day,
            temperature_eve = p_temperature_eve,
            temperature_night = p_temperature_night,
            feels_like_morn = p_feels_like_morn,
            feels_like_day = p_feels_like_day,
            feels_like_eve = p_feels_like_eve,
            feels_like_night = p_feels_like_night,
            pressure = p_pressure,
            humidity = p_humidity,
            wind_speed = p_wind_speed,
            clouds = p_clouds,
            uv = p_uv,
            pop = p_pop,
            aqi = p_aqi
        WHERE city_id = p_city_id AND df_date = p_df_date;
    END IF;
END//

DELIMITER //


DROP PROCEDURE IF EXISTS UpdateHourlyForecast //
DELIMITER //

CREATE PROCEDURE UpdateHourlyForecast(
    IN p_hourly_forecast_id INT,
    IN p_city_id BIGINT,
    IN p_hf_timestamp BIGINT,
    IN p_weather_condition_id INT,
    IN p_icon VARCHAR(5),
    IN p_temperature FLOAT,
    IN p_feels_like FLOAT,
    IN p_pressure INT,
    IN p_humidity INT,
    IN p_clouds INT,
    IN p_uv FLOAT,
    IN p_visibility INT,
    IN p_wind_speed FLOAT,
    IN p_pop FLOAT,
    IN p_aqi INT
)
BEGIN
    DECLARE existing_timestamp BIGINT;

    -- Lấy timestamp hiện tại của city và hf_timestamp
    SELECT hf_timestamp INTO existing_timestamp
    FROM HourlyForecast
    WHERE city_id = p_city_id AND hf_timestamp = p_hf_timestamp;

    -- Kiểm tra nếu timestamp mới khác với timestamp hiện tại
    IF existing_timestamp IS NULL OR existing_timestamp < p_hf_timestamp THEN
        UPDATE HourlyForecast
        SET
            weather_condition_id = p_weather_condition_id,
            icon = p_icon,
            temperature = p_temperature,
            feels_like = p_feels_like,
            pressure = p_pressure,
            humidity = p_humidity,
            clouds = p_clouds,
            uv = p_uv,
            visibility = p_visibility,
            wind_speed = p_wind_speed,
            pop = p_pop,
            aqi = p_aqi
        WHERE city_id = p_city_id AND hf_timestamp = p_hf_timestamp;
    END IF;
END //

DELIMITER 
//
DROP PROCEDURE IF EXISTS InsertOrUpdateDailyForecast //
DELIMITER 
//

CREATE PROCEDURE InsertOrUpdateDailyForecast(
    IN P_daily_forecast_id INT,
    IN p_city_id BIGINT,
    IN p_df_date BIGINT,
    IN p_weather_condition_id INT,
    IN p_icon VARCHAR(5),
    IN p_sunrise BIGINT,
    IN p_sunset BIGINT,
    IN p_moonrise BIGINT,
    IN p_moonset BIGINT,
    IN p_summary VARCHAR(100),
    IN p_temperature_max FLOAT,
    IN p_temperature_min FLOAT,
    IN p_temperature_morn FLOAT,
    IN p_temperature_day FLOAT,
    IN p_temperature_eve FLOAT,
    IN p_temperature_night FLOAT,
    IN p_feels_like_morn FLOAT,
    IN p_feels_like_day FLOAT,
    IN p_feels_like_eve FLOAT,
    IN p_feels_like_night FLOAT,
    IN p_pressure INT,
    IN p_humidity INT,
    IN p_wind_speed FLOAT,
    IN p_clouds INT,
    IN p_uv FLOAT,
    IN p_pop FLOAT,
    IN p_aqi INT
)
BEGIN
    DECLARE existing_date BIGINT;

    -- Lấy df_date hiện tại của city
    SELECT df_date INTO existing_date
    FROM DailyForecast
    WHERE city_id = p_city_id AND df_date = p_df_date;

    -- Kiểm tra nếu df_date mới lớn hơn df_date hiện tại hoặc bản ghi chưa tồn tại
    IF existing_date IS NULL THEN
        -- Chèn bản ghi mới
        INSERT INTO DailyForecast (daily_forecast_id,
            city_id, df_date, weather_condition_id, icon, sunrise, sunset, moonrise, moonset, summary,
            temperature_max, temperature_min, temperature_morn, temperature_day, temperature_eve,
            temperature_night, feels_like_morn, feels_like_day, feels_like_eve, feels_like_night,
            pressure, humidity, wind_speed, clouds, uv, pop, aqi
        ) VALUES (p_daily_forecast_id,
            p_city_id, p_df_date, p_weather_condition_id, p_icon, p_sunrise, p_sunset, p_moonrise, p_moonset, p_summary,
            p_temperature_max, p_temperature_min, p_temperature_morn, p_temperature_day, p_temperature_eve,
            p_temperature_night, p_feels_like_morn, p_feels_like_day, p_feels_like_eve, p_feels_like_night,
            p_pressure, p_humidity, p_wind_speed, p_clouds, p_uv, p_pop, p_aqi
        );
    ELSEIF existing_date < p_df_date THEN
        -- Cập nhật bản ghi hiện tại
        UPDATE DailyForecast
        SET
            weather_condition_id = p_weather_condition_id,
            icon = p_icon,
            sunrise = p_sunrise,
            sunset = p_sunset,
            moonrise = p_moonrise,
            moonset = p_moonset,
            summary = p_summary,
            temperature_max = p_temperature_max,
            temperature_min = p_temperature_min,
            temperature_morn = p_temperature_morn,
            temperature_day = p_temperature_day,
            temperature_eve = p_temperature_eve,
            temperature_night = p_temperature_night,
            feels_like_morn = p_feels_like_morn,
            feels_like_day = p_feels_like_day,
            feels_like_eve = p_feels_like_eve,
            feels_like_night = p_feels_like_night,
            pressure = p_pressure,
            humidity = p_humidity,
            wind_speed = p_wind_speed,
            clouds = p_clouds,
            uv = p_uv,
            pop = p_pop,
            aqi = p_aqi
        WHERE city_id = p_city_id AND df_date = p_df_date;
    END IF;
END//


DELIMITER 
//
DROP PROCEDURE IF EXISTS InsertOrUpdateHourlyForecast //
DELIMITER 
//

CREATE PROCEDURE InsertOrUpdateHourlyForecast(
    IN p_hourly_forecast_id INT,
    IN p_city_id BIGINT,
    IN p_hf_timestamp BIGINT,
    IN p_weather_condition_id INT,
    IN p_icon VARCHAR(5),
    IN p_temperature FLOAT,
    IN p_feels_like FLOAT,
    IN p_pressure INT,
    IN p_humidity INT,
    IN p_clouds INT,
    IN p_uv FLOAT,
    IN p_visibility INT,
    IN p_wind_speed FLOAT,
    IN p_pop FLOAT,
    IN p_aqi INT
)
BEGIN
    DECLARE existing_timestamp BIGINT;

    -- Lấy timestamp hiện tại của city và hf_timestamp
    SELECT hf_timestamp INTO existing_timestamp
    FROM HourlyForecast
    WHERE city_id = p_city_id AND hf_timestamp = p_hf_timestamp;

    -- Kiểm tra nếu timestamp mới lớn hơn timestamp hiện tại hoặc bản ghi chưa tồn tại
    IF existing_timestamp IS NULL THEN
        -- Chèn bản ghi mới
        INSERT INTO HourlyForecast (hourly_forecast_id,
            city_id, hf_timestamp, weather_condition_id, icon, temperature, feels_like,
            pressure, humidity, clouds, uv, visibility, wind_speed, pop, aqi
        ) VALUES (p_hourly_forecast_id,
            p_city_id, p_hf_timestamp, p_weather_condition_id, p_icon, p_temperature, p_feels_like,
            p_pressure, p_humidity, p_clouds, p_uv, p_visibility, p_wind_speed, p_pop, p_aqi
        );
    ELSEIF existing_timestamp < p_hf_timestamp THEN
        -- Cập nhật bản ghi hiện tại
        UPDATE HourlyForecast
        SET
            weather_condition_id = p_weather_condition_id,
            icon = p_icon,
            temperature = p_temperature,
            feels_like = p_feels_like,
            pressure = p_pressure,
            humidity = p_humidity,
            clouds = p_clouds,
            uv = p_uv,
            visibility = p_visibility,
            wind_speed = p_wind_speed,
            pop = p_pop,
            aqi = p_aqi
        WHERE city_id = p_city_id AND hf_timestamp = p_hf_timestamp;
    END IF;
END//


DELIMITER 
//
DROP PROCEDURE IF EXISTS InsertOrUpdateCurrentWeather //
DELIMITER 
//

CREATE PROCEDURE InsertOrUpdateCurrentWeather(
    IN p_city_id BIGINT,
    IN p_cur_timestamp BIGINT,
    IN p_weather_condition_id INT,
    IN p_icon VARCHAR(5),
    IN p_temperature FLOAT,
    IN p_feels_like FLOAT,
    IN p_pressure INT,
    IN p_humidity INT,
    IN p_clouds INT,
    IN p_uv FLOAT,
    IN p_visibility INT,
    IN p_wind_speed FLOAT,
    IN p_aqi INT
)
BEGIN
    DECLARE existing_timestamp BIGINT;

    -- Lấy timestamp hiện tại của city
    SELECT cur_timestamp INTO existing_timestamp
    FROM CurrentWeather
    WHERE city_id = p_city_id;

    -- Kiểm tra nếu timestamp mới lớn hơn timestamp hiện tại hoặc bản ghi chưa tồn tại
    IF existing_timestamp IS NULL THEN
        -- Chèn bản ghi mới
        INSERT INTO CurrentWeather (
            city_id, weather_condition_id, cur_timestamp, icon, temperature, feels_like,
            pressure, humidity, clouds, uv, visibility, wind_speed, aqi
        ) VALUES (
            p_city_id, p_weather_condition_id, p_cur_timestamp, p_icon, p_temperature, p_feels_like,
            p_pressure, p_humidity, p_clouds, p_uv, p_visibility, p_wind_speed, p_aqi
        );
    ELSEIF existing_timestamp < p_cur_timestamp THEN
        -- Cập nhật bản ghi hiện tại
        UPDATE CurrentWeather
        SET
            weather_condition_id = p_weather_condition_id,
            cur_timestamp = p_cur_timestamp,
            icon = p_icon,
            temperature = p_temperature,
            feels_like = p_feels_like,
            pressure = p_pressure,
            humidity = p_humidity,
            clouds = p_clouds,
            uv = p_uv,
            visibility = p_visibility,
            wind_speed = p_wind_speed,
            aqi = p_aqi
        WHERE city_id = p_city_id;
    END IF;
END //
 
DELIMITER // 


DROP
PROCEDURE IF EXISTS FindTopCities //

DELIMITER //

CREATE PROCEDURE FindTopCities(IN searchString VARCHAR(50))
BEGIN
    SELECT city_id, city_name, country_id, latitude, longitude
    FROM City
    WHERE city_name LIKE CONCAT(searchString, '%')
    ORDER BY city_name
    LIMIT 5;
END //

DELIMITER
	//

DROP PROCEDURE IF EXISTS CheckUserAlerts //

DELIMITER
	//
CREATE PROCEDURE CheckUserAlerts(
    IN p_city_id BIGINT,
    IN p_cur_timestamp BIGINT,
    IN p_weather_condition_id INT,
    IN p_icon VARCHAR(5),
    IN p_temperature FLOAT,
    IN p_feels_like FLOAT,
    IN p_pressure INT,
    IN p_humidity INT,
    IN p_clouds INT,
    IN p_uv FLOAT,
    IN p_visibility INT,
    IN p_wind_speed FLOAT,
    IN p_aqi INT,
    OUT result INT
)
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE alert_id INT;
    DECLARE alert_type_id INT;
    DECLARE alert_value FLOAT;
    DECLARE condition_type CHAR(1);
    DECLARE nd_id INT;
    DECLARE alert_description VARCHAR(100);
    DECLARE alert_changed_id INT DEFAULT 0;

    DECLARE alert_cursor CURSOR FOR
        SELECT UA.user_alert_id, UA.alert_type_id, UA.alert_value, UA.condition_type, UA.nd_id, UAT.alert_description
        FROM UserAlert UA
        JOIN UserAlertType UAT ON UA.alert_type_id = UAT.alert_type_id
        WHERE UA.city_id = p_city_id AND UA.activated = 1;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN alert_cursor;

    alert_loop: LOOP
        FETCH alert_cursor INTO alert_id, alert_type_id, alert_value, condition_type, nd_id, alert_description;
        IF done THEN
            LEAVE alert_loop;
        END IF;

        CASE alert_description
            WHEN 'Temperature' THEN
                IF (condition_type = '>' AND p_temperature > alert_value) OR
                   (condition_type = '<' AND p_temperature < alert_value) OR
                   (condition_type = '=' AND p_temperature = alert_value) THEN
                    UPDATE UserAlert SET activated = 0 WHERE user_alert_id = alert_id;
                    SET alert_changed_id = alert_id;
                END IF;

            WHEN 'Humidity' THEN
                IF (condition_type = '>' AND p_humidity > alert_value) OR
                   (condition_type = '<' AND p_humidity < alert_value) OR
                   (condition_type = '=' AND p_humidity = alert_value) THEN
                    UPDATE UserAlert SET activated = 0 WHERE user_alert_id = alert_id;
                    SET alert_changed_id = alert_id;
                END IF;

            WHEN 'UV' THEN
                IF (condition_type = '>' AND p_uv > alert_value) OR
                   (condition_type = '<' AND p_uv < alert_value) OR
                   (condition_type = '=' AND p_uv = alert_value) THEN
                    UPDATE UserAlert SET activated = 0 WHERE user_alert_id = alert_id;
                    SET alert_changed_id = alert_id;
                END IF;

            WHEN 'Feels like' THEN
                IF (condition_type = '>' AND p_feels_like > alert_value) OR
                   (condition_type = '<' AND p_feels_like < alert_value) OR
                   (condition_type = '=' AND p_feels_like = alert_value) THEN
                    UPDATE UserAlert SET activated = 0 WHERE user_alert_id = alert_id;
                    SET alert_changed_id = alert_id;
                END IF;

            WHEN 'Air quality index' THEN
                IF (condition_type = '>' AND p_aqi > alert_value) OR
                   (condition_type = '<' AND p_aqi < alert_value) OR
                   (condition_type = '=' AND p_aqi = alert_value) THEN
                    UPDATE UserAlert SET activated = 0 WHERE user_alert_id = alert_id;
                    SET alert_changed_id = alert_id;
                END IF;

            WHEN 'Visibility' THEN
                IF (condition_type = '>' AND p_visibility > alert_value) OR
                   (condition_type = '<' AND p_visibility < alert_value) OR
                   (condition_type = '=' AND p_visibility = alert_value) THEN
                    UPDATE UserAlert SET activated = 0 WHERE user_alert_id = alert_id;
                    SET alert_changed_id = alert_id;
                END IF;

            WHEN 'Clouds' THEN
                IF (condition_type = '>' AND p_clouds > alert_value) OR
                   (condition_type = '<' AND p_clouds < alert_value) OR
                   (condition_type = '=' AND p_clouds = alert_value) THEN
                    UPDATE UserAlert SET activated = 0 WHERE user_alert_id = alert_id;
                    SET alert_changed_id = alert_id;
                END IF;

            -- Add more cases as needed for different alert types

        END CASE;
    END LOOP;

    CLOSE alert_cursor;
    SET result = alert_changed_id;
END//


DELIMITER //

DROP PROCEDURE IF EXISTS SelectCitiesWithMatchingUserAlertID //

DELIMITER //

CREATE PROCEDURE SelectCitiesWithMatchingUserAlertID(IN p_user_id INT)
BEGIN
    SELECT *
    FROM UserAlert
    WHERE nd_id = p_user_id AND activated = 1;
END //

DELIMITER ;
