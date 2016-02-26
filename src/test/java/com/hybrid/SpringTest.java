package com.hybrid;

import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.shape.Shape;

/**
 * Hello world!
 *
 */
public class SpringTest 
{
	static Log log = LogFactory.getLog(SpringTest.class);
	
	Shape s;
	SimpleDateFormat sdf;
	
	public void setShape(Shape s){
		this.s = s;
	}
	
	public void setSDF(SimpleDateFormat sdf){
		this.sdf = sdf;
	}
	
	public void print(){
		log.info(s.getWidth());
		log.info(s.getHeight());
		log.info(s.getColor());
		log.info(sdf.format(s.getDate()));
	}
	
    public static void main( String[] args )
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans.xml");
        
        SpringTest spring = ctx.getBean(SpringTest.class);
        spring.print();
        
        ctx.close();
    }
}
