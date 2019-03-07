package com.zanyun.outer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OuterController {
	@RequestMapping(value="outer!checkDongleKey.action",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> outer()
	{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code", "0000");
		return map;
	}

}
