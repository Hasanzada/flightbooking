package dao;

import entity.Flight;
import entity.Identifiable;
import utils.Utils;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOAbstractFileBean<A extends Identifiable> implements DAO<A> {

  private File file;

  public DAOAbstractFileBean(String filename){
    file = new File(filename);
  }

  @Override
  public Collection<A> getAll() {
    try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      Object readed = ois.readObject();
      List<A> as = (List<A>) readed;
      return as;
    } catch (ClassNotFoundException ex) {
      throw new RuntimeException("Deserialization error. Didn't you forget to include 'serialVersionUID field' in your entity?", ex);
    } catch (FileNotFoundException ex) {
      generateFile();
      return getAll();
    } catch (IOException ex) {
      throw new RuntimeException("Something went wrong", ex);
    }
  }

  @Override
  public Collection<A> getAllBy(Predicate<A> p) {
    return getAll().stream().filter(p).collect(Collectors.toList());
  }

  @Override
  public Optional<A> get(int id) {
    return getAll().stream().filter(p -> p.getId() == id).findFirst();
  }

  @Override
  public void create(A data) {
    Collection<A> as = getAll();
    as.add(data);
    write(as);
  }

  @Override
  public void delete(int id) {
    Collection<A> as = getAllBy(p -> p.getId() != id);
    write(as);
  }

  private void write(Collection<A> as) {
    try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
        oos.writeObject(as);
    }  catch (IOException ex) {
      throw new RuntimeException("DAO:write:IOException", ex);
    }
  }

  public void generateFile() {
      try {
        write((Collection<A>) Utils.getFlights());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }


}
