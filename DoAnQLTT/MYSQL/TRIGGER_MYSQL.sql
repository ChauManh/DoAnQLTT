-- Sử dụng cơ sở dữ liệu QLTT
USE QLTT;


DELIMITER //
-- Drop và tạo lại trigger cho CurrentWeather
DROP TRIGGER IF EXISTS trg_HandleCurrentWeather //
DELIMITER //
CREATE TRIGGER trg_HandleCurrentWeather
BEFORE INSERT ON CurrentWeather
FOR EACH ROW
BEGIN
    DECLARE CurrentTimestamp BIGINT DEFAULT UNIX_TIMESTAMP();
    DECLARE CurrentConvertedYear INT;
    DECLARE CurrentConvertedMonth INT;
    DECLARE CurrentConvertedDay INT;
    DECLARE CurrentConvertedHour INT;
    DECLARE ConvertedYear INT;
    DECLARE ConvertedMonth INT;
    DECLARE ConvertedDay INT;
    DECLARE ConvertedHour INT;  
    
    SET CurrentConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedHour = HOUR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    
    SET ConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(NEW.cur_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(NEW.cur_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(NEW.cur_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedHour = HOUR(CONVERT_TZ(FROM_UNIXTIME(NEW.cur_timestamp), @@session.time_zone, '+00:00'));
    
    IF ConvertedYear < CurrentConvertedYear THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot insert data older (Year) than the current date in CurrentWeather.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth < CurrentConvertedMonth THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot insert data older (Month) than the current date in CurrentWeather.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay < CurrentConvertedDay THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot insert data older (Day) than the current date in CurrentWeather.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay = CurrentConvertedDay AND ConvertedHour < CurrentConvertedHour THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot insert data older (Hour) than the current date in CurrentWeather.';
    END IF;
END //
DELIMITER //
DROP TRIGGER IF EXISTS trg_HandleCurrentWeatherUpdate //
DELIMITER //
CREATE TRIGGER trg_HandleCurrentWeatherUpdate
BEFORE UPDATE ON CurrentWeather
FOR EACH ROW
BEGIN
    DECLARE CurrentTimestamp BIGINT DEFAULT UNIX_TIMESTAMP();
    DECLARE CurrentConvertedYear INT;
    DECLARE CurrentConvertedMonth INT;
    DECLARE CurrentConvertedDay INT;
    DECLARE CurrentConvertedHour INT;
    DECLARE ConvertedYear INT;
    DECLARE ConvertedMonth INT;
    DECLARE ConvertedDay INT;
    DECLARE ConvertedHour INT;  
    
    SET CurrentConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedHour = HOUR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    
    SET ConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(NEW.cur_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(NEW.cur_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(NEW.cur_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedHour = HOUR(CONVERT_TZ(FROM_UNIXTIME(NEW.cur_timestamp), @@session.time_zone, '+00:00'));
    
    IF ConvertedYear < CurrentConvertedYear THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Year) than the current date in CurrentWeather.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth < CurrentConvertedMonth THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Month) than the current date in CurrentWeather.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay < CurrentConvertedDay THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Day) than the current date in CurrentWeather.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay = CurrentConvertedDay AND ConvertedHour < CurrentConvertedHour THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Hour) than the current date in CurrentWeather.';
    END IF;
END //

-- Drop và tạo lại trigger cho HourlyForecast
DELIMITER //
DROP TRIGGER IF EXISTS trg_HandleHourlyForecast //
DELIMITER //
CREATE TRIGGER trg_HandleHourlyForecast
BEFORE INSERT ON HourlyForecast
FOR EACH ROW
BEGIN
    DECLARE CurrentTimestamp BIGINT DEFAULT UNIX_TIMESTAMP();
    DECLARE CurrentConvertedYear INT;
    DECLARE CurrentConvertedMonth INT;
    DECLARE CurrentConvertedDay INT;
    DECLARE CurrentConvertedHour INT;
    DECLARE ConvertedYear INT;
    DECLARE ConvertedMonth INT;
    DECLARE ConvertedDay INT;
    DECLARE ConvertedHour INT;  
    
    SET CurrentConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedHour = HOUR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    
    SET ConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(NEW.hf_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(NEW.hf_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(NEW.hf_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedHour = HOUR(CONVERT_TZ(FROM_UNIXTIME(NEW.hf_timestamp), @@session.time_zone, '+00:00'));
    
    IF ConvertedYear < CurrentConvertedYear THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot insert data older (Year) than the current date in HourlyForecast.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth < CurrentConvertedMonth THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot insert data older (Month) than the current date in HourlyForecast.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay < CurrentConvertedDay THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot insert data older (Day) than the current date in HourlyForecast.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay = CurrentConvertedDay AND ConvertedHour < CurrentConvertedHour THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot insert data older (Hour) than the current date in HourlyForecast.';
    END IF;
END //
DELIMITER //
DROP TRIGGER IF EXISTS trg_HandleHourlyForecastUpdate //
DELIMITER //
CREATE TRIGGER trg_HandleHourlyForecastUpdate
BEFORE UPDATE ON HourlyForecast
FOR EACH ROW
BEGIN
    DECLARE CurrentTimestamp BIGINT DEFAULT UNIX_TIMESTAMP();
    DECLARE CurrentConvertedYear INT;
    DECLARE CurrentConvertedMonth INT;
    DECLARE CurrentConvertedDay INT;
    DECLARE CurrentConvertedHour INT;
    DECLARE ConvertedYear INT;
    DECLARE ConvertedMonth INT;
    DECLARE ConvertedDay INT;
    DECLARE ConvertedHour INT;  
    
    SET CurrentConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedHour = HOUR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    
    SET ConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(NEW.hf_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(NEW.hf_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(NEW.hf_timestamp), @@session.time_zone, '+00:00'));
    SET ConvertedHour = HOUR(CONVERT_TZ(FROM_UNIXTIME(NEW.hf_timestamp), @@session.time_zone, '+00:00'));
    
    IF ConvertedYear < CurrentConvertedYear THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Year) than the current date in HourlyForecast.';
    ELSEIF ConvertedYear >= CurrentConvertedYear AND ConvertedMonth < CurrentConvertedMonth THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Month) than the current date in HourlyForecast.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay < CurrentConvertedDay THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Day) than the current date in HourlyForecast.';
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay = CurrentConvertedDay AND ConvertedHour < CurrentConvertedHour THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Hour) than the current date in HourlyForecast.';
    END IF;
END //
DELIMITER //
-- Drop và tạo lại trigger cho DailyForecast
DROP TRIGGER IF EXISTS trg_HandleDailyForecast //
DELIMITER //
CREATE TRIGGER trg_HandleDailyForecast
BEFORE INSERT ON DailyForecast
FOR EACH ROW
BEGIN
    DECLARE CurrentTimestamp BIGINT DEFAULT UNIX_TIMESTAMP();
    DECLARE CurrentConvertedYear INT;
    DECLARE CurrentConvertedMonth INT;
    DECLARE CurrentConvertedDay INT;
    DECLARE ConvertedYear INT;
    DECLARE ConvertedMonth INT;
    DECLARE ConvertedDay INT;
    DECLARE errorMessage VARCHAR(255);

    SET CurrentConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));

    SET ConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(NEW.df_date), @@session.time_zone, '+00:00'));
    SET ConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(NEW.df_date), @@session.time_zone, '+00:00'));
    SET ConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(NEW.df_date), @@session.time_zone, '+00:00'));

    IF ConvertedYear < CurrentConvertedYear THEN
        SET errorMessage = CONCAT('Cannot insert data older (Year) than the current date in DailyForecast. Current timestamp: ', CurrentTimestamp,'|',NEW.df_date);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = errorMessage;
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth < CurrentConvertedMonth THEN
        SET errorMessage = CONCAT('Cannot insert data older (Month) than the current date in DailyForecast. Current timestamp: ', CurrentTimestamp,'|',NEW.df_date);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = errorMessage;
    ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay < CurrentConvertedDay THEN
        SET errorMessage = CONCAT('Cannot insert data older (Day) than the current date in DailyForecast. Current timestamp: ', CurrentConvertedDay,'|',ConvertedDay);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = errorMessage;
    END IF;
