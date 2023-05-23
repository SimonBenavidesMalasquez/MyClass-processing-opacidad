package mylibrary.Opacidad;


//import processing.core.*;



public class Clase_Opacidad {
	
	// myParent is a reference to the parent sketch
	//PApplet myParent;

    // Variables basicas : 
    private double        ang = 0.0 ;
    private double      valor = 0.0 ;
    public     int     salida =   0 ;  
    private    int        inc =   3 ;
    private boolean activador = false ;
    private int   tipo_salida = 1 ;  //  Salida normal ( 0 - 250 )
    private double   velocity = 0.05 ;

	public Clase_Opacidad(  String tipo ) {
		
		// Initialize
		//myParent = theParent;
		
        // POR DEFECTO 
        valor       = 0.0 ;
        salida      = 0 ;
        tipo_salida = 1 ;

        // AUMENTA : BUCLE
        if( tipo.equals("0-250") == true ){
    
          valor       = 0.0 ;
          salida      = 0 ;
          tipo_salida = 1 ;

        // AUMENTA : CON ACTIVADOR 
        }else if( tipo.equals("150-255") == true ){ 
    
           valor       = 255.0 ;
           salida      = 255 ; 
           tipo_salida = 2 ;
        
        }
        
        // MENSAJE LIBRERIA 
        //System.out.println("Load Library Simon : Clase_Opacidad / 11-may-2022" );
		
	}
	
    public void bucle() {                              

        // VELOCIDAD : 
        incremento();

        // REINICIA CUENTA :
        reinicia_cuenta();

        // EJECUTA FUNCION SENO : 
        switch( tipo_salida ){     

             case 1 : funcion_seno();          break ;
             case 2 : funcion_efecto_rampa(); break ; 

        }

   }
	
    // -------------------------------------------------------------------
    //                            ABSTRACCION CODE 
    public void funcion_efecto_rampa(){

        // 1. ACTIVA , PONE VARIABLE A INICIO
        if( activador == true ){
       
            salida = 50 ; 

        // 2. AL PONER OFF , QUEDA HABILITADO INCREMENTO DE 150 > 255
        }else if( activador == false ){ 

            if( ( salida + inc ) <= 255 ){
                salida = salida + inc ;
            }
            
        }

    }
	
    // ACTIVADOR : ON                ** USAR CUANDO SEA : TRUE
    public void setOn(){
        activador = true ;
    }

    // ACTIVADOR : OFF               ** USAR CUANDO SEA : FALSE
    public void setOff(){
         activador = false ;
    }

    public void incremento(){
	      ang = ang + velocity ;
    }

    public void funcion_seno(){
	      
  	  double valor = Math.abs( 150*Math.sin( ang ) + 100 );
  	  
        salida = (int) valor ;

    }

    public void reinicia_cuenta(){
	
        if ( ang > Math.PI ) {
           ang = 0.0;
        }
    }

    // SALIDA DE VARIABLE : 
    public int getValue(){
    
        return salida ;
    }

    public void setInc( int incremento ){

        inc = incremento ;
    }       
    
    public void setVelocity( double valor ) {
    	
    	velocity = valor ;
    	
    }


}











