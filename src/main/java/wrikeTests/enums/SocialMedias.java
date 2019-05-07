package wrikeTests.enums;

public enum SocialMedias {
    TWITER("https://twitter.com/wrike","footer-icons.symbol.svg?v2#twitter"),
    YOUTUBE("https://www.youtube.com/user/WrikeTeam", "footer-icons.symbol.svg?v2#youtube"),
    ;

    public String url;
    public String icon;

    SocialMedias(String url, String icon) {
        this.icon=icon;
        this.url=url;
    }
}
