package service;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class ServiceConvertIcon {
    public static Icon toIcon(String iconName) {
        String path = "/icon/" + iconName + ".png";
        return new ImageIcon(ServiceConvertIcon.class.getResource(path));
    } 
}
