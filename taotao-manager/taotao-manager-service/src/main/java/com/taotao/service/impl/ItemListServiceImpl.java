package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.comm.pojo.EasyUIDataResult;
import com.taotao.domain.TbItem;
import com.taotao.domain.TbItemQuery;
import com.taotao.mapper.TbItemDao;
import com.taotao.service.ItemListService;

@Service
public class ItemListServiceImpl implements ItemListService{

	@Autowired
	private TbItemDao tbItemDao;
	@Override
	public EasyUIDataResult getTbItemList(Integer page, Integer rows) {
		
		TbItemQuery example = new TbItemQuery();
		//分页查询
		PageHelper.startPage(page, rows);
		List<TbItem> list = tbItemDao.selectByExample(example);
		
		PageInfo<TbItem> PageInfo = new PageInfo(list);
		
		EasyUIDataResult easyUIdataResult = new EasyUIDataResult();
		easyUIdataResult.setRows(list);
		easyUIdataResult.setTotal(PageInfo.getTotal());
		
		return easyUIdataResult;
	}

}
