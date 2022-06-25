package timekiller;


import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeKiller extends JFrame implements Runnable {

    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    
    String typed="";
    
    boolean invenOpen;
    
    CurrentRoom currentRoom;
    Character character;
    Inventory inventory;
    Item bottle;
    
    static TimeKiller frame;
    public static void main(String[] args) {
        frame = new TimeKiller();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public TimeKiller() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    //left button

                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                    reset();
                }
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
       // repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
          
       // repaint();
      }
    });

        addKeyListener(new KeyAdapter() {
// Character walk directions
            @Override
            public void keyPressed(KeyEvent e) {
               
//                switch(v) {
//                    case 7:
//                        print();
//                        break;
//                    case 53:
//                        blah();
//                        break;
//                    default:
//                        break;
//                }
//                
//                
                if (e.VK_UP == e.getKeyCode()) {
                    character.walk=1;
                    character.time=0;
                } else if (e.VK_DOWN == e.getKeyCode()) {
                    character.walk=2;
                    character.time=0;
                } else if (e.VK_LEFT == e.getKeyCode()) {
                    character.walk=3;
                    character.time=0;
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                    character.walk=4;
                    character.time=0;
                } else if (e.VK_TAB== e.getKeyCode())
                {
                    System.out.println("Inventory");
                    if (invenOpen==false)
                        invenOpen=true;
                    else
                        invenOpen=false;
                }
                
                
                
                
                
                
                
                else if (e.VK_A == e.getKeyCode()) {
                   addLetter("a");
                }
                else if (e.VK_B == e.getKeyCode()) {
                   addLetter("b");
                }
                else if (e.VK_C == e.getKeyCode()) {
                   addLetter("c");
                }
                else if (e.VK_D == e.getKeyCode()) {
                   addLetter("d");
                }
                else if (e.VK_E == e.getKeyCode()) {
                   addLetter("e");
                }
                else if (e.VK_F == e.getKeyCode()) {
                   addLetter("f");
                }
                else if (e.VK_G == e.getKeyCode()) {
                   addLetter("g");
                }
                else if (e.VK_H == e.getKeyCode()) {
                   addLetter("h");
                }
                else if (e.VK_I == e.getKeyCode()) {
                   addLetter("i");
                }
                else if (e.VK_J == e.getKeyCode()) {
                   addLetter("j");
                }
                else if (e.VK_K == e.getKeyCode()) {
                   addLetter("k");
                }
                else if (e.VK_L == e.getKeyCode()) {
                   addLetter("l");
                }
                else if (e.VK_M == e.getKeyCode()) {
                   addLetter("m");
                }
                else if (e.VK_N == e.getKeyCode()) {
                   addLetter("n");
                }
                else if (e.VK_O == e.getKeyCode()) {
                   addLetter("o");
                }
                else if (e.VK_P == e.getKeyCode()) {
                   addLetter("p");
                }
                else if (e.VK_Q == e.getKeyCode()) {
                   addLetter("q");
                }
                else if (e.VK_R == e.getKeyCode()) {
                   addLetter("r");
                }
                else if (e.VK_S == e.getKeyCode()) {
                   addLetter("s");
                }
                else if (e.VK_T == e.getKeyCode()) {
                   addLetter("t");
                }
                else if (e.VK_U == e.getKeyCode()) {
                   addLetter("u");
                }
                else if (e.VK_V == e.getKeyCode()) {
                   addLetter("v");
                }
                else if (e.VK_W == e.getKeyCode()) {
                   addLetter("w");
                }
                else if (e.VK_X == e.getKeyCode()) {
                   addLetter("x");
                }
                else if (e.VK_Y == e.getKeyCode()) {
                   addLetter("y");
                }
                else if (e.VK_Z == e.getKeyCode()) {
                   addLetter("z");
                }
                else if (e.VK_SPACE == e.getKeyCode()) {
                   addLetter(" ");
                }
                else if (0x8/*backspace*/ == e.getKeyCode()) {
                   typed=typed.substring(0, typed.length()-1);
                }
                
            }
            
            @Override
            public void keyReleased(KeyEvent e)
            {
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }

 

////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        g.setColor(Color.black);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
        

// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }

        currentRoom.Draw(g, this);
        character.Draw(g,this);
        
        if(invenOpen==true)
            inventory.Draw(g, this);
        
        bottle.Draw(g, this);

        
        g.setColor(Color.red);
        g.drawString(""+character.ypos, 100, 100);
        g.drawString(""+character.xpos, 50, 100);
        
        
        g.setColor(Color.black);
        g.setFont (new Font ("Engravers MT",Font.PLAIN, 15));
        g.drawString(typed, 200, 100);
        
        gOld.drawImage(image, 0, 0, null);
        
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = 0.02;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        invenOpen=false;
        currentRoom = new CurrentRoom();
        character = new Character(); 
        inventory = new Inventory(); 
        bottle = new Item();
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            reset();
        }
        
       character.animate();
       character.CurrentImage();
       currentRoom.RoomSet();
       currentRoom.Door(character.xpos, character.ypos);
       bottle.HitBox(character.xpos, character.ypos);
       
       if(currentRoom.isTransition==true){
            character.ypos-=10;
            currentRoom.Time();
       }
        
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
    
    
    
    
    
    
    
    public void addLetter(String letter){
        typed+=letter;
        System.out.print(letter);
    }

    
    
    
    
    
    
    
    
    
    
    
    
}