END //
DELIMITER //
DROP TRIGGER IF EXISTS trg_HandleDailyForecastUpdate //
DELIMITER //
CREATE TRIGGER trg_HandleDailyForecastUpdate
BEFORE UPDATE ON DailyForecast
FOR EACH ROW
BEGIN
    DECLARE CurrentTimestamp BIGINT DEFAULT UNIX_TIMESTAMP();
    DECLARE CurrentConvertedYear INT;
    DECLARE CurrentConvertedMonth INT;
    DECLARE CurrentConvertedDay INT;
    DECLARE ConvertedYear INT;
    DECLARE ConvertedMonth INT;
    DECLARE ConvertedDay INT;
    
    SET CurrentConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    SET CurrentConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(CurrentTimestamp), @@session.time_zone, '+00:00'));
    
SET ConvertedYear = YEAR(CONVERT_TZ(FROM_UNIXTIME(NEW.df_date), @@session.time_zone, '+00:00'));
SET ConvertedMonth = MONTH(CONVERT_TZ(FROM_UNIXTIME(NEW.df_date), @@session.time_zone, '+00:00'));
SET ConvertedDay = DAY(CONVERT_TZ(FROM_UNIXTIME(NEW.df_date), @@session.time_zone, '+00:00'));

IF ConvertedYear < CurrentConvertedYear THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Year) than the current date in DailyForecast.';
ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth < CurrentConvertedMonth THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Month) than the current date in DailyForecast.';
ELSEIF ConvertedYear = CurrentConvertedYear AND ConvertedMonth = CurrentConvertedMonth AND ConvertedDay < CurrentConvertedDay THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot UPDATE data older (Day) than the current date in DailyForecast.';
END IF;
END //
DELIMITER //
-- Drop và tạo lại trigger cho UserAlert
DROP TRIGGER IF EXISTS trg_UpdateUserAlert //
DELIMITER //
CREATE TRIGGER trg_UpdateUserAlert
AFTER UPDATE ON UserAlert
FOR EACH ROW
BEGIN
    IF OLD.activated = 1 AND NEW.activated = 0 THEN
        INSERT INTO UserAlertHistory(
            nd_id,
            city_id,
            condition_type,
            alert_value,
            comment,
            activation_time
        ) VALUES (
            NEW.nd_id,
            NEW.city_id,
            NEW.condition_type,
            NEW.alert_value,
            NEW.comment,
            NOW()
        );
    END IF;
