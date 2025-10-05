package controllers;

import engine.Car;
import engine.Game;
import engine.GameObject;

public class ArriveController extends SeekController {
    private double slowingRadius;
    private double arrivalRadius;
    private double maxSpeed;
    private boolean hasArrived = false;

    public ArriveController(GameObject target) {
        super(target);
        this.slowingRadius = 150;
        this.arrivalRadius = 1;
        this.maxSpeed = 150;
    }

    @Override
    public void update(Car subject, Game game, double delta_t, double[] controlVariables) {
        // 先调用父类的update方法，设置转向和油门
        super.update(subject, game, delta_t, controlVariables);
        controlVariables[VARIABLE_THROTTLE] = 0;
        controlVariables[VARIABLE_BRAKE] = 0;

        // 计算距离（复用父类计算过的坐标，或者重新计算）
        GameObject target = getTarget();
        double carX = subject.getX();
        double carY = subject.getY();
        double targetX = target.getX();
        double targetY = target.getY();

        double dx = targetX - carX;
        double dy = targetY - carY;
        double distance = Math.sqrt(dx * dx + dy * dy);

        double currentSpeed = subject.getSpeed();

        if(distance < slowingRadius){ //进入了减速区域
            System.out.println("进入减速区域");
            System.out.println("current speed:" + currentSpeed + " distance：" + distance + " THROTTLE：" + controlVariables[VARIABLE_THROTTLE] + " BRAKE：" + controlVariables[VARIABLE_BRAKE]);
            double desiredSpeed = maxSpeed * (distance / slowingRadius);
            controlVariables[VARIABLE_BRAKE] = Math.min(1.0, (currentSpeed - desiredSpeed) / 40);
            controlVariables[VARIABLE_THROTTLE] = 0;
            if(distance < arrivalRadius){
                System.out.println("进入停车区域");System.out.println("进入停车区域");
                System.out.println("desiredSpeed: " + desiredSpeed + " ");
                controlVariables[VARIABLE_THROTTLE] = 0;
                controlVariables[VARIABLE_BRAKE] = 1;
            }

        }else{
            controlVariables[VARIABLE_THROTTLE] = 1;
        }
    }
}


