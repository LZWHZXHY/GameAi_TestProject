package controllers;

import engine.Car;
import engine.Game;
import engine.GameObject;



public class SeekController extends Controller{

    private  GameObject target;

    public SeekController(GameObject target) {
        this.target = target;
    }


    @Override
    public void update(Car subject, Game game, double delta_t, double controlVariables[]){
        //变量初始化
        controlVariables[VARIABLE_STEERING] = 0;
        controlVariables[VARIABLE_THROTTLE] = 0;
        controlVariables[VARIABLE_BRAKE] = 0;

        //获得对象和目标的坐标
        double carX = subject.getX();
        double carY = subject.getY();
        double targetX = target.getX();
        double targetY = target.getY();

        //计算角度
        double angleToTargetX = Math.atan2(targetY - carY, targetX - carX);
        double currentAngle = subject.getAngle();

        double angleDifference = angleToTargetX - currentAngle;


        //归一化角度到【-pi ，pi】
        while(angleDifference>Math.PI){angleDifference-=2*Math.PI;}
        while(angleDifference<-Math.PI){angleDifference+=2*Math.PI;}



        //设置对象转向
        controlVariables[VARIABLE_STEERING] = Math.max(-1,Math.min(1,angleDifference/(Math.PI/4)));

        controlVariables[VARIABLE_THROTTLE] = 1.0;


        //System.out.println("追逐目标: 角度差=" + angleDifference + ", 转向=" + controlVariables[VARIABLE_STEERING]);



    }

    // 添加getter方法
    public GameObject getTarget() {
        return target;
    }

}
