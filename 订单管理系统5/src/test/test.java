package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orsystem.DataService.CustomerService;
import com.orsystem.DataService.EmployeeService;
import com.orsystem.DataService.ManagerService;
import com.orsystem.DataService.OdService;
import com.orsystem.DataService.OrderMasterService;
import com.orsystem.DataService.ProductService;
import com.orsystem.DataTable.Customer;
import com.orsystem.DataTable.Employee;
import com.orsystem.DataTable.Manager;
import com.orsystem.DataTable.OrderMaster;
import com.orsystem.DataTable.Product;
import com.orsystem.Modal.cHistoryOrder;
import com.orsystem.control.CUI_Control;
import com.orsystem.control.dis_Date;
import com.orsystem.control.dis_historyOrder;



public class test {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		String sql="delete from employee where employeeno='E2008005'";
//		JDBCTools.update(sql);
		//testManager();
		//testEmployee();
		//testCustomer();
		//testOrderMaster();
		//testProduct();
//		dis_Date d=new dis_Date();
//		System.out.println(d.get_curDate());
//		
		//测试显示顾客历史订单
		List<cHistoryOrder> l=new ArrayList<cHistoryOrder>();
		dis_historyOrder d=new dis_historyOrder();
		l=d.getHisOrderBycNo("c2005001");
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i).getOrderNo());
		
		//测试生成订单号
	//	CUI_Control c=new CUI_Control();
//		c.createOrderNo();
//		System.out.println(c.getOrderNo());
		
		//测试往购物车中添加订单的方法
		//c.addOrder("1223", "巧克力", "4", "50");
		
		//测试显示员工的历史订单
