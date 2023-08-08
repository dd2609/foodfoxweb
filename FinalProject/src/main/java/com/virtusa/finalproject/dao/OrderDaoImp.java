package com.virtusa.finalproject.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.virtusa.finalproject.entity.Order;
import com.virtusa.finalproject.entity.ProductModel;
import com.virtusa.finalproject.entity.UserModel;

@Transactional
@Repository
public class OrderDaoImp implements OrderDao {
	
	@Autowired
    private SessionFactory sessionFactory;
 
    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private UserHomedao userhomeDao;
    
    private int getMaxOrderNum() {
        String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        Integer value = (Integer) query.uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }

	@Override
	public Order saveOrder(int productId, int quantity, String username) {
		Session session = sessionFactory.getCurrentSession();

        int orderNum = this.getMaxOrderNum() + 1;
       
        UserModel user = userhomeDao.findAccount(username); 
        ProductModel product = productDao.getProductById(productId);
//        product.setQuantity(product.getQuantity()-quantity);
        Order order = new Order();
        order.setOrderNum(orderNum);
        order.setOrderDate(new Date(orderNum));
        order.setAmount(quantity * (product.getPrice()));
        order.setQuantity(quantity);
        order.setUser(user);
        order.setProduct(product);
//        session.save(order);
       
        String sql = "insert into foodfox2.orders (amount,orderDate,orderNum,quantity,productId,id) values("+order.getAmount()+",'"+order.getOrderDate()+"',"+order.getOrderNum()+","+order.getQuantity()+","+productId+","+user.getId()+")";
        System.out.println(sql);
        Query query = session.createNativeQuery(sql);
        query.executeUpdate();
        return order;
    }
	
	public Order findOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Order.class);
        crit.add(Restrictions.eq("o_id", orderId));
        return (Order) crit.uniqueResult();
    }

	@SuppressWarnings("unchecked")
	
	@Override
	public List<Order> getOrdersByUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		UserModel user =userhomeDao.findAccount(username); 
        @SuppressWarnings("deprecation")
		Criteria crit = session.createCriteria(Order.class);
        crit.add(Restrictions.eq("user.id",user.getId()));
        List<Order> list = (List<Order>) crit.list();
		return list;
	}
	
	@Override
	public Order getOrderByProdID_UserId(int productId, int userId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from foodfox2.orders where productId="+productId+" and id="+userId;
		Query query = session.createNativeQuery(sql);
		return (Order) query.getSingleResult();
	}
	
	@Override
	public List<Order> updateOrder(int productId, int userId,double price, int quantity,String email) {
		Session session = sessionFactory.getCurrentSession();
		//update the price and quantity of all the rows having prod id and user id as given
		String sql = "update foodfox2.orders set amount = "+price+",quantity = "+quantity+" where id="+userId+" and productId="+productId;
		System.out.println(sql);
        Query query = session.createNativeQuery(sql);
        query.executeUpdate();
        UserModel user_info = userhomeDao.get_info_email(email);
        List<Order> orders = getOrdersByUserName(user_info.getUsername());
        return orders;
	}
	
	@Override
	public List<Order> getAllOrders(){
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from foodfox2.orders";
		Query query = session.createNativeQuery(sql);
		List<Order> orders = query.getResultList();
		return orders;
	}

}
