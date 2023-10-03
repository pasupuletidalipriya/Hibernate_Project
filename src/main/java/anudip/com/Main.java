package anudip.com;
import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main
{
	public static void main(String[] args)
	{
		    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("Hibernate.config.xml").build();
			Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
			
			SessionFactory sfactory=meta.buildSessionFactory();
			Session session=sfactory.openSession();
			
			Transaction t=session.beginTransaction();
			try
			{
				Company c=new Company();
				c.setCompanyId(1104);
				c.setCompanyName("LG");
				
				Company c1=new Company();
				c.setCompanyId(1005);
				c.setCompanyName("Panasonic");
				
				
				Product p=new Product();
				p.setProductId(224);
				p.setProductName("AC");
				
				
				Product p1=new Product();
				p1.setProductId(333);
				p1.setProductName("TV");
				

				Product p2=new Product();
				p2.setProductId(235);
				p2.setProductName("Washing Machine");
				
				c.getProductset().add(p);
				c.getProductset().add(p1);
				c.getProductset().add(p2);
				
				c1.getProductset().add(p);
				c1.getProductset().add(p1);
				
				session.save(p);
				session.save(p1);
				session.save(p2);
				
				session.save(c);
				session.save(c1);
				
				t.commit();
				
			}
			finally
			{
				sfactory.close();
				session.close();
			}
	}
}
