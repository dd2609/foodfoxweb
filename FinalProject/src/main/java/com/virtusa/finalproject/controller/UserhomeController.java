package com.virtusa.finalproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.finalproject.service.ProductService;
import com.virtusa.finalproject.service.UserhomeService;
import com.virtusa.finalproject.dao.OrderDao;
import com.virtusa.finalproject.dao.ProductDao;
import com.virtusa.finalproject.dao.UserHomedao;
import com.virtusa.finalproject.dao.UserHomedaoImp;
import com.virtusa.finalproject.entity.Login;
import com.virtusa.finalproject.entity.Order;
import com.virtusa.finalproject.entity.ProductModel;
import com.virtusa.finalproject.entity.UserModel;

@Controller
public class UserhomeController {

	private static Logger log = Logger.getLogger(UserhomeController.class);

	@Autowired
	private UserhomeService userhomeservice;
	private ArrayList<String> productNames = new ArrayList<>();
	private List<String> orderIds = new ArrayList<>();
	private List<String> price = new ArrayList<>();
	private List<String> quantity = new ArrayList<>();
	private List<Integer> sno = new ArrayList<Integer>();
	private ArrayList<String> productIds = new ArrayList<>();
	private double total=0.0;
	private int serialno=0;
	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private UserHomedao userhomeDao;
	
	@Autowired
	private ProductService productService;
	private Order neworder = null;
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new UserModel());
		return "register";
	}

	@RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
	public ModelAndView registerSuccess(@ModelAttribute("user") UserModel user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("register");
		}
		this.userhomeservice.registerUser(user);
		ModelAndView modelAndView = new ModelAndView("Regsuc");
		return modelAndView;
	}

	@RequestMapping(value = "/loginSuccess", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loginSuccess(@ModelAttribute("loginmodel") Login login, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("login");
		}

		ModelAndView modelAndView = new ModelAndView("welcome");
		UserModel user = this.userhomeservice.validateLoginModel(login.getEmail(), login.getPassword());
		if (user != null) {

			List<ProductModel> products = productDao.listProducts();
			System.out.println(products);
			modelAndView = new ModelAndView("welcome", "productModel", products);
			modelAndView.addObject("products", products);
			modelAndView.addObject("useremail", login.getEmail());
			return modelAndView;
		} else {
			modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}

	@RequestMapping({ "/buyProduct" })
	public String buyProduct(HttpServletRequest request, Model model,
			@RequestParam(value = "id", defaultValue = "") int productId) {
		if (productId == 0) {
			return "redirect:/loginsuccess";
		}

		ProductModel product = null;
		if (productId != 0 && productId > 0) {
			product = productDao.findProduct(productId);
		}
		if (product != null) {
			if (product.getQuantity() == 0) {
				log.error("Product out of stock having code " + productId);
			}
			model.addAttribute("product", product);
		}
		return "confirmation";
	}

	@RequestMapping(value = { "/purchase" }, method = RequestMethod.POST)
	@Transactional
	public String purchaseProduct(HttpServletRequest request, Model model) {
		int productId = Integer.parseInt(request.getParameter("productId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String username = request.getParameter("username");
		Order order = orderDao.saveOrder(productId, quantity, username);
		model.addAttribute("order", order);
		if (log.isInfoEnabled())
			log.info("Product purchased having code " + productId + ", quantity " + quantity);
		return "orderDetail";
	}

	@RequestMapping(value = { "/orderList" }, method = RequestMethod.GET)
	public String getOrderByUsername(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		List<Order> list = orderDao.getOrdersByUserName(username);
		if (list.isEmpty())
			log.error("No order found");
		model.addAttribute("list", list);
		return "orderList";
	}
	
	@RequestMapping(value = { "/AddToCart" }, method = RequestMethod.POST)
	public String insertItemstoCart(HttpServletRequest request, Model model,@RequestParam int productId,@RequestParam String email) {
		
		//get user details using email
		UserModel user_info=userhomeDao.get_info_email(email);
		ProductModel product_info = productDao.getProductById(productId);
		List<Order> finalOrder = new ArrayList<>();
		
		//get the table list from orders table
		List<Order> order_list = orderDao.getOrdersByUserName(user_info.getUsername());
		if(order_list.size()==0 || order_list.isEmpty()) {
			productIds.add(String.valueOf(productId));
			productNames.add(product_info.getProductName());
			orderIds.add("1");
			price.add(String.valueOf(product_info.getPrice()));
			quantity.add("1");
			sno.add(serialno++);
			//add the new order to the orders table
			total+=product_info.getPrice();
			neworder=orderDao.saveOrder(productId, 1, user_info.getUsername());
		}
		else {
			
			for(int i=0;i<order_list.size();i++) {
				String productName =  product_info.getProductName();
				if(productNames.contains(productName)) {
					System.out.println("Present_order----"+order_list.get(i));
					int prod_index = productNames.indexOf(productName);
					int initialQuantity = order_list.get(prod_index).getQuantity();
					initialQuantity+=1;
					double amount = order_list.get(i).getAmount()*Double.valueOf(initialQuantity);
					price.set(prod_index, String.valueOf(amount));
					quantity.set(prod_index, String.valueOf(initialQuantity));
					finalOrder = orderDao.updateOrder(productId, user_info.getId(), amount, initialQuantity,email);
					total+=order_list.get(i).getAmount();
				}
				else{
					//add the new order to the orders table
					System.out.println("Inserting new order for "+productId);
					neworder=orderDao.saveOrder(productId, 1, user_info.getUsername());
					productIds.add(String.valueOf(productId));
					productNames.add(productName);
					orderIds.add(String.valueOf(serialno));
					price.add(String.valueOf(neworder.getAmount()));
					quantity.add(String.valueOf(neworder.getQuantity()));
					sno.add(serialno++);
					total+=neworder.getAmount();
				}
			}
			
		}
//		for(int i=0;i<price.size();i++) {
//			total+=Double.parseDouble(price.get(i));
//		}
		model.addAttribute("productIds",productIds.toArray());
		model.addAttribute("productNames",productNames.toArray());
		model.addAttribute("orderIds",orderIds.toArray());
		model.addAttribute("price",price.toArray());
		model.addAttribute("quantity",quantity.toArray());
		model.addAttribute("serial_no",sno);
		model.addAttribute("total",total);
		return "cart";
	}
	
	@RequestMapping(value = { "/Checkout" }, method = RequestMethod.POST)
	public String checkout(HttpServletRequest request, Model model) {
		return "product";
	}

}
