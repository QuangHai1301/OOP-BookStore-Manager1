/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.Author;
import DTO.Book;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class Manager 
{
    TreeSet<Book> bk = new TreeSet<>();
    ArrayList<Author> list=new ArrayList<>();
    String filename="author.dat";
    String filename1="book.dat";
    public Manager()
    {
       System.out.println("-----AUTHOR LIST------");
       list.add(new Author("NNA","Nguyen Nhat Anh\n"));
       list.add(new Author("MLA","Nizam Razak\n"));
       list.add(new Author("VN","Ho Chi Minh\n"));
       list.add(new Author("JPN","Aoyama Gosho\n"));
       list.add(new Author("NXB","Le Phong Linh\n"));
       ReadWriteFile.writeFile1(list, filename);
       ArrayList<Author> author= ReadWriteFile.readFile1(filename);
        System.out.println(author);
    }
    
    public void readFile(){
        ReadWriteFile.writeFile(bk, filename1);
        TreeSet<Book> book=ReadWriteFile.readFile();
        if (book==null)
            System.out.println("Have nothing to show");
        else
            System.out.println(book);
    }
   
    
//-----------add sach ms----------
    public boolean addBook(Book b)
    {
        return bk.add(b);
    }
    //---------------------------------
    
    
    //-------------------------------------------
    public Author searchAuthor(String authorID)
    {
        for (Author author : list) 
        {
            if(author.getAuthorID().equalsIgnoreCase(authorID))
            {
                return author;
            }
        }
 
          return null;  
    }
    //-----------------------------------------
    
    
    
    //----------search book thuong-----------
    public void searchNormal(String searchTitle)
    {
        boolean tm = false;
        for (Book book : bk) 
        {
            if(book.getTitle().toLowerCase().contains(searchTitle.toLowerCase()))
            {
                System.out.println(book);
                tm = true;
            }
        }
        if(tm == false)
        {
            System.out.println("Book is not exist!!!");
        }
        else
        {
            System.out.println("Search successfully");
        }
                    
    }
    //----------------------------------------------------------
    
   
    //-----------------search remove, update-------------------
    public Book searchReUp(String searchIsbn)
    {
        for (Book book : bk) 
        {
            if(book.getIsbn().equalsIgnoreCase(searchIsbn))
            {
                return book;
            }
        }
        return null;
    }
    
    //---------------------------------------------------------
    
    
    //--------------------remove----------------------------
    public void removeBook(String remove)
    {
        Scanner sc = new Scanner (System.in);
        int choiceRe =0;
        boolean connhapRe = false;
        Book kq = searchReUp(remove);
        
        if(kq == null)
        {
            System.out.println("Book is not exist");
        }
        if(kq != null)
        {
           System.out.println(kq);
           System.out.println("Do you really want to remove this Book??");
           System.out.println("1. Yes");
           System.out.println("2. No");
           
           //---------try catch remove book--------------------------
           do
           {
               try
               {
                    sc = new Scanner (System.in);
                    System.out.println("Chose your option: ");
                    choiceRe = sc.nextInt();
                    if(choiceRe < 0 || choiceRe > 2 )
                        throw new Exception();
                    connhapRe = false;
               }
               catch(Exception e)
               {
                    System.err.println("Your Choice is not available!!");
                    connhapRe = true;
               }
           }while(connhapRe);
           //-------------------------------------------
           
           //------------------choice agree remove book----------------
           switch(choiceRe)
           {
               case 1:
                   bk.remove(kq);
                   System.out.println("Remove Book successfully!!");
                   break;
               case 2:
                   System.out.println("Back to main menu!!");
                   break;
           }
               
        }
        
    }
    //-----------------------------------------------------------------------------------------
    
    
    //--------------------update----------------------
    public void updateInf(String isbn)
    {
        int choiceUp = 0;
        boolean connhapUp = false;
        Scanner sc = new Scanner (System.in);
        Book tm = searchReUp(isbn);
        if(tm == null)
        {
            System.err.println("BookID is not exist!!!");
        }
        if(tm != null)
        {
            do
            {
                System.out.println("What do you want to update??");
                System.out.println("1.Update Title");
                System.out.println("2.Update Price");
                System.out.println("3.Back to main menu!");
                
                do
                {
                    try
                    {
                        sc = new Scanner (System.in);
                        System.out.println("Input your choice: ");
                        choiceUp = sc.nextInt();
                        if(choiceUp < 0 || choiceUp > 3)
                            throw new Exception();
                        connhapUp = false;
                    }
                    catch(Exception e)
                    {
                        System.err.println("Chose option 1->3!!");
                        connhapUp = true;
                    }
                }while(connhapUp);
                
                switch(choiceUp)
                {
                    case 1:
                        boolean upc1 = false;
                        String fakeTitle ="";
                        do
                        {
                                try
                                {
                                    sc = new Scanner (System.in);
                                    System.out.println("Input new Title: ");
                                    fakeTitle = sc.nextLine();
                                    if(fakeTitle.isEmpty())
                                        throw new Exception();
                                    upc1 = false;
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Title is not available!!");
                                    upc1 = true;
                                }
                        }while(upc1);
                        tm.setTitle(fakeTitle);
                        System.out.println("Update Title Successfully");
                        break;
                        
                    case 2:
                        boolean upc2 = false;
                        float fakePrice =0;
                        do
                       {
                            try
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Input new Price: ");
                                fakePrice = sc.nextFloat();
                                if(fakePrice < 0)
                                    throw new Exception();
                                upc2 = false;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Price is not available!!");
                                upc2 = true;
                            }
                        }while(upc2);
                        tm.setPrice(fakePrice);
                        System.out.println("Update Price succesfully!!");
                        break;
                }
                        
              
            }while(choiceUp < 3);
        }
    }
    
    //-------------------------------------------------------------------------
        

    //-----------------ghi file book----------------------------
     public void writeFile(){
         String filenameOut = "bookout.dat";
         for (Book book : bk) {
             ReadWriteFile.writeFile(bk, filenameOut);
         }
         System.out.println("Write File Successfully!");
     }
     
}
