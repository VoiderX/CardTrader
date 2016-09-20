/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.LargeObjectManager;

/**
 *
 * @author Gabriel
 */
public class CartaDAO {
    Connection con;
    public CartaDAO(){
        con=ConexaoDB.getCon();
    }
    
    public static Image puxarCarta(int id){
    // All LargeObject API calls must be within a transaction
    Connection con=ConexaoDB.getCon();
    Image im=null;
    try{
    con.setAutoCommit(false);

    // Get the Large Object Manager to perform operations with
    LargeObjectManager lobj = ((org.postgresql.PGConnection)con).getLargeObjectAPI();

    Statement s = con.createStatement();
    ResultSet rs = s.executeQuery("SELECT IMG_CARTA FROM CARTA WHERE ID_CARTA="+id);
    if (rs != null) {
        while(rs.next()){
            int oid=rs.getInt("IMG_CARTA");
            LargeObject obj = lobj.open(oid);
            byte b[]=new byte[obj.size()];
            obj.read(b,0, obj.size());
            ByteArrayInputStream bArray = new ByteArrayInputStream(b);
            BufferedImage imagem = ImageIO.read(bArray);
            im=SwingFXUtils.toFXImage(imagem, null);
            }
    }
    }catch(Exception e){
        e.printStackTrace();
    }
    return im;
    }
    
}