class Window {
    
    static Dimension sz = Toolkit.getDefaultToolkit().getScreenSize();

    
    static final int WINDOW_WIDTH = 1280;
    static final int WINDOW_HEIGHT = 720;
    static final int XBORDER = 0;
    static final int YBORDER = 0;
    static final int WINDOW_BORDER = 0;
    static final int YTITLE = 0;
    static int xsize = -1;
    static int ysize = -1;   
    
 /////////////////////////////////////////////////////////////////////////
    public Window(){
        if (WINDOW_WIDTH!=1920){
            
        }
        //1080
        
    }
    public static int getX(int x) {
        return (x + XBORDER);
    }

    public static int getY(int y) {
        return (y + YBORDER + YTITLE);
    }

    public static int getYNormal(int y) {
        return (-y + YBORDER + YTITLE + getHeight2());
    }
    
    
    public static int getWidth2() {
        return (xsize - getX(0) - XBORDER);
    }

    public static int getHeight2() {
        return (ysize - getY(0) - YBORDER);
    }    
}

class Character {
    private static Image CharacterImage;
    int xpos;
    int ypos;
    int walk;
    boolean IsLeft;
    int time;

    Character()
    {
// Sets character beginning location
        xpos = Window.getWidth2()/2;
        ypos = 200;
        IsLeft=false;
        time=25;
    }
   
