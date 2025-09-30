package controllers;

public class Vector2D {
    public double x, y; //两个分量用于存放XY方向的数据

    //construct function 构造函数！
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }


    //Vector 的增加函数
    public Vector2D add(Vector2D other){
        return new Vector2D(this.x+other.x, this.y+other.y);
    }

    //Vector 向量长度计算
    public double magnitude(){
        return Math.sqrt(x*x + y*y);
    }


    public static void main(String[] args){
        System.out.println("测试 Vector2D 类是否正常.....");

        // 测试1：创建向量
        Vector2D v = new Vector2D(3, 4);
        System.out.println("创建向量: (" + v.x + ", " + v.y + ")");
        // 测试2：计算向量长度
        double length = v.magnitude();
        System.out.println("向量长度: " + length);

    }



}
