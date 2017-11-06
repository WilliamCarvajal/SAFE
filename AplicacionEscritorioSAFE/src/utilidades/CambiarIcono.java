package utilidades;

import java.awt.Image;
import java.awt.Toolkit;

public class CambiarIcono {
	public static Image getIconImage() {
		Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("utilidades/SafePrevencionIcon.png"));
		return icon;
	}
}
