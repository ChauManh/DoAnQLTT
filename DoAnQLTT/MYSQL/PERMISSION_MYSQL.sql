-- Select the database
USE QLTT;

-- Drop user if it exists
DROP USER IF EXISTS 'WeatherUser'@'localhost';
DROP USER IF EXISTS 'WeatherLogin'@'localhost'; 
DROP USER IF EXISTS 'WeatherAdmin'@'localhost'; 

-- Create a new user with privileges
CREATE USER 'WeatherUser'@'localhost' IDENTIFIED BY 'user@123';
CREATE USER 'WeatherAdmin'@'localhost' IDENTIFIED BY 'admin@123';
CREATE USER 'WeatherLogin'@'localhost' IDENTIFIED BY 'login@123';

-- Show database
GRANT SHOW DATABASES ON *.* TO 'WeatherUser'@'localhost';
GRANT SHOW DATABASES ON *.* TO 'WeatherAdmin'@'localhost';
GRANT SHOW DATABASES ON *.* TO 'WeatherLogin'@'localhost';
      
-- User
GRANT INSERT, SELECT, UPDATE ON QLTT.NguoiDung TO 'WeatherLogin'@'localhost';

-- User
GRANT SELECT ON QLTT.Country TO 'WeatherUser'@'localhost';
GRANT SELECT ON QLTT.City TO 'WeatherUser'@'localhost';
GRANT SELECT ON QLTT.WeatherCondition TO 'WeatherUser'@'localhost';
GRANT SELECT ON QLTT.DailyForecast TO 'WeatherUser'@'localhost';
GRANT SELECT ON QLTT.HourlyForecast TO 'WeatherUser'@'localhost';
GRANT SELECT, INSERT ON QLTT.CurrentWeather TO 'WeatherUser'@'localhost';
GRANT SELECT, UPDATE ON QLTT.NguoiDung TO 'WeatherUser'@'localhost';
GRANT SELECT, INSERT, DELETE, UPDATE ON QLTT.UserAlert TO 'WeatherUser'@'localhost';
GRANT SELECT ON QLTT.UserAlertType TO 'WeatherUser'@'localhost';
GRANT SELECT, INSERT, DELETE ON QLTT.UserAlertHistory TO 'WeatherUser'@'localhost';

-- Assign EXECUTE privilege on procedures to WeatherUser
GRANT EXECUTE ON PROCEDURE QLTT.AverageTemperatureNextXHours TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.SelectCitiesWithMatchingUserAlertID TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.AverageRainProbabilityNextXHours TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.AverageAQINextXHours TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.AverageHumidityNextXHours TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.AverageUVNextXDays TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.AverageTemperatureNextXDays TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.AverageAQINextXDays TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.AverageHumidityNextXDays TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.UpdateCurrentWeather TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.UpdateDailyForecast TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.UpdateHourlyForecast TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.FindTopCities TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.CheckUserAlerts TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.InsertOrUpdateDailyForecast TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.InsertOrUpdateHourlyForecast TO 'WeatherUser'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.InsertOrUpdateCurrentWeather TO 'WeatherUser'@'%';

-- Admin
GRANT SELECT, INSERT, UPDATE, DELETE ON QLTT.Country TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;
GRANT SELECT, INSERT, UPDATE, DELETE ON QLTT.City TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;
GRANT SELECT, INSERT, UPDATE, DELETE ON QLTT.WeatherCondition TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;
GRANT SELECT, INSERT, UPDATE, DELETE ON QLTT.DailyForecast TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;
GRANT SELECT, INSERT, UPDATE, DELETE ON QLTT.HourlyForecast TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;
GRANT SELECT, INSERT, UPDATE, DELETE ON QLTT.CurrentWeather TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;
GRANT SELECT, DELETE ON QLTT.NguoiDung TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;
GRANT SELECT, INSERT, UPDATE, DELETE ON QLTT.UserAlert TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;
GRANT SELECT, INSERT, UPDATE, DELETE ON QLTT.UserAlertType TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;
GRANT SELECT, INSERT, UPDATE, DELETE ON QLTT.UserAlertHistory TO 'WeatherAdmin'@'localhost' WITH GRANT OPTION;

GRANT EXECUTE ON PROCEDURE QLTT.AverageTemperatureNextXHours TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.SelectCitiesWithMatchingUserAlertID TO 'WeatherAdmin'@'%';
GRANT EXECUTE ON PROCEDURE QLTT.AverageRainProbabilityNextXHours TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.AverageAQINextXHours TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.AverageHumidityNextXHours TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.AverageUVNextXDays TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.AverageTemperatureNextXDays TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.AverageAQINextXDays TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.AverageHumidityNextXDays TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.UpdateCurrentWeather TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.UpdateDailyForecast TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.UpdateHourlyForecast TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.FindTopCities TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.CheckUserAlerts TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.InsertOrUpdateDailyForecast TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.InsertOrUpdateHourlyForecast TO 'WeatherAdmin'@'%' WITH GRANT OPTION;
GRANT EXECUTE ON PROCEDURE QLTT.InsertOrUpdateCurrentWeather TO 'WeatherAdmin'@'%' WITH GRANT OPTION;

-- Apply the changes
FLUSH PRIVILEGES;
