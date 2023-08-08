package com.virtusa.finalproject.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.finalproject.dao.OrderDao;
import com.virtusa.finalproject.entity.Admin;
import com.virtusa.finalproject.entity.Order;
import com.virtusa.finalproject.entity.ProductModel;
import com.virtusa.finalproject.service.AdminService;
import com.virtusa.finalproject.service.AdminServiceImp;
import com.virtusa.finalproject.service.ProductService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static Logger log = Logger.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(value ="/" ,method=RequestMethod.GET)
	public String homePage(){
		return "index";
	}
	
	@RequestMapping(path = "/product", method = {RequestMethod.POST,RequestMethod.GET})
	public String checkLoginCrenditials(@RequestParam("email") String email, @RequestParam("password") String password,Model model) {
		
		Admin admin = this.adminService.checkLoginForAdmin(email, password);
		if(admin!=null && admin.getPassword().equalsIgnoreCase(password)) {
			log.info("Admin login..");
			return "result";
		}
		else {
			return "index";
		}

	}
	
	@RequestMapping(path = "/products", method = {RequestMethod.POST,RequestMethod.GET})
	public String listProduct(Model model) {
		model.addAttribute("product", new ProductModel());
		model.addAttribute("listProducts", this.productService.listProducts());
		return "product";
	}
	

	@RequestMapping(path= "/products/add", method = {RequestMethod.POST})
	public String addProduct(@ModelAttribute("product") ProductModel p){
		
		if(p.getProductId() == 0){
			this.productService.addProduct(p);
		}
		else{
			this.productService.updateProduct(p);
		}
		
		return "redirect:/admin/products";	
	}	
	
	@RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
        this.productService.removeProduct(id);
        return "redirect:/admin/products";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }
	 
	 
    @RequestMapping(path = "/viewOrders", method = {RequestMethod.POST,RequestMethod.GET})
	public String OrdersList(Model model) {
    	List<Order> list_orders = orderDao.getAllOrders();
    	model.addAttribute("list_orders",list_orders);
    	System.out.println(String.valueOf(list_orders.get(0)));
		return "orderDetails";
	}
	

}
