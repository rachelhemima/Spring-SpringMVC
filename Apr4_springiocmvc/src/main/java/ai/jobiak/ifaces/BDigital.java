package ai.jobiak.ifaces;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BDigital {
 Printable printable;
PackingIface packing;

//constructor
public BDigital(PackingIface packing) {
	this.packing = packing;
}

public BDigital() {
}

public Printable getPrintable() {
	return printable;
}

public void setPrintable(Printable printable) {
	this.printable = printable;
}
 public void publish()
 {
	 printable.print();
	 packing.doPacking();
 }
 @PostConstruct
 public void doInit()
 {
	 System.out.println("from inti().....");
 }
 @PreDestroy
 public void doDestroy()
 {
	 System.out.println("from destroy().....");
 }
 
}
