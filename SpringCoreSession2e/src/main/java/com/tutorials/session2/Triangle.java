package com.tutorials.session2;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


//Step 11 - Add application context container access
//Step 14 - Add Bean life cycle tracking methods
public class Triangle 
	implements ApplicationContextAware, BeanNameAware,
	InitializingBean,DisposableBean{
	
	private String type = null;
	private int hieght =0;
	
	private Point pointA= null;
	private Point pointB = null;
	private Point pointC = null;
	
	//Step 10 - Set list of points
	private List<Point> points;
	
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	public Triangle() {
		super();
	}
	public Triangle(String type) {
		super();
		this.type = type;
	}
	
	public Triangle(int hieght) {
		super();
		this.hieght = hieght;
	}
	
	public Triangle(String type, int hieght) {
		super();
		this.type = type;
		this.hieght = hieght;
	}
	   
	public int getHieght() {
		return hieght;
	}
	public void setHieght(int hieght) {
		this.hieght = hieght;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointc) {
		this.pointC = pointc;
	}
	
	public void draw() {
		for(Point point : points)
			System.out.println(point);
	}
	
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		System.out.println("Application Context CALLED");
		Point zeropoint = (Point)ac.getBean("zeropoint");
		System.out.println(zeropoint);
		
		
	}
	public void setBeanName(String name) {
		System.out.println("Bean Name from the container:"+name);
		
		
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean Lifecycle - Triangle properties are set");
		
	}
	public void destroy() throws Exception {
		System.out.println("Bean Life Cycle -Triangles bean disposed");
	}

}