END //
DELIMITER //
-- Drop và tạo lại các trigger để chặn update, delete, insert của UserAlert và UserAlertHistory của người dùng khác
DROP TRIGGER IF EXISTS BeforeDeleteUserAlert //
DELIMITER //
CREATE TRIGGER BeforeDeleteUserAlert
BEFORE DELETE ON UserAlert
FOR EACH ROW
BEGIN
    IF OLD.nd_id <> @current_user_id THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You are not allowed to delete alerts for other users.';
    END IF;
END //
DELIMITER //
DROP TRIGGER IF EXISTS BeforeInsertUserAlert //
DELIMITER //
CREATE TRIGGER BeforeInsertUserAlert
BEFORE INSERT ON UserAlert
FOR EACH ROW
BEGIN
    IF NEW.nd_id <> @current_user_id THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You are not allowed to add alerts for other users.';
    END IF;
END //
DELIMITER //
DROP TRIGGER IF EXISTS BeforeUpdateUserAlert //
DELIMITER //
CREATE TRIGGER BeforeUpdateUserAlert
BEFORE UPDATE ON UserAlert
FOR EACH ROW
BEGIN
    IF NEW.nd_id <> @current_user_id THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You are not allowed to update alerts for other users.';
    END IF;
END //
DELIMITER //
DROP TRIGGER IF EXISTS BeforeDeleteUserAlertHistory //
DELIMITER //
CREATE TRIGGER BeforeDeleteUserAlertHistory
BEFORE DELETE ON UserAlertHistory
FOR EACH ROW
BEGIN
    IF OLD.nd_id <> @current_user_id THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You are not allowed to delete alerts for other users.';
    END IF;
END //
DELIMITER //
DROP TRIGGER IF EXISTS BeforeInsertUserAlertHistory //
DELIMITER //
CREATE TRIGGER BeforeInsertUserAlertHistory
BEFORE INSERT ON UserAlertHistory
FOR EACH ROW
BEGIN
    IF NEW.nd_id <> @current_user_id THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You are not allowed to add alerts for other users.';
    END IF;
END //
DELIMITER //
DROP TRIGGER IF EXISTS BeforeUpdateUserAlertHistory //
DELIMITER //
CREATE TRIGGER BeforeUpdateUserAlertHistory
BEFORE UPDATE ON UserAlertHistory
FOR EACH ROW
BEGIN
    IF NEW.nd_id <> @current_user_id THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You are not allowed to update alerts for other users.';
    END IF;
END //

-- Đặt lại delimiter về dấu chấm phẩy
DELIMITER ;

