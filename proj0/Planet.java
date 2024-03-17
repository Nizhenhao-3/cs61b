public class Planet {

    double xxPos;// current x position
    double yyPos;// current y position
    double xxVel;// current velocity in the x direction
    double yyVel;// current velocity in the y direction
    double mass;// 质量
    String imgFileName;//The name of the file that corresponds to the image that depicts the planet
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;
    }
    //特殊重载 重载构造函数；构造函数只为初始化
    public Planet(Planet p){
        this(p.xxPos,p.yyPos, p.xxVel,p.yyVel,p.mass, p.imgFileName);

    }
    public double calcDistance(Planet p){
        double distance;
        distance=(p.xxPos-this.xxPos)*(p.xxPos-this.xxPos)+(p.yyPos-this.yyPos)*(p.yyPos-this.yyPos);
        distance=Math.sqrt(distance);
        return distance;
    }
    public double calcForceExertedBy(Planet p){
        double force;
        double r;
        r=this.calcDistance(p);
        force=6.67e-11*this.mass*p.mass/(r*r);
        return force;
    }
    public double calcForceExertedByX(Planet p){
        double forcex;
        forcex=this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
        return forcex;
    }
    public double calcForceExertedByY(Planet p){
        double forcey;
        forcey=this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
        return forcey;
    }
    public double calcNetForceExertedByX(Planet[] arrays){
        double netforcex=0;
        for (int i=0;i<arrays.length;i++){
            if (this.equals(arrays[i])){
                continue;
            }
            netforcex+=this.calcForceExertedByX(arrays[i]);
        }
        return netforcex;
    }
    public double calcNetForceExertedByY(Planet[] arrays){
        double netforcey=0;
        for (int i=0;i<arrays.length;i++){
            if (this.equals(arrays[i])){
                continue;
            }
            netforcey+=this.calcForceExertedByY(arrays[i]);
        }
        return netforcey;
    }
    public void update(double dt,double fx,double fy){
        this.xxVel+=dt*(fx/this.mass);
        this.yyVel+=dt*(fy/this.mass);
        this.xxPos+=dt*this.xxVel;
        this.yyPos+=dt*this.yyVel;
    }
    void draw(){
        String img_root="./images/"+this.imgFileName;
        StdDraw.picture(this.xxPos,this.yyPos,img_root);
    }

}
