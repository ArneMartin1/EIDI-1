import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.*;

public class EarthMoon {

    //Physics constants
    private final static double MASS_EARTH = 5.972e4;
    private final static double MASS_MOON = 7.349e2;

    private final static double RADIUS_EARTH = 6371;
    private final static double RADIUS_MOON = 1738;

    //Initial values (Anfangswerte)
    private final static double INIT_EARTH_X = 0;
    private final static double INIT_EARTH_Y = 0;
    private final static double INIT_EARTH_VEL_X = 0;
    private final static double INIT_EARTH_VEL_Y = 0;

    private final static double INIT_MOON_X = 0;
    private final static double INIT_MOON_Y = 384400;
    private final static double INIT_MOON_VEL_X = 0.0;    //TODO: d)
    private final static double INIT_MOON_VEL_Y = 0;
    //Scheinbar stürzt der Mond nie auf die Erde, weniger Speed als INIT_MOON_VEL_X = 0.0 geht ja nicht.
    //Bei INIT_MOON_VEL_X = 20 haut er ab, das ist zwar nicht der kleinste Wert bei dem er weg fliegt, 
    //aber das war auch nicht die Frage 
    private final static double GRAVITION_CONST = 6.674;

    //Simulation parameter
    private final static int T = 365 * 24 * 3600;
    private final static int TIME_STEP = 3600;


    //(Blackbox) Gui
    private static JPanel view;
    private final static double SCALE_FACTOR = 5e-4;
    private final static double SCALE_RADIUS_FACTOR = 4;
    private static double[][] positions = new double[T / TIME_STEP][];
    private static double[] currentPosition = null;


    //Anzupassende Methoden

    /**
     * Berechnet den euklidischen Abstand zwischen 2 Punkten p1 und p2
     *
     * @param posX1 x-Koordinate von p1
     * @param posY1 y-Koordinate von p1
     * @param posX2 x-Koordinate von p2
     * @param posY2 y-Koordinate von p2
     * @return Der euklidische Abstand zwischen p1 und p2
     */
    private static double computeDist(double posX1, double posY1, double posX2, double posY2) {
        //TODO: a)

        double euklid = Math.sqrt(((posX2-posX1)*(posX2-posX1)) + ((posY2-posY1)*(posY2-posY1)));
        return euklid; 

    }

    /**
     * Berechnet die Geschwindigkeit von p1 in Richtung einer Komponente (x oder y)
     *
     * @param pos1  Aktuelle Position von p1
     * @param vel1  Aktuelle Geschwindigkeit von p1
     * @param pos2  Aktuelle Position von p2
     * @param mass2 Die Masse von p2
     * @param dist  Der euklidische Abstand zwischen p1 und p2
     * @param t     Delta-t (Abstand zwischen t_k und t_k+1
     * @return Die Geschwindigkeit von p1 zum Zeitpunkt t_k+1
     */
    private static double computeNextVelocity(double pos1, double vel1, double pos2, double mass2, double dist, double t) {
        //TODO: b)
        double velocity = t*mass2*GRAVITION_CONST*((pos2-pos1)/(Math.pow(dist,3))) + vel1;
        //System.out.println(velocity);
        return velocity;
    }

    /**
     * Berechnet die nächste Position von p in x- oder y-Richtung
     *
     * @param pos Aktuelle Position (x oder y-Koordinate)
     * @param vel Aktuelle Geschwindigkeit (in x oder y-Richtung)
     * @param t   Delta-t (Abstand zwischen t_k und t_k+1
     * @return Die nächste Position von p in x- oder y-Richtung
     */
    private static double computeNextPosition(double pos, double vel, int t) {
        //TODO: c)
        double position = (pos + (t*vel));
        return position;
    }

    //Ab hier Blackbox-Code//
    //vvvvvvvvvvvvvvvvvvvvv//

