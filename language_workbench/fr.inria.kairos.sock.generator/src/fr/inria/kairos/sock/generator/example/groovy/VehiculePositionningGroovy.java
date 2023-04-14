package fr.inria.kairos.sock.generator.example.groovy;

public class VehiculePositionningGroovy {
	
	public static final String VEHICULE_POSITIONING_GROOVY_SCRIPT = 
			"import fr.inria.kairos.sock.dsl.attacks.butterfly.VehiculPositionning;\n" +
			"import fr.inria.kairos.sock.utils.IOUtils;\n" +
			"IOUtils.PATH_OUTPUT = outputFolder;\n" +
			"VehiculPositionning.instance.order(time);\n";;
	
	public static String getVehiculePositionningGroovyScript() {
		return (VEHICULE_POSITIONING_GROOVY_SCRIPT).replace("\"","'");
	}
	
}
