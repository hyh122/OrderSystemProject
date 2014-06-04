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
		//������ʾ�˿���ʷ����
		List<cHistoryOrder> l=new ArrayList<cHistoryOrder>();
		dis_historyOrder d=new dis_historyOrder();
		l=d.getHisOrderBycNo("c2005001");
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i).getOrderNo());
		
		//�������ɶ�����
	//	CUI_Control c=new CUI_Control();
//		c.createOrderNo();
//		System.out.println(c.getOrderNo());
		
		//���������ﳵ����Ӷ����ķ���
		//c.addOrder("1223", "�ɿ���", "4", "50");
		
		//������ʾԱ������ʷ����
//		List<cHistoryOrder> l=new ArrayList<cHistoryOrder>();
//		dis_historyOrder d=new dis_historyOrder();
//		l=d.getHisOrderByeName("E2005003");
//		for(int i=0;i<l.size();i++){
//			System.out.println(l.get(i).getOrderNo());
		}
	}
	//����ϵͳ����Ա
	public static void testManager() throws IOException, ClassNotFoundException, SQLException{
		ManagerService managerservice=new ManagerService();
		//�������ϵͳ����Ա����
		//managerservice.addManager("S0002","����","111111");
		
		//���԰�id��ɾ��ϵͳ����Ա
		//managerservice.deleteManagerById("S0001");
		//���԰�����ɾ��ϵͳ����Ա
		//managerservice.deleteManagerByName("����");
		
		//���Ը���ϵͳ����Ա��Ϣ
//		String sql="update manager set managerName=?" +"where managerId='S0002'";
//		managerservice.updateManager(sql, "����");
		
		
		//���԰����û�id�����û���Ϣ
//		Manager manager=new Manager();
//		manager=managerservice.queryManagerById("S0002");
//		System.out.println(manager);
		
		//���԰����û������������û���Ϣ
//		Manager manager=new Manager();
//		boolean k=managerservice.queryManagerById1("");
//		System.out.println(k);
	}
	
	//����Ա����
		public static void testEmployee() throws IOException, ClassNotFoundException, SQLException{
			EmployeeService employeeservice=new EmployeeService();
//			List<Employee> eList=new ArrayList<Employee>();
//			eList=employeeservice.getAllEmployee();
//			for(int i=0;i<eList.size();i++){
//				System.out.println(eList.get(i));
//			}
			//�������Ա������
			//employeeservice.addEmployee("E2008005","����","��","1990-12-08","����","13877654231","2008-08-12","�칫��","ְԱ","4500");
			
			//���԰�Ա����ɾ��Ա��
			employeeservice.deleteEmployeeById("E2005001");
			
			//���԰�����ɾ��Ա��
			//employeeservice.deleteEmployeeByName("����");
			
			//���Ը���Ա����Ϣ
			//String sql="update employee set address=?" +"where employeeno='E2008003'";
			//employeeservice.updateEmployee(sql, "������");
			
			
			//���԰���Ա���Ų���Ա����Ϣ
//			Employee employee=new Employee();
//			employee=employeeservice.queryEmployeeById("E2008003");
//			System.out.println(employee);
//			
			//���԰���Ա����������Ա����Ϣ
//			Employee employee=new Employee();
//			employee=employeeservice.queryEmployeeByName("��С��");
//			System.out.println(employee);
		}
		
		//���Կͻ���
				public static void testCustomer() throws IOException, ClassNotFoundException, SQLException{
				CustomerService customerservice=new CustomerService();
					//������ӿͻ�����
			//customerservice.addCustomer("c2008002","ƥ�˼���","Ȫ����","022-1254367","112345");
//				customerservice.addCustomer("c2008003","��̤����","Ȫ����","022-1254367","112345");	
					//���԰��ͻ���ɾ���ͻ�
				//customerservice.deleteCustomerById("c2005004");
					
					//���԰�����ɾ���ͻ�
				//customerservice.deleteEmployeeByName("��̤����");
					
					//���Ը��¿ͻ���Ϣ
//					String sql="update customer set address=?" +"where customerno='c2005004'";
//					customerservice.updateCustomer(sql, "������");
					
					
					//���԰��տ͑��Ų��ҿͻ���Ϣ
					Customer customer=new Customer();
					customer=customerservice.queryCustomerById("c2005001");
					System.out.println(customer);
					
//					//���԰��տͻ��������ҿͻ���Ϣ
//				Customer customer=new Customer();
//				customer=customerservice.queryCustomerByName("��һ����");
//				System.out.println(customer);
				}
				
				//���Բ�Ʒ��
		public static void testProduct() throws IOException, ClassNotFoundException, SQLException{
				ProductService productservice=new ProductService();
					//������Ӳ�Ʒ����
//				productservice.addProduct("c2008004","�ڴ濨","�ڴ�",54);
//				productservice.addProduct("c2008005","�ڴ濨","�ڴ�",84);
					//���԰���Ʒ��ɾ����Ʒ
				//productservice.deleteProductById("c2008004");
					
					//���԰�����ɾ���ͻ�
			//	productservice.deleteProductByName("�ڴ濨");
					
//					//���Ը��¿ͻ���Ϣ
//					String sql="update product set productprice=?" +"where productno='p2005001'";
//					productservice.updateProduct(sql, 90.9);
//					
					
					//���԰��տ͑��Ų��ҿͻ���Ϣ
//				Product product=new Product();
//					product=productservice.queryProductById("P2005001");
//					System.out.println(product);
					
					//���԰��տͻ��������ҿͻ���Ϣ
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
				pList=productservice.getProductByClassAndprice("����", "500", "1000");
				//pList=productservice.getProductByClass("����");
				for(int i=0;i<pList.size();i++)
				System.out.println(pList.get(i));
				
		}
		

				
	//���Զ���������
				public static void testOrderMaster() throws IOException, ClassNotFoundException, SQLException{
				OrderMasterService omservice=new OrderMasterService();
		//������Ӳ�Ʒ����
			//	omservice.addOrderMaster("20080612003","c2005003","e2005002","2012-12-12",10000,"l000000011");
//				productservice.addProduct("c2008005","�ڴ濨","�ڴ�",84);
					//���԰���Ʒ��ɾ����Ʒ
				//omservice.deleteOrderMasterById("200801090002");
					
					//���԰�����ɾ���ͻ�
			//	productservice.deleteProductByName("�ڴ濨");
					
//					//���Ը��¿ͻ���Ϣ
//				String sql="update ordermaster set orderdate=?" +"where orderno='200801090001'";
//					omservice.updateOrderMaster(sql, "2012-12-15");
//				
				OrderMaster om=new OrderMaster();
				om=omservice.queryOrderBysaleno("");
				System.out.println(om);	
					

				}
				
	//���Զ�����ϸ
	public static void testOd() throws IOException, ClassNotFoundException, SQLException{
		OdService odservice=new OdService();
		//������Ӷ�����ϸ����
	odservice.addod("200802190001","p2005001",5,250);
				
			//���԰�������ɾ��������ϸ
	//			odservice.deleteodById("200801090003");
					
			
					
//					//���Ը��¶�������ϸ
//				String sql="update orderdetail set price=?" +"where orderno='200801090002' and productno='p2006002'";
//				odservice.updateod(sql,200);
//					
					
				
				}
}