    public static void main(String[] args) {

        double moonX = INIT_MOON_X;
        double moonY = INIT_MOON_Y;

        double moonVx = INIT_MOON_VEL_X;
        double moonVy = INIT_MOON_VEL_Y;

        double earthX = INIT_EARTH_X;
        double earthY = INIT_EARTH_Y;

        double earthVx = INIT_EARTH_VEL_X;
        double earthVy = INIT_EARTH_VEL_Y;

        //RUN SIMULATION
        int k = 0;
        for (int i = 0; i < T; i += TIME_STEP) {

            double dist = computeDist(earthX, earthY, moonX, moonY);

            if (checkCollision(dist, RADIUS_MOON, RADIUS_EARTH)) {
                System.out.println("Simulation stopped, objects have collided.");
                break;
            }

            moonVx = computeNextVelocity(moonX, moonVx, earthX, MASS_EARTH, dist, TIME_STEP);
            moonVy = computeNextVelocity(moonY, moonVy, earthY, MASS_EARTH, dist, TIME_STEP);
            earthVx = computeNextVelocity(earthX, earthVx, moonX, MASS_MOON, dist, TIME_STEP);
            earthVy = computeNextVelocity(earthY, earthVy, moonY, MASS_MOON, dist, TIME_STEP);

            moonX = computeNextPosition(moonX, moonVx, TIME_STEP);
            moonY = computeNextPosition(moonY, moonVy, TIME_STEP);
            earthX = computeNextPosition(earthX, earthVx, TIME_STEP);
            earthY = computeNextPosition(earthY, earthVy, TIME_STEP);

            positions[k++] = new double[]{moonX, moonY, earthX, earthY, moonVx, moonVy, earthVx, earthVy};
        }

        //RUN GUI
        JFrame frame = new JFrame("Earth and Moon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        view = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHints(rh);
                draw(g2d);
            }
        };

        view.setDoubleBuffered(true);
        view.setBackground(Color.BLACK);
        view.setPreferredSize(new Dimension(500, 500));

        frame.getContentPane().add(view);
        frame.pack();
        frame.setResizable(false);
        SwingUtilities.invokeLater(() -> frame.setVisible(true));

        for (int i = 0; i < positions.length; i += 3600 / TIME_STEP) {
            currentPosition = positions[i];
            if (currentPosition == null) {
                break;
            }
            SwingUtilities.invokeLater(() -> view.repaint());
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean checkCollision(double dist, double radius1, double radius2) {
        return dist < radius1 + radius2;
    }

    private static void draw(Graphics2D g) {

        if(currentPosition == null){
            return;
        }

        double offsetX = view.getBounds().getWidth() / 2 - currentPosition[2] * SCALE_FACTOR;
        double offsetY = view.getBounds().getHeight() / 2 + currentPosition[3] * SCALE_FACTOR;

        g.setColor(Color.BLUE);

        g.fill(new Ellipse2D.Double(offsetX + (currentPosition[2] - SCALE_RADIUS_FACTOR * RADIUS_EARTH) * SCALE_FACTOR,
                offsetY - (currentPosition[3] + SCALE_RADIUS_FACTOR * RADIUS_EARTH) * SCALE_FACTOR,
                2 * SCALE_RADIUS_FACTOR * RADIUS_EARTH * SCALE_FACTOR,
                2 * SCALE_RADIUS_FACTOR * RADIUS_EARTH * SCALE_FACTOR));

        g.setColor(Color.GREEN);

        g.fill(new Ellipse2D.Double(offsetX + (currentPosition[0] - SCALE_RADIUS_FACTOR * RADIUS_MOON) * SCALE_FACTOR,
                offsetY - (currentPosition[1] + SCALE_RADIUS_FACTOR * RADIUS_MOON) * SCALE_FACTOR,
                2 * SCALE_RADIUS_FACTOR * RADIUS_MOON * SCALE_FACTOR,
                2 * SCALE_RADIUS_FACTOR * RADIUS_MOON * SCALE_FACTOR));

        g.setColor(Color.WHITE);

        g.drawString("Mond", (float) (offsetX + (currentPosition[0] + 2 * SCALE_RADIUS_FACTOR * RADIUS_MOON) * SCALE_FACTOR), (float) (
                offsetY - (currentPosition[1] + SCALE_RADIUS_FACTOR * RADIUS_MOON) * SCALE_FACTOR));

        g.drawString("Erde", (float) (offsetX + (currentPosition[2] + 1 * SCALE_RADIUS_FACTOR * RADIUS_EARTH) * SCALE_FACTOR), (float) (
                offsetY - (currentPosition[3] + SCALE_RADIUS_FACTOR * RADIUS_EARTH) * SCALE_FACTOR));
    }
}