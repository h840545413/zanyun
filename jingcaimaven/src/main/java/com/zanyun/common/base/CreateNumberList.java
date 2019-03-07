package com.zanyun.common.base;

public class CreateNumberList {
	

public static  String createPageDiv(Integer start, Integer total) {
Integer s=	start-2;
Integer e=	start+2;


if(total-start<3)
{
	s=total-4;
	e=total;
}
if(start<3)
{
	s=1;
	e=5;
}
if(total<6)
{
	s=1;
	e=total;
}
for (int i = s; i < e+1; i++) {
	System.out.println(i);
}
	return "success";

}
public static void main(String[] args)
{
	createPageDiv(3,4);
}
}
