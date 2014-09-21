package com.grepperz.controller;
 
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grepperz.form.SearchForm;
import com.grepperz.model.DbInitializer;
import com.grepperz.model.Entity;
import com.grepperz.service.SearchService;
import com.grepperz.service.impl.SearchServiceImpl;
import com.grepperz.util.ItemPopulator;
import com.grepperz.util.JsonHelper;
 
@Controller
@RequestMapping("/")
public class BaseController {
 
/*	@RequestMapping(value="welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
 
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
 
	}

*/	
	
	@RequestMapping(value="/getSearchForm", method = RequestMethod.GET)
	public String showSearch(@ModelAttribute("searchForm")SearchForm form,ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value = "/searchData", method = RequestMethod.POST)
	public String searchData(@ModelAttribute("searchForm")SearchForm form,ModelMap model) {
		model.addAttribute("query",form.getQuery() );
	    model.addAttribute("location", form.getLocation());
	    
	    SearchService service = new SearchServiceImpl();
	    String jsonData = service.getSearchData("http://api-v1-dotmic.in/?search="+ URLEncoder.encode(form.getQuery())+"&start-index=0&max-results=10&ua=UA-2b1c1fd59338a2da58eaa31df3621d92");
	    List<Entity> entityList = JsonHelper.unmarshall(jsonData);
	    ItemPopulator populator = new ItemPopulator();
	    for(Entity e : entityList){
	    	Map<String,String> map = new HashMap<>();
	    	map.put("title", e.getTitle());
	    	map.put("description", e.getDescription());
	    	populator.createNode(map);
	    }
	    return "result";
	 }

	
/*	@RequestMapping(value="welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " + name);
		return "index";
 
	}
*/ 
}