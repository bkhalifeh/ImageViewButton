import javafx.scene.effect.Bloom;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author BehzaD
 */
public class ImageViewButton extends ImageView
{
    ColorAdjust colorAdjust = new ColorAdjust();
    DropShadow shadow = new DropShadow();
    Bloom blm = new Bloom(0);
    public ImageViewButton()
    {
        initButton();
    }
    public ImageViewButton(String path)
    {
        super(path);
        initButton();
    }
    public void setImage(String path)
    {
        setImage(new Image(path));
    }
    private void initButton()
    {
        colorAdjust.setContrast(0.1);
        colorAdjust.setHue(-0.05);
        colorAdjust.setBrightness(0.1);
        colorAdjust.setSaturation(0.2);
        
        shadow.setOffsetY(0f);
        shadow.setOffsetX(0f);
        shadow.setColor(Color.rgb(0x41,0x98,0xff));
        shadow.setInput(colorAdjust);
        
        setOnMouseEntered((event) -> {
            setEffect(shadow);
        });
        setOnMouseExited((event) -> {
            setEffect(null);
        });
        setOnMousePressed((event) -> {
            setEffect(blm);
        });
        setOnMouseReleased((event) -> {
            setEffect(shadow);
        });
    }
}
