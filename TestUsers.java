package entity;

import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

public class TestUsers {
	@Test
	public void testSchemaExport() {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();  
	    Metadata metadata = new MetadataSources(registry).buildMetadata();  
	    SchemaExport export = new SchemaExport();  
	    export.create(EnumSet.of(TargetType.DATABASE),metadata);  
	    
//	    Configuration config = new Configuration().configure();
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();  
//		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
//		
//		Session session = sessionFactory.getCurrentSession();
//		SchemaExport export = new SchemaExport();  
//	    export.create(true, true);  
		
		
	}
}
