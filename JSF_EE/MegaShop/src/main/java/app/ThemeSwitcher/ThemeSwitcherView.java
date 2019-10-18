package app.ThemeSwitcher;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


@ManagedBean
public class ThemeSwitcherView {

    private List<Theme> themes;

    @ManagedProperty("#{themeService}")
    private ThemeService service;

    @PostConstruct
    public void init() {
        themes = service.getThemes();
//        setService(new Theme(0, "Nova-Light", "nova-light"));
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setService(ThemeService service) {
        this.service = service;
    }
}