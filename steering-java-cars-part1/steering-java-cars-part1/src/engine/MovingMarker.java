package engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
/**
 *
 * @author santi
 */
public class MovingMarker extends GameObject {
    double m_radius;
    Color m_color;
    RotatedRectangle m_collision_box;
    double t = 0;
    BufferedImage img; //图片支持
    
    public MovingMarker(double radius, Color c,String imagePath) {
 
//        m_x = x;
//        m_y = y;

        try {
            img = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
            img = null;
            System.out.println("无法加载图片: " + imagePath);
        }
        m_radius = radius;
        m_color = c;
        m_collision_box = null;
    }

    // 保持原有构造函数兼容性
    public MovingMarker(double radius, Color c) {
        this(radius, c, null);
    }

    public void update(Game game, double delta_t) {
    	t += delta_t/3;
    	double theta = 2;
    	m_x = 350*Math.cos(t) + game.m_width/2;
    	m_y = 350*Math.sin(2*t)/2 + game.m_height/2;
//    	m_x = 200*(Math.cos(theta) * Math.cos(t) - Math.sin(theta) * Math.sin(2*t)/2) + game.m_width/2;
//    	m_y = 200*(Math.sin(theta) * Math.cos(t) + Math.cos(theta) * Math.sin(2*t)/2) + game.m_height/2;
    }

    @Override
    public double getX() {
    	// TODO Auto-generated method stub
    	return super.getX();
    }
    @Override
    public double getY() {
    	// TODO Auto-generated method stub
    	return super.getY();
    }
    
    public void draw(Graphics2D g) {
        if (img != null) {
            // 绘制图片
            g.drawImage(img, (int)(m_x - img.getWidth()/2),
                    (int)(m_y - img.getHeight()/2), null);
        } else {
            // 如果没有图片，绘制圆形
            g.setColor(m_color);
            g.fillOval((int)(m_x-m_radius), (int)(m_y-m_radius),
                    (int)(m_radius*2), (int)(m_radius*2));
        }
    }
    
    public RotatedRectangle getCollisionBox() {
        return m_collision_box;
    }
    
        
}
