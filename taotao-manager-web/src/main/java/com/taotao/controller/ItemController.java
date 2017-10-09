package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.comm.pojo.EasyUIDataResult;
import com.taotao.service.ItemListService;

@Controller
public class ItemController {

	@Autowired
	private  ItemListService itemListService;
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataResult getItemListByPage(Integer page, Integer rows) {
		System.out.println("+++++++++++++++");
		EasyUIDataResult list = itemListService.getTbItemList(page, rows);
		System.out.println("________________");
		System.out.println(list.getTotal()+">>>>>>>>>>>>>>>");
	return list;
	}
}
