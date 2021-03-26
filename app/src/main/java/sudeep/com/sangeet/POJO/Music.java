package sudeep.com.sangeet.POJO;

import java.io.Serializable;


public class Music implements Serializable{

    private String song;
    private String url;
    private String cover_image;
    private String artists;


    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }


    @Override
    public String toString()
    {
        return song+" "+cover_image+" "+url+" "+artists;
    }


}
