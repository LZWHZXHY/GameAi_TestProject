package controllers;

public class Vector2D {
    public double x, y; //两个分量用于存放XY方向的数据

    //construct function 构造函数！
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }


    //Vector 的加减函数
    public Vector2D add(Vector2D other){
        return new Vector2D(this.x+other.x, this.y+other.y);
    }
    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    // 添加数乘（乘以标量）
    public Vector2D multiply(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }


    //Vector 向量长度计算
    public double magnitude(){
        return Math.sqrt(x*x + y*y);
    }
    // 添加向量归一化
    public Vector2D normalize(){
        double length = this.magnitude();
        if(length == 0){
            return new Vector2D(0, 0);
        }
        return new Vector2D(x / length, y / length);
    }

    // 添加距离计算
    public double distanceTo(Vector2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }



    public static Vector2D fromAngle(double angle){
        return new Vector2D(Math.cos(angle), Math.sin(angle));
    }

    public double toAngle(){
        return Math.atan2(this.y, this.x);
    }








    public static void main(String[] args){
        System.out.println("测试 Vector2D 类是否正常.....");

        Vector2D v1 = new Vector2D(5, 3);
        Vector2D v2 = new Vector2D(2, 1);

        System.out.println("向量1: (" + v1.x + ", " + v1.y + ")");
        System.out.println("向量2: (" + v2.x + ", " + v2.y + ")");

        // 测试加法
        Vector2D sum = v1.add(v2);
        System.out.println("加法结果: (" + sum.x + ", " + sum.y + ")");

        // 测试减法
        Vector2D diff = v1.subtract(v2);
        System.out.println("减法结果: (" + diff.x + ", " + diff.y + ")");

        Vector2D v = new Vector2D(3, 4);
        System.out.println("原始向量: (" + v.x + ", " + v.y + ")");
        System.out.println("原始长度: " + v.magnitude());

        // 测试归一化
        Vector2D normalized = v.normalize();
        System.out.println("归一化后: (" + normalized.x + ", " + normalized.y + ")");
        System.out.println("归一化长度: " + normalized.magnitude());

        Vector2D target = new Vector2D(4, 6);

        System.out.println("测试数乘:");
        Vector2D scaled = v.multiply(3);
        System.out.println("数乘结果: (" + scaled.x + ", " + scaled.y + ")");

        System.out.println("测试距离:");
        double distance = v.distanceTo(target);
        System.out.println("距离: " + distance);
    }



}
