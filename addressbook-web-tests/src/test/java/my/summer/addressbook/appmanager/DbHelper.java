package my.summer.addressbook.appmanager;

import my.summer.addressbook.models.ContactData;
import my.summer.addressbook.models.Contacts;
import my.summer.addressbook.models.GroupData;
import my.summer.addressbook.models.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData").list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
//    for (ContactData contact : result) {
//      System.out.println(contact);
//    }
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }

  public List<GroupData> linkToContactGroupId(int contactId) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    //String hql = String.format("from address_in_groups ag where ag.contactId = %s", contactId);
    List<ContactData> result = session.createQuery(String.format("from ContactData cd where deprecated = '0000-00-00' and cd.id = %s", contactId)).list();
    result.forEach(g -> System.out.println(g.getGroups()));
    List<GroupData> addgroups = new ArrayList<>();
    for(ContactData contact : result){
      if(result.size()==1) {
        addgroups = new ArrayList<>(contact.getGroups());
      }
    }
    session.getTransaction().commit();
    session.close();
    return addgroups;
  }

}