//		List<cHistoryOrder> l=new ArrayList<cHistoryOrder>();
//		dis_historyOrder d=new dis_historyOrder();
//		l=d.getHisOrderByeName("E2005003");
//		for(int i=0;i<l.size();i++){
//			System.out.println(l.get(i).getOrderNo());
		}
	}
	//测试系统管理员
	public static void testManager() throws IOException, ClassNotFoundException, SQLException{
		ManagerService managerservice=new ManagerService();
		//测试添加系统管理员方法
		//managerservice.addManager("S0002","张三","111111");
		
		//测试按id号删除系统管理员
		//managerservice.deleteManagerById("S0001");
		//测试按姓名删除系统管理员
		//managerservice.deleteManagerByName("张三");
		
		//测试更新系统管理员信息
//		String sql="update manager set managerName=?" +"where managerId='S0002'";
//		managerservice.updateManager(sql, "李四");
		
		
		//测试按照用户id查找用户信息
//		Manager manager=new Manager();
//		manager=managerservice.queryManagerById("S0002");
//		System.out.println(manager);
		
		//测试按照用户姓名来查找用户信息
//		Manager manager=new Manager();
//		boolean k=managerservice.queryManagerById1("");
//		System.out.println(k);
	}
	
	//测试员工类
		public static void testEmployee() throws IOException, ClassNotFoundException, SQLException{
			EmployeeService employeeservice=new EmployeeService();
//			List<Employee> eList=new ArrayList<Employee>();
//			eList=employeeservice.getAllEmployee();
//			for(int i=0;i<eList.size();i++){
//				System.out.println(eList.get(i));
//			}
			//测试添加员工方法
			//employeeservice.addEmployee("E2008005","张三","男","1990-12-08","厦门","13877654231","2008-08-12","办公室","职员","4500");
			
			//测试按员工号删除员工
			employeeservice.deleteEmployeeById("E2005001");
			
			//测试按姓名删除员工
			//employeeservice.deleteEmployeeByName("李虹冰");
			
			//测试更新员工信息
			//String sql="update employee set address=?" +"where employeeno='E2008003'";
			//employeeservice.updateEmployee(sql, "厦门市");
			
			
			//测试按照员工号查找员工信息
//			Employee employee=new Employee();
//			employee=employeeservice.queryEmployeeById("E2008003");
//			System.out.println(employee);
//			
			//测试按照员工名来查找员工信息
//			Employee employee=new Employee();
//			employee=employeeservice.queryEmployeeByName("张小东");
//			System.out.println(employee);
		}
		
		//测试客户类
				public static void testCustomer() throws IOException, ClassNotFoundException, SQLException{
				CustomerService customerservice=new CustomerService();
					//测试添加客户方法
			//customerservice.addCustomer("c2008002","匹克集团","泉州市","022-1254367","112345");
//				customerservice.addCustomer("c2008003","安踏集团","泉州市","022-1254367","112345");	
					//测试按客户号删除客户
				//customerservice.deleteCustomerById("c2005004");
					
					//测试按姓名删除客户
				//customerservice.deleteEmployeeByName("安踏集团");
					
					//测试更新客户信息
//					String sql="update customer set address=?" +"where customerno='c2005004'";
//					customerservice.updateCustomer(sql, "厦门市");
					
					
					//测试按照客戶号查找客户信息
					Customer customer=new Customer();
					customer=customerservice.queryCustomerById("c2005001");
					System.out.println(customer);
					
//					//测试按照客户名来查找客户信息
//				Customer customer=new Customer();
//				customer=customerservice.queryCustomerByName("五一商厦");
//				System.out.println(customer);
				}
				
				//测试产品类
		public static void testProduct() throws IOException, ClassNotFoundException, SQLException{
				ProductService productservice=new ProductService();
					//测试添加产品方法
//				productservice.addProduct("c2008004","内存卡","内存",54);
//				productservice.addProduct("c2008005","内存卡","内存",84);
					//测试按商品号删除商品
				//productservice.deleteProductById("c2008004");
					
					//测试按姓名删除客户
			//	productservice.deleteProductByName("内存卡");
					
//					//测试更新客户信息
//					String sql="update product set productprice=?" +"where productno='p2005001'";
//					productservice.updateProduct(sql, 90.9);
//					
					
					//测试按照客戶号查找客户信息
//				Product product=new Product();
//					product=productservice.queryProductById("P2005001");
//					System.out.println(product);
					
					//测试按照客户名来查找客户信息
//					List<Product> pList;
//					pList=productservice.getAllProduct();
//					for(int i=0;i<pList.size();i++)
//					System.out.println(pList.get(i));
//				String[] s=new String[]{};
//				 s=productservice.getAllClassName();
//				
//				for(int i=0;i<s.length ;i++){
//					System.out.println(s[i]);
//				}
				
				List<Product> pList;
				pList=productservice.getProductByClassAndprice("主板", "500", "1000");
				//pList=productservice.getProductByClass("主板");
				for(int i=0;i<pList.size();i++)
				System.out.println(pList.get(i));
				
		}
		

				
	//测试订单管理类
				public static void testOrderMaster() throws IOException, ClassNotFoundException, SQLException{
				OrderMasterService omservice=new OrderMasterService();
		//测试添加产品方法
			//	omservice.addOrderMaster("20080612003","c2005003","e2005002","2012-12-12",10000,"l000000011");
//				productservice.addProduct("c2008005","内存卡","内存",84);
					//测试按商品号删除商品
				//omservice.deleteOrderMasterById("200801090002");
					
					//测试按姓名删除客户
			//	productservice.deleteProductByName("内存卡");
					
//					//测试更新客户信息
//				String sql="update ordermaster set orderdate=?" +"where orderno='200801090001'";
//					omservice.updateOrderMaster(sql, "2012-12-15");
//				
				OrderMaster om=new OrderMaster();
				om=omservice.queryOrderBysaleno("");
				System.out.println(om);	
					

				}
				
	//测试订单明细
	public static void testOd() throws IOException, ClassNotFoundException, SQLException{
		OdService odservice=new OdService();
		//测试添加订单明细方法
	odservice.addod("200802190001","p2005001",5,250);
				
			//测试按订单号删除订单明细
	//			odservice.deleteodById("200801090003");
					
			
					
//					//测试更新定的那明细
//				String sql="update orderdetail set price=?" +"where orderno='200801090002' and productno='p2006002'";
//				odservice.updateod(sql,200);
//					
					
				
				}
}