    public void Draw(Graphics2D g,TimeKiller thisObj)
    {
        drawImage(g,thisObj,CharacterImage,Window.getX(xpos),Window.getYNormal(ypos),0.0,10.0,10.0 );

    }
    public void drawImage(Graphics2D g,TimeKiller thisObj,Image image,int xpos,int ypos,double rot,double xscale,double yscale) {
        int width = image.getWidth(thisObj);
        int height = image.getHeight(thisObj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,thisObj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }    
    public void animate ()
    {
//Sets the direction character is facing and moves character when key pressed
         if (walk==1&&ypos<405)
        {
            ypos+=5;
            walk=0;
        }
         else if (walk==2)
        {
            ypos-=5;
            walk=0;
        }
         else if (walk==3)
        {
            IsLeft=false;
            xpos-=5;
            walk=0;
        }
         else if (walk==4)
        {
            IsLeft=true;
            xpos+=5;
            walk=0;
        }
//Time used to stop animations when stopped walking
         time++;
    }
    
    
    public void CurrentImage (){
        
//Character current sprite used when standing & walking
        if (time>=10)
        {
            if(IsLeft==true)
                CharacterImage = Toolkit.getDefaultToolkit().getImage("./ManStandingLeft.PNG");
            else 
                CharacterImage = Toolkit.getDefaultToolkit().getImage("./ManStandingRight.PNG");
        }
        else
        {
            if(IsLeft==true)
                CharacterImage = Toolkit.getDefaultToolkit().getImage("./ManAnimationLeft.GIF");
            else 
                CharacterImage = Toolkit.getDefaultToolkit().getImage("./ManAnimationRight.GIF");
        }
    }
}

class CurrentRoom {
    boolean isTransition;
    Image CurrentRoom;
    Image Transition;
    int RoomNumber;
    int time;


    
    CurrentRoom(){
        isTransition=false;
        Transition = Toolkit.getDefaultToolkit().getImage("./Transition.jpg");
        CurrentRoom = Toolkit.getDefaultToolkit().getImage("./Bedroom.jpg");
    }
    public void Draw(Graphics2D g,TimeKiller thisObj){
//Changes the size of the rooms when changing (may be able to be removed later if all images same size)
        if (isTransition==true)
            drawImage(g,thisObj,Transition,Window.getWidth2()/2,Window.getHeight2()/2,0.0,2.0,2.0 );

        else
            drawImage(g,thisObj,CurrentRoom,Window.getWidth2()/2,Window.getHeight2()/2,0.0,2.0,2.0 );

    }
    public void drawImage(Graphics2D g,TimeKiller thisObj,Image image,int xpos,int ypos,double rot,double xscale,double yscale) {
        int width = image.getWidth(thisObj);
        int height = image.getHeight(thisObj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,thisObj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }    
    public void RoomSet(){
        if (RoomNumber==0){
            CurrentRoom = Toolkit.getDefaultToolkit().getImage("./RoomOne.jpg");
        }
        else if (RoomNumber==1){
            CurrentRoom = Toolkit.getDefaultToolkit().getImage("./Bedroom.jpg");
        }
        else if (RoomNumber==2){
            CurrentRoom = Toolkit.getDefaultToolkit().getImage("./Bathroom.jpg");
        }
            
    }
    public void Time(){
        if (time==25){
            isTransition=false;
            time=0;
        }
        
        time++;
    }
    public void Door(int xpos, int ypos){
//Door location based off room number (maybe want to make a seperate class for this)
        if (xpos>=1005&&xpos<=1095&&ypos==405){
            if (RoomNumber==0){
                isTransition=true;
                RoomNumber=1;            
            }
            else if (RoomNumber==1){
                isTransition=true;
                RoomNumber=0;
            }
        }
        else if (xpos>=180&&xpos<=270&&ypos==405){
            if (RoomNumber==0){
                isTransition=true;
                RoomNumber=2;
            }
            else if (RoomNumber==2){
                isTransition=true;
                RoomNumber=0; 
            }
    }
    }
}
class Inventory {
        Image InvenImage;

    
    Inventory(){
            InvenImage = Toolkit.getDefaultToolkit().getImage("./Inventory.jpg");
    }
    public void Draw(Graphics2D g,TimeKiller thisObj){
            drawImage(g,thisObj,InvenImage,Window.getWidth2()/2,Window.getHeight2()/2,0.0,1.0,1.0 );
    }
    public void drawImage(Graphics2D g,TimeKiller thisObj,Image image,int xpos,int ypos,double rot,double xscale,double yscale) {
        int width = image.getWidth(thisObj);
        int height = image.getHeight(thisObj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,thisObj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }    
}

class Item {
        Image ItemImage;
        Image PickUp;
        static int Xpos;
        static int Ypos;
        boolean PickUpItem;
    
    Item(){
            PickUpItem=false;
            Xpos=600;
            Ypos=500;
            ItemImage = Toolkit.getDefaultToolkit().getImage("./bottle.png");
            PickUp = Toolkit.getDefaultToolkit().getImage("./pressE.png");
    }
    public void Draw(Graphics2D g,TimeKiller thisObj){
            drawImage(g,thisObj,ItemImage,Xpos,Ypos,0.0,0.1,0.1 );
            
            if (PickUpItem==true)
            drawImage(g,thisObj,PickUp,Xpos-75,Ypos-100,0.0,4.0,4.0 );
    }
    public void drawImage(Graphics2D g,TimeKiller thisObj,Image image,int xpos,int ypos,double rot,double xscale,double yscale) {
        int width = image.getWidth(thisObj);
        int height = image.getHeight(thisObj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,thisObj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }  
    
    public void HitBox (int CharacterX, int CharacterY){
        if (CharacterX < Xpos + 100 &&
            CharacterX > Xpos - 100 &&
            CharacterY+150 < Ypos  &&
            CharacterY+150 > Ypos - 100){
            PickUpItem=true;
            System.out.println("ur mom");

        }
        else
            PickUpItem=false;
    }
    
    
    
    

}
//Xpos+20>=CharacterX&&Ypos+20>=CharacterX||
//            Xpos-20<=CharacterX&&Ypos+20>=CharacterX||
//            Xpos+20>=CharacterX&&Ypos-20<=CharacterX||
//            Xpos-20<=CharacterX&&Ypos-20<=CharacterX
