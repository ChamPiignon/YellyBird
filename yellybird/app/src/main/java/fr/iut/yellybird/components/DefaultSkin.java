package fr.iut.yellybird.components;

public class DefaultSkin implements ISkin{
    private final String url;

    public DefaultSkin(){
        url = "/res/drawable/bird.png";
    }

    public String getUrl() {
        return url;
    }
}
