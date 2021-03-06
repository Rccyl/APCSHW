import java.util.Random;
public class Rogue extends Adventurer{
    
    private int stamina;

    public Rogue(String s){
	super(s,25,8,8,8);
	stamina=this.getDex()*2;
    }
    public Rogue(){
	this("Dair");
    }

    public String getStats(){
	return "Rogue"+"\n"
	    +super.getStats()+"\n"
	    +"Stam: "+stamina; 
    }

    public void attack(Adventurer other){
	System.out.println(this.getName() + " attacks " + other.getName());
	if (hit(other)){
	    Random rand = new Random();
	    int damage = rand.nextInt(this.getStr()/2)+2;
	    other.setHP(other.getHP()-damage);
	    System.out.println("And deals "+damage+" points of damage");
	}else{
	    System.out.println("But misses");
	}
	stamina-=2;    }

    public void specialAttack(Adventurer other){
	if (stamina>=8){
	    System.out.println(this.getName()+" eviscerates "+other.getName());
	    if (hit(other)||hit(other)){
		Random rand = new Random();
		int damage = rand.nextInt(this.getStr()-6)+8;
		other.setHP(other.getHP()-damage);
		System.out.println("And deals "+damage+" points of damage");
	    }else{
		System.out.println("But misses");
	    }  
	    stamina-=8;
	}else{
	    System.out.println(this.getName()+" does not poessess enough stamina to eviserate "+other.getName());
	    System.out.println("Instead");
	    attack(other);
	}
    }
}
