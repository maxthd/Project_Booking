package jdbc2020;

import java.sql.Blob;
import java.sql.SQLException;

public class Image {
    private int id_image;
    private Blob picture;

    public Image(int index, Connexion maconnexion) throws SQLException {
        id_image=index;
        picture=maconnexion.fill_blob_param("SELECT picture FROM Image WHERE id_image=?", id_image);

        //Afficher_Image();
    }

    public void Afficher_Image(){
        System.out.println("id_image :"+id_image+"\t\tpicture:" + picture);
    }








    /**GETTERS ET SETTERS*/
    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }
}
