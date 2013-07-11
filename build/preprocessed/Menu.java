import java.io.IOException;
import javax.microedition.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Menu extends MIDlet implements CommandListener {
   
    Display display = null;
    List menu,brands,electronics,category= null;     
    //TextBox input = null;
    Form acc,input,product,brand,form1,form=null;
    static final Command backCommand = new Command("Back", Command.BACK, 0);
    static final Command mainMenuCommand = new Command("Main", Command.SCREEN, 1);
    static final Command exitCommand = new Command("Exit", Command.STOP, 2);
    String currentMenu,catMenu,url = null;
    private Command command,option,acback,acview,iback,edback,view,submit,mback,mselect,pback,bak,cancel,com,enter;
    TextField itemno;
    public Menu() {
     display = Display.getDisplay(this);
    }
    public void startApp() throws MIDletStateChangeException {
      Command option=new Command("Option",Command.OK,4);
      menu = new List("Menu Items", Choice.IMPLICIT);
      menu.append("Start shopping", null);
      menu.append("Order confirmation", null);
      menu.append("My account", null);
      menu.append("Order information", null);
      menu.append("Change password", null);
      menu.addCommand(option);
      menu.addCommand(exitCommand);
      menu.setCommandListener(this);
      mainMenu();
      
    }
    public void pauseApp() {
      display = null;
      menu = null;
      input = null;
    }

    public void destroyApp(boolean unconditional) {
      notifyDestroyed();
    }

    void mainMenu() {
      display.setCurrent(menu);
      currentMenu = "Main"; 
    }
    public void prepare() {
      category = new List("Select Category", Choice.IMPLICIT);
category.append("Electronics", null);
category.append("Electrical", null);
category.append("Grosery", null);
 Command view=new Command("View", Command.OK, 2);
 category.addCommand(view);
 category.setCommandListener(this);
 category.addCommand(backCommand);
       // input.setString("");
       display.setCurrent(category);
    }
    public void account() {
      List acc = new List("Account Operations", Choice.IMPLICIT);
      acc.append("Account Info", null);
      acc.append("Edit account", null);
      acc.append("Update account", null);
      Command acback=new Command("aBack",Command.BACK,0);
      Command acview=new Command("aView",Command.SCREEN,1);
      acc.addCommand(acback);
      acc.addCommand(acview);
      acc.setCommandListener(this);
     display.setCurrent(acc);
    }
    public void asspass(){
        
    }
    public void accInfo(){
        Command confirm, iback;
        StringItem userName, userAge, userSex, userOccupation, userAddress;
        StringItem userCity,userMobile,userE_mail;
        Form accinfo=new Form("Your account information");
        userName = new StringItem("Name:",null);
        userAge = new StringItem("Age:",null);
        userSex = new StringItem("Sex:",null);
        userOccupation = new StringItem("Occupation:",null);
        userAddress = new StringItem("Address:",null);
        userCity = new StringItem("City:",null);
        userMobile = new StringItem("Mobile number:",null);
        userE_mail = new StringItem("E_mail:",null);
        iback = new Command("iBack", Command.OK,0);
        confirm = new Command("Confirm", Command.OK,4);
        accinfo.append(userName);
        accinfo.append(userAge);
        accinfo.append(userSex);
        accinfo.append(userOccupation);
        accinfo.append(userAddress);
        accinfo.append(userCity);
        accinfo.append(userMobile);
        accinfo.append(userE_mail);
        accinfo.addCommand(iback);
        accinfo.addCommand(confirm);
     accinfo.setCommandListener(this);
     display.setCurrent(accinfo);
        
    }
    public void editAcc(){
        Command edback, save;
        TextField euserName,euserAge, euserSex, euserOccupation, euserAddress,euserCity,euserMobile,euserE_mail;
        ChoiceGroup eUserSex;
        
       Form editacc=new Form("Edit your information");
       euserName = new TextField("Name:","",30, TextField.ANY);
       euserAge = new TextField("Age:","",10, TextField.NUMERIC);
       euserSex = new TextField("Sex:","",10, TextField.ANY);
       euserOccupation = new TextField("Occupation:","",30, TextField.ANY);
       euserAddress = new TextField("Address:","",30, TextField.ANY);
       euserCity = new TextField("City:","",20, TextField.ANY);
       euserMobile = new TextField("Mobile number:","",10, TextField.PHONENUMBER);
       euserE_mail = new TextField("E_mail:","",20, TextField.EMAILADDR);
      edback = new Command("eBack", Command.OK,0);
        save = new Command("Save", Command.OK,4);
        editacc.append(euserName);
        editacc.append(euserAge);
        editacc.append(euserSex);
        editacc.append(euserOccupation);
        editacc.append(euserAddress);
        editacc.append(euserCity);
        editacc.append(euserMobile);
        editacc.append(euserE_mail);
        editacc.addCommand(edback);
      editacc.addCommand(save);
     editacc.setCommandListener(this);
     display.setCurrent(editacc);
        
        
        
    }
      public void prod(){
         //TextField itemno,price,quantity,desc;
         
        product=new Form("Product selection");
        itemno = new TextField("Item-number:", "", 5,TextField.NUMERIC);
        //price = new TextField("Price:", "", 10,TextField.NUMERIC);
        //quantity = new TextField("Quantity:", "", 10,TextField.NUMERIC);
        //desc = new TextField("Description:", "", 10,TextField.ANY);
        product.append(itemno);
        //product.append(price);
        //product.append(quantity);
       // product.append(desc);     
       Command cancel=new Command("Cancel", Command.CANCEL,3);
       Command enter=new Command("Enter",Command.OK,4);
      
       display.setCurrent(product);
       product.addCommand(cancel);
       product.addCommand(enter);
       product.setCommandListener(this);
          
     /* electronics=new List("Electronics",Choice.IMPLICIT);
       electronics.append("Laptops",null);
       electronics.append("Music systems",null);
       electronics.append("Mobile phones",null);
     
      Command cancel=new Command("Cancel", Command.CANCEL,3);
       Command select=new Command("Select",Command.OK,4);
      
       display.setCurrent(electronics);
       electronics.addCommand(cancel);
       electronics.addCommand(select);
       electronics.setCommandListener(this);*/
      
 }      
    /* public void electrical(){
      TextField itemno,price,quantity,desc;
         
        product=new Form("Product selection");
        itemno = new TextField("Item-number:", "", 5,TextField.NUMERIC);
        price = new TextField("Price:", "", 10,TextField.NUMERIC);
        quantity = new TextField("Quantity:", "", 10,TextField.NUMERIC);
        desc = new TextField("Description:", "", 10,TextField.ANY);
        product.append(itemno);
        product.append(price);
        product.append(quantity);
        product.append(desc);
         Command cancel=new Command("Cancel", Command.CANCEL,3);
       Command select=new Command("Select",Command.OK,4);
      
       display.setCurrent(product);
       product.addCommand(cancel);
       product.addCommand(select);
       product.setCommandListener(this);
     
       
      
       List electrical=new List("Electrical appliances",Choice.IMPLICIT);
       electrical.append("Stabilizers",null);
       electrical.append("Circuit brakers",null);
       electrical.append("Sockets",null);
       electrical.append("Extensions",null);
     
      Command eback=new Command("eBack", Command.CANCEL,3);
       Command eselect=new Command("eSelect",Command.OK,4);
      
       display.setCurrent(electrical);
       electrical.addCommand(eback);
       electrical.addCommand(eselect);
       electrical.setCommandListener(this);
      
 }  
     public void grocery(){
         TextField itemno,price,quantity,desc;
         
        product=new Form("Product selection");
        itemno = new TextField("Item-number:", "", 5,TextField.NUMERIC);
        price = new TextField("Price:", "", 10,TextField.NUMERIC);
        quantity = new TextField("Quantity:", "", 10,TextField.NUMERIC);
        desc = new TextField("Description:", "", 10,TextField.ANY);
        product.append(itemno);
        product.append(price);
        product.append(quantity);
        product.append(desc);
         Command cancel=new Command("Cancel", Command.CANCEL,3);
       Command select=new Command("Select",Command.OK,4);
      
       display.setCurrent(product);
       product.addCommand(cancel);
       product.addCommand(select);
       product.setCommandListener(this);
          
      }*/
    public void bran(){
     List brands = new List("Laptops", Choice.IMPLICIT);
      brands.append("Dell", null);
      brands.append("Toshiba", null);
      brands.append("Apple", null);
      Command bak=new Command("Bak",Command.BACK,0);
      Command see=new Command("See",Command.SCREEN,1);
      brands.addCommand(bak);
      brands.addCommand(see);
     brands.setCommandListener(this);
     display.setCurrent(brands);      
       
    }
   public void music(){
    List music = new List("Select brand", Choice.IMPLICIT);
      music.append("Sonny", null);
      music.append("Samsung", null);
      music.append("LG", null);
      Command mback=new Command("mBack",Command.BACK,0);
      Command mselect=new Command("Select",Command.SCREEN,1);
      music.addCommand(mback);
      music.addCommand(mselect);
     music.setCommandListener(this);
     display.setCurrent(music);
    }
   public void phones(){
   List  phone = new List("Select brand", Choice.IMPLICIT);
      phone.append("Nokia", null);
      phone.append("Samsung", null);
      phone.append("iPhone", null);
      phone.append("LG", null);
      Command pback=new Command("pBack",Command.BACK,0);
      Command pview=new Command("pView",Command.SCREEN,1);
      phone.addCommand(pback);
      phone.addCommand(pview);
     phone.setCommandListener(this);
     display.setCurrent(phone);
    }
    public void testItem1() {
      prepare();
      currentMenu = "Start shopping";
    }
    public void testItem2() {
       prepare();
       currentMenu = "Order confirmation"; 
    }
    public void testItem3() {
       account();
       currentMenu = "My account"; 
    }
    public void testItem4() {
       prepare();
       currentMenu = "Order information"; 
    }
    public void testItem5() {
       prepare();
       currentMenu = "Change password"; 
    }
    
public void testGET(String url) throws IOException {
        HttpConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        StringBuffer stringBuffer = new StringBuffer();
        form1=new Form("Data Receiver");
        //TextBox tb=null;
        //tb.addCommand(bak);
        //tb.setCommandListener(this);
        //TextField textBox = null;
        bak=new Command("rBack",Command.BACK,0);
       // enter=new Command("Enter",Command.OK,4);
        form1.addCommand(bak);
        //form1.addCommand(enter);
        form1.setCommandListener(this);
        //form1.append(textBox);
        try {
          connection = (HttpConnection)Connector.open(url);
          connection.setRequestMethod(HttpConnection.GET);
          connection.setRequestProperty("IF-Modified-Since","20 Jan 2001 16:19:14 GMT");
          connection.setRequestProperty("User-Agent","Profile/MIDP-2.0 Confirguration/CLDC-1.0");
          connection.setRequestProperty("Content-Language", "en-CA");
          connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
          os = connection.openOutputStream();
          is = connection.openDataInputStream();
          int ch;
          while ((ch = is.read()) != -1) {
            stringBuffer.append((char) ch);
          }
          String ds=stringBuffer.toString();
          //tb= new TextBox("Challenge",ds,1024,0);
          form1.append(new StringItem("",ds) );
          //form1.append(new StringItem("Responce2","") );
        } finally {
           if(is!= null) {
              is.close();
           }
           if(os != null) {
              os.close();
           }
           if(connection != null) {
              connection.close();
           }
        }
        display.setCurrent(form1);
    }
    
    
   public void commandAction(Command c, Displayable d) {
     String label = c.getLabel();
      // if(label.equals("Exit"))
      if (c==exitCommand) {
         destroyApp(true);   
      } 
      else if(label.equals("Option")){
         List down = (List)display.getCurrent();
         switch(down.getSelectedIndex()) {
           case 0: testItem1();break;
           //case 1: testItem2();break;
           case 2: testItem3();break;
           /*case 3: testItem4();break;
           case 4: testItem5();break;*/    
         }}
      else if(label.equals("aBack")){
            mainMenu();
       }
      else if (c==backCommand) {
         // if(currentMenu.equals("Start shopping") || currentMenu.equals("Order confirmation") ||
           //  currentMenu.equals("My account") || currentMenu.equals("Order information")||currentMenu.equals("Change password"))  {
            // go back to menu
              mainMenu();
           
      }
    else if(label.equals("aView")){
         List accinfo=(List)display.getCurrent();
         switch(accinfo.getSelectedIndex()){
             case 0:{
             accInfo();
             break;
             }
             case 1:{
            editAcc();
             break;
             }
             case 2:{
               
              break;
             }
             case 3:{
             Alert b=new Alert("Alert","Electrical Selected",null,AlertType.WARNING);
             break;
             }
         
         
         }
      }
      else if(label.equals("iBack")){
            account();
       }
      else if(label.equals("eBack")){
            account();
      }
      else if(label.equals("View")){
         List seto=(List)display.getCurrent();
         switch(seto.getSelectedIndex()){
             case 0:{
             prod();
             break;
             }
             case 1:{
            //electrical();
             break;
             }
             case 2:{
              // grocery();
              break;
             }
             case 3:{
             Alert b=new Alert("Alert","Electrical Selected",null,AlertType.WARNING);
             break;
             }
         
         
         }
      }
       else if(c==edback){
            prepare();
       }
       else if(label.equals("Submitt")){
           bran();
       }
      /*else if(label.equals("Select")){
         List lap=(List)display.getCurrent();
         switch(lap.getSelectedIndex()){
             case 0:{
             bran();
             break;
             }
             case 1:{
            //music();
             break;
             }
             case 2:{
             //phones();
              break;
             }
         }
       }*/
      else if(label.equals("Bak")){
            prod();
       }
         else if(label.equals("mBack")){
            prod();
       }
          else if(label.equals("pBack")){
            prod();
          }
      else if(label.equals("Cancel")){
         prepare();
      }
      else if(label.equals("Enter")){
         //url="http://127.0.0.1/project/mobile.php?type="+ itemno.getString();
          url="http://localhost:8888/project/mobile.php?type="+itemno.getString();
           try{
           testGET(url);
           
           }catch(Exception ee){
           System.out.print(ee.getMessage());
           }
          } 
                
      else if(label.equals("rBack")){
          
        display.setCurrent(product);
        }
      else{
         
         }
            
      }
     
}
