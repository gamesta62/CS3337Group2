package project.module2;

import java.util.Date;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import javax.imageio.ImageIO;

import project.module2.API.cameraAPI;

public class Camera implements cameraAPI {
    
    DataCenter dataCenter;
    Date calledDate;
    byte[] pic;
    
    public Camera(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
        this.calledDate = null;
        this.pic = null;
    }

    private byte[] randomPicture() {
        
        // where the photo from
        String imageUrl = "https://picsum.photos/200/300/?random";
        
        URL url = null;
        byte[] image = null;
        
        try {
            url = new URL(imageUrl);
            BufferedImage bufferedImage = ImageIO.read(url);

            /*
            // get DataBufferBytes from Raster
            WritableRaster raster = bufferedImage.getRaster();
            DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

            image = data.getData();
            */
            
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            image = baos.toByteArray();
            
        } catch (Exception e) { }
        
        return image;
    }

    @Override
    public void takePicture() {
        // supposed to take a picture by the camera
        // but currently only generates random picture
        byte[] pic = this.randomPicture();
        this.pic = pic;
    }

    @Override
    public void call(Date time) {
        this.calledDate = time;
        this.takePicture();
        this.tryRecordData(this.dataCenter);
    }

    @Override
    public boolean tryRecordData(DataCenter dataCenter) {

        if (this.pic != null) {
            dataCenter.newPicture(this.pic, this.calledDate);
            this.pic = null;
            this.calledDate = null;
            return true;
        }
        
        return false;
    }

}
