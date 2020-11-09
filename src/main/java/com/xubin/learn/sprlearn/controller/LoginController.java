package com.xubin.learn.sprlearn.controller;

import com.xubin.learn.sprlearn.dao.ItemRepository;
import com.xubin.learn.sprlearn.entity.Item;
import com.xubin.learn.sprlearn.entity.Product;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

	@Autowired
	private ItemRepository itemRepository;
	@ResponseBody
	@RequestMapping("/admin")
	public String getAdmin() {
		List<Product> pdlist=new ArrayList<>();
		Product p1=new Product(1L,"xubin1",1L);
		Product p2=new Product(2L,"xubin2",2L);
		pdlist.add(p1);
		pdlist.add(p2);
		Item item = new Item(1L, "小米手机7", "手机",
				"小米", 3499.00, "http://image.baidu.com/13123.jpg",pdlist);
		itemRepository.save(item);
		Iterable<Item> list=itemRepository.findAll();
		NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
		queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米手机"));
		Page<Item> plist=this.itemRepository.search(queryBuilder.build());

	  return "admin";
	}
	
	@ResponseBody
	@RequestMapping("/user")
	public String getUser(String username,String password) {
	  return "user";
	}
	
	@Secured(value="ROLE_ADMIN")
	@ResponseBody
	@RequestMapping("/other")
	public String getOther(String username,String password) {
	  return "other";
	}

}
