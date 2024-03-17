public class NBody {
    static public double readRadius(String filename){
        In in = new In(filename);
        int firstItemInFile = in.readInt();
        double radius= in.readDouble();
        return radius;
    }
    static public Planet[] readPlanets(String filename){
        Planet[] Planets=new Planet[5];
        double xxpos,yypos,xxvel,yyvel,mass;
        String imgfilename;
        In in =new In(filename);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        for(int i=0;i<5;i++){
            xxpos=in.readDouble();
            yypos=in.readDouble();
            xxvel=in.readDouble();
            yyvel=in.readDouble();
            mass=in.readDouble();
            imgfilename=in.readString();
            Planets[i]=new Planet(xxpos,yypos,xxvel,yyvel,mass,imgfilename);
        }
        return Planets;
    }
    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt =Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet[] Planets=new Planet[5];
        Planets=readPlanets(filename);




        double time=0.0;
        while (time<T){
            double[] xForces=new double[5];
            double[] yForces=new double[5];
            for(int i=0;i<5;i++){
                xForces[i]=Planets[i].calcNetForceExertedByX(Planets);
                yForces[i]=Planets[i].calcNetForceExertedByY(Planets);

            }
            for (int i=0;i<5;i++){
                Planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.enableDoubleBuffering();
            StdDraw.setScale(-radius,radius);
            StdDraw.clear();
            StdDraw.picture(0,0,"./images/starfield.jpg");
            for(int i=0;i<5;i++){
                Planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;


        }
        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }




    }
}
