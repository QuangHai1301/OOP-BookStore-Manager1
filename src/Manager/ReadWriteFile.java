/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.Author;
import DTO.Book;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class ReadWriteFile 
{
     public static TreeSet<Book> readFile(){
                FileInputStream fis =null;
                ObjectInputStream ois =null;
                try{
                    fis = new FileInputStream("book.dat");
                    ois = new ObjectInputStream(fis);
                    TreeSet<Book> kq=(TreeSet<Book>) ois.readObject();
                    return kq;
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
        finally{
                try{
                    if(fis!=null) fis.close();
                    if(ois!=null) ois.close();
                }catch (Exception e){
                System.out.println(e.getMessage());
                }
    }
        return null;
}
    
    public static void writeFile(TreeSet<Book> t, String filename){
                FileOutputStream f=null;
                ObjectOutputStream df=null;
                try{
                    f=new FileOutputStream(filename);
                    df=new ObjectOutputStream(f);
                    if (t!=null && !t.isEmpty())
                        df.writeObject(t);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
        finally{
                try{
                    if(f!=null) f.close();
                    if(df!=null) df.close();
                }catch (Exception e){
                System.out.println(e.getMessage());
                }
    }
}
    //---------------------------------------------------------------
    
     public static ArrayList<Author> readFile1(String filename){
                FileInputStream f=null;
                ObjectInputStream df=null;
                try{
                    f=new FileInputStream(filename);
                    df=new ObjectInputStream(f);
                    ArrayList<Author> kq1=(ArrayList<Author>) df.readObject();
                    return kq1;
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
        finally{
                try{
                    if(f!=null) f.close();
                    if(df!=null) df.close();
                }catch (Exception e){
                System.out.println(e.getMessage());
                }
    }
        return null;
}
     public static void writeFile1(ArrayList<Author> t1, String filename){
                FileOutputStream f=null;
                ObjectOutputStream df=null;
                try{
                    f=new FileOutputStream(filename);
                    df=new ObjectOutputStream(f);
                    if (t1!=null && !t1.isEmpty())
                        df.writeObject(t1);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
        finally{
                try{
                    if(f!=null) f.close();
                    if(df!=null) df.close();
                }catch (Exception e){
                System.out.println(e.getMessage());
                }
    }
}
}